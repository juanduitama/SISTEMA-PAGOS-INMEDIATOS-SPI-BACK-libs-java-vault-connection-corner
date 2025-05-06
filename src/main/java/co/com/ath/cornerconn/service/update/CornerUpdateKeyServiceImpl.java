package co.com.ath.cornerconn.service.update;

import co.com.ath.commons.util.ATHException;
import co.com.ath.commons.util.Util;
import co.com.ath.cornerconn.constants.ResponseServiceEnum;
import co.com.ath.cornerconn.models.CornersHeadersRq;
import co.com.ath.cornerconn.models.HttpResponseWrapper;
import co.com.ath.cornerconn.models.update.CornerUpdateRq;
import co.com.ath.cornerconn.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class CornerUpdateKeyServiceImpl implements ICornerUpdateKeyService {

    /**
     * Instancia de la clase UriUtil
     */
    private final UriUtil uriUtil = new UriUtil();


    /**
     * Instancia HeadersUtil
     */
    private final HeadersUtil headersUtil = new HeadersUtil();


    /**
     * Instancia del transformatión util
     */
    private final TransformationUtil transformationUtil = new TransformationUtil();

    /**
     * Instancia del timeOutUtil
     */
    private final TimeOutUtil timeOutUtil = new TimeOutUtil();


    /**
     *
     * @param cornerUpdateRq
     * @param keyValue
     * @param cornersHeadersRq
     * @param uriConnection
     * @param serviceTimeOut
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */

    @Override
    public HttpResponseWrapper updateKey(CornerUpdateRq cornerUpdateRq, String keyValue, CornersHeadersRq cornersHeadersRq, String uriConnection, int serviceTimeOut) throws URISyntaxException, IOException, InterruptedException {
        URI newUri = (uriUtil.buildStringToUriKey(uriConnection, keyValue));

        log.info("URI de conexion a camara Corner (Update/Key): {}", newUri);

        try (CloseableHttpClient client = CertificadoUtil.buildClient()) {

            HttpPut httpPut = new HttpPut(String.valueOf(newUri));

            //headersUtil.addUpdateHeaders(httpPut, updateHeaders);

            timeOutUtil.setUpTimeOut(serviceTimeOut, httpPut);

            StringEntity entity = new StringEntity(Util.object2String(TransformationUtil
                    .transformUpdateKeyRq(cornerUpdateRq)),
                    ContentType.TEXT_PLAIN.withCharset(StandardCharsets.UTF_8));

            httpPut.setEntity(entity);

            try (CloseableHttpResponse closeableHttpResponse = client.execute(httpPut)) {
                return new HttpResponseWrapper(EntityUtils.toString(closeableHttpResponse.getEntity()),
                        closeableHttpResponse.getStatusLine().getStatusCode());
            }

        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | IllegalArgumentException | ConnectTimeoutException e) {
            throw new ATHException(ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getServerStatusCode(),
                    ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusDesc(),
                    ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusCode());
        }
    }

    /**
     *
     * @param cornerUpdateRq
     * @param keyValue
     * @param cornersHeadersRq
     * @param uriConnection
     * @param serviceTimeOut
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public HttpResponseWrapper updateKeyStatus(CornerUpdateRq cornerUpdateRq, String keyValue, CornersHeadersRq cornersHeadersRq, String uriConnection, int serviceTimeOut) throws URISyntaxException, IOException, InterruptedException {
        URI newUri = (uriUtil.buildStringToUriKey(uriConnection, keyValue));
        log.info("URI Entrante " + newUri);
        log.info("URI de conexion a camara Redeban (Update/Key): {}", newUri);


        try (CloseableHttpClient client = CertificadoUtil.buildClient()) {

            HttpPut httpPut = new HttpPut(String.valueOf(newUri));

            //headersUtil.addUpdateHeaders(httpPut, updateHeaders);

            timeOutUtil.setUpTimeOut(serviceTimeOut, httpPut);

            StringEntity entity = new StringEntity(Util.object2String(TransformationUtil
                    .transformUpdateStatusKeyRq(cornerUpdateRq)),
                    ContentType.TEXT_PLAIN.withCharset(StandardCharsets.UTF_8));

            httpPut.setEntity(entity);

            try (CloseableHttpResponse closeableHttpResponse = client.execute(httpPut)) {
                return new HttpResponseWrapper(EntityUtils.toString(closeableHttpResponse.getEntity()),
                        closeableHttpResponse.getStatusLine().getStatusCode());
            }

        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | IllegalArgumentException | ConnectTimeoutException e) {
            throw new ATHException(ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getServerStatusCode(),
                    ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusDesc(),
                    ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusCode());
        }
    }
}
