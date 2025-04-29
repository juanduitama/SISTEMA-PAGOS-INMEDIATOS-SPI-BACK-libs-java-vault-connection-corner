package co.com.ath.cornerconn.service.inquiries;

import co.com.ath.commons.util.ATHException;
import co.com.ath.commons.util.Util;
import co.com.ath.cornerconn.constants.ResponseServiceEnum;
import co.com.ath.cornerconn.models.CornersHeadersRq;
import co.com.ath.cornerconn.models.HttpResponseWrapper;
import co.com.ath.cornerconn.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class CornerInquiriesKeyServiceImpl implements  ICornerInquiriesKeyService{

    /**
     * Instancia de la clase UriUtil
     */
    private final UriUtil uriUtil = new UriUtil();

    /**
     * Instancia del timeOutUtil
     */
    private final TimeOutUtil timeOutUtil = new TimeOutUtil();

    /**
     * Método que permite realizar el consumo de la Api de consulta de una llave por su keyValue,
     * se envía  valor de la llave, la uri de conexión, se hace uso de método GET para
     * finalmente poder obtener respuesta de la consulta.
     *
     * @param keyValue     identificador de la llave que se va a consultar
     * @param uriConnection información de la url que se consume
     * @param serviceTimeOut tiempo de espera para la respuesta
     * @return Respuesta de la consulta
     * @throws URISyntaxException   Si se presenta un error en la sintáxis de la URI
     * @throws IOException          Si se presenta un error en la conexión
     * @throws InterruptedException Si se interrumpe el proceso
     */
    @Override
    public HttpResponseWrapper keyInquiryRs(String keyValue, CornersHeadersRq cornersHeadersRq,
                                                    String uriConnection, int serviceTimeOut)
            throws URISyntaxException, IOException, InterruptedException {

        String newUri = Util.object2String(uriUtil.buildStringToUriKey(uriConnection, keyValue));

        log.info("URI de conexion a camara Redeban (KeyInquiry/Directory): {}", newUri);


        try (CloseableHttpClient client = CertificadoUtil.buildClient()) {

            HttpGet httpGet = new HttpGet(newUri);
            //headersUtil.addInquiriesHeaders(httpGet, headers);
            timeOutUtil.setUpTimeOut(serviceTimeOut, httpGet);

            try (CloseableHttpResponse closeableHttpResponse = client.execute(httpGet)) {
                return new HttpResponseWrapper(EntityUtils.toString(closeableHttpResponse.getEntity()),
                        closeableHttpResponse.getStatusLine().getStatusCode());
            }

        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            throw new ATHException(ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getServerStatusCode(),
                    ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusDesc(),
                    ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusCode());
        }

    }


    /**
     * Método que permite realizar el consumo de la Api de consulta de una llave por su handleId,
     * se envía identificador del tipo de llave, valor de la llave, encabezados y la
     * uri de conexión, se hace uso de método GET para finalmente poder obtener respuesta de la consulta.
     *
     * @param uriConnection información de la url que se consume
     * @param serviceTimeOut tiempo de espera para la respuesta
     * @return Respuesta de la consulta
     * @throws URISyntaxException   Si se presenta un error en la sintáxis de la URI
     * @throws IOException          Si se presenta un error en la conexión
     * @throws InterruptedException Si se interrumpe el proceso
     */
    @Override
    public HttpResponseWrapper keysInquirysRs(String uriConnection, CornersHeadersRq cornersHeadersRq, int serviceTimeOut)
            throws URISyntaxException, IOException, InterruptedException {


        try (CloseableHttpClient client = CertificadoUtil.buildClient()) {

            HttpGet httpGet = new HttpGet(uriConnection);
            //headersUtil.addInquiriesHeaders(httpGet, headers);
            timeOutUtil.setUpTimeOut(serviceTimeOut, httpGet);

            try (CloseableHttpResponse closeableHttpResponse = client.execute(httpGet)) {
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
