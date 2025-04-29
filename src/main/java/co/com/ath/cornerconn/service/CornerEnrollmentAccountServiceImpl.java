package co.com.ath.cornerconn.service;

import co.com.ath.commons.util.ATHException;
import co.com.ath.commons.util.Util;
import co.com.ath.cornerconn.constants.ResponseServiceEnum;
import co.com.ath.cornerconn.models.HttpResponseWrapper;
import co.com.ath.cornerconn.models.enrollment.EnrollmentRq;
import co.com.ath.cornerconn.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class CornerEnrollmentAccountServiceImpl implements ICornerEnrollmentAccountService {

    UriUtil uriUtil = new UriUtil();

    /**
     * Instancia de la clase HeadersUtil
     */
    HeadersUtil headersUtil = new HeadersUtil();

    /**
     * Intancia de la clase TimeOutUtil
     */
    TimeOutUtil timeOutUtil = new TimeOutUtil();

    /**
     * Instancia de la clase TransformationUtil
     */
    TransformationUtil transformationUtil = new TransformationUtil();

    @Override
    public HttpResponseWrapper enrollmentKeyService(EnrollmentRq req, String uriConnection, int serviceTimeOut) throws URISyntaxException, IOException, InterruptedException {

        log.info("Se ingresa al servicio Post");
        log.info("URI de conexión a Camara Corner: {}", uriConnection);

        try (CloseableHttpClient client = CertificadoUtil.buildClient()) {
            HttpPost httpPost = new HttpPost(uriConnection);
            timeOutUtil.setUpTimeOut(serviceTimeOut, httpPost);

            StringEntity entity = new StringEntity(Util.object2String(TransformationUtil.transformEnrollmentRq(req)),
                    ContentType.TEXT_PLAIN.withCharset(StandardCharsets.UTF_8));

            httpPost.setEntity(entity);

            try (CloseableHttpResponse closeableHttpResponse = client.execute(httpPost)) {
                return new HttpResponseWrapper(EntityUtils.toString(closeableHttpResponse.getEntity()),
                        closeableHttpResponse.getStatusLine().getStatusCode());
            }
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException conExp) {
            throw new ATHException(ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getServerStatusCode(),
                    ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusDesc(),
                    ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusCode());
        }
    }
}
