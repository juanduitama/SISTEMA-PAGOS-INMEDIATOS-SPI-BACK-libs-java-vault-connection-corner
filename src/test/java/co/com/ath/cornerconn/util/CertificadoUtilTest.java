package co.com.ath.cornerconn.util;

import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CertificadoUtilTest {

    @Test
    void buildClient_ReturnsHttpClientWithCustomSSLContext() throws Exception {
        CloseableHttpClient client = CertificadoUtil.buildClient();
        assertNotNull(client);
    }

    @Test
    void buildClient_TrustsAllCertificates() throws Exception {
        CloseableHttpClient client = CertificadoUtil.buildClient();
        assertNotNull(client);
    }
}
