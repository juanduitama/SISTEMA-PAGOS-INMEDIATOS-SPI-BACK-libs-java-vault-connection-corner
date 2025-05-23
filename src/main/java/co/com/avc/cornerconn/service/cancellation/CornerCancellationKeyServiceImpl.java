package co.com.avc.cornerconn.service.cancellation;

import co.com.ath.commons.util.ATHException;
import co.com.ath.commons.util.Util;
import co.com.avc.cornerconn.constants.ResponseServiceEnum;
import co.com.avc.cornerconn.models.CornersHeadersRq;
import co.com.avc.cornerconn.models.HttpResponseWrapper;
import co.com.avc.cornerconn.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class CornerCancellationKeyServiceImpl implements ICornerCancellationKeyService{

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
    public HttpResponseWrapper deleteKey(String keyValue, CornersHeadersRq cornersHeadersRq, String uriConnection, int serviceTimeOut) throws URISyntaxException, IOException, InterruptedException {

        URI newUri = uriUtil.buildStringToUriKey(uriConnection, keyValue);

        log.info("URI de conexion a camara Corner (KeyInquiry/Directory): {}", newUri);


        try (CloseableHttpClient client = CertificadoUtil.buildClient()) {

            HttpDelete httpDelete = new HttpDelete(newUri);
            //headersUtil.addInquiriesHeaders(httpGet, headers);
            timeOutUtil.setUpTimeOut(serviceTimeOut, httpDelete);

            try (CloseableHttpResponse closeableHttpResponse = client.execute(httpDelete)) {
                return new HttpResponseWrapper(EntityUtils.toString(closeableHttpResponse.getEntity()),
                        closeableHttpResponse.getStatusLine().getStatusCode());
            }

        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            throw new ATHException(ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getServerStatusCode(),
                    ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusDesc(),
                    ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusCode());
        }
    }
}
