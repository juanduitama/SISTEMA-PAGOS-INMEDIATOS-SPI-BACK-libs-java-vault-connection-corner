package co.com.ath.cornerconn.service.inquiries;

import co.com.ath.commons.util.ATHException;
import co.com.ath.commons.util.Util;
import co.com.ath.cornerconn.constants.ResponseServiceEnum;
import co.com.ath.cornerconn.models.CornersHeadersRq;
import co.com.ath.cornerconn.models.HttpResponseWrapper;
import co.com.ath.cornerconn.util.*;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CornerInquiriesKeyServiceImplTest {

    @InjectMocks
    private CornerInquiriesKeyServiceImpl cornerInquiriesKeyService;

    @Mock
    private UriUtil uriUtil;

    @Mock
    private TimeOutUtil timeOutUtil;

    @Mock
    private CloseableHttpClient httpClient;

    @Mock
    private CloseableHttpResponse httpResponse;

    @Mock
    private StatusLine statusLine;

    @BeforeEach
    public void setUp() {
        // Inyectamos manualmente los mocks en las propiedades privadas finales
        try {
            Field uriUtilField = CornerInquiriesKeyServiceImpl.class.getDeclaredField("uriUtil");
            uriUtilField.setAccessible(true);
            uriUtilField.set(cornerInquiriesKeyService, uriUtil);

            Field timeOutUtilField = CornerInquiriesKeyServiceImpl.class.getDeclaredField("timeOutUtil");
            timeOutUtilField.setAccessible(true);
            timeOutUtilField.set(cornerInquiriesKeyService, timeOutUtil);
        } catch (Exception e) {
            fail("Error configurando los mocks: " + e.getMessage());
        }
    }

    @Test
    public void keyInquiryRs_Success() throws URISyntaxException, IOException, InterruptedException,
            NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        // Arrange
        String keyValue = "testKey123";
        CornersHeadersRq cornersHeadersRq = new CornersHeadersRq();
        cornersHeadersRq.setContentType("application/json");
        String uriConnection = "http://example.com/api/dict/directory-keys/{key_id}";
        int serviceTimeOut = 30000;

        String expectedUriString = "http://example.com/api/dict/directory-keys/testKey123";
        String expectedResponse = "{\"status\":\"ACTIVE\",\"key\":\"testKey123\"}";
        int expectedStatusCode = 200;

        // Mock para buildStringToUriKey - retornamos un URI
        URI mockUri = new URI(expectedUriString);
        when(uriUtil.buildStringToUriKey(uriConnection, keyValue)).thenReturn(mockUri);

        // Mock para Util.object2String y CertificadoUtil.buildClient()
        try (MockedStatic<Util> utilMock = mockStatic(Util.class);
             MockedStatic<CertificadoUtil> certMock = mockStatic(CertificadoUtil.class)) {

            // CLAVE: Aseguramos que retorne la URL sin comillas
            utilMock.when(() -> Util.object2String(any(URI.class))).thenReturn(expectedUriString);

            // Mock para CertificadoUtil.buildClient()
            certMock.when(CertificadoUtil::buildClient).thenReturn(httpClient);

            // Mock para las respuestas HTTP
            when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
            when(httpResponse.getEntity()).thenReturn(new StringEntity(expectedResponse));
            when(httpResponse.getStatusLine()).thenReturn(statusLine);
            when(statusLine.getStatusCode()).thenReturn(expectedStatusCode);

            // Act
            HttpResponseWrapper result = cornerInquiriesKeyService.keyInquiryRs(keyValue, cornersHeadersRq, uriConnection, serviceTimeOut);

            // Assert
            assertNotNull(result);
            assertEquals(expectedResponse, result.getResponseBody());
            assertEquals(expectedStatusCode, result.getStatusCode());

            // Verify
            verify(uriUtil).buildStringToUriKey(uriConnection, keyValue);
            verify(timeOutUtil).setUpTimeOut(eq(serviceTimeOut), any(HttpGet.class));
            verify(httpClient).execute(any(HttpGet.class));
            utilMock.verify(() -> Util.object2String(mockUri));
        }
    }

    @Test
    public void keysInquirysRs_Success() throws URISyntaxException, IOException, InterruptedException,
            NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        // Arrange
        CornersHeadersRq cornersHeadersRq = new CornersHeadersRq();
        cornersHeadersRq.setContentType("application/json");
        String uriConnection = "http://example.com/api/dict/directory-keys";
        int serviceTimeOut = 30000;

        String expectedResponse = "[{\"key\":\"testKey123\",\"status\":\"ACTIVE\"},{\"key\":\"testKey456\",\"status\":\"ACTIVE\"}]";
        int expectedStatusCode = 200;

        // Mock para Util.object2String y CertificadoUtil.buildClient()
        try (MockedStatic<CertificadoUtil> certMock = mockStatic(CertificadoUtil.class)) {

            // Mock para CertificadoUtil.buildClient()
            certMock.when(CertificadoUtil::buildClient).thenReturn(httpClient);

            // Mock para las respuestas HTTP
            when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
            when(httpResponse.getEntity()).thenReturn(new StringEntity(expectedResponse));
            when(httpResponse.getStatusLine()).thenReturn(statusLine);
            when(statusLine.getStatusCode()).thenReturn(expectedStatusCode);

            // Act
            HttpResponseWrapper result = cornerInquiriesKeyService.keysInquirysRs(uriConnection, cornersHeadersRq, serviceTimeOut);

            // Assert
            assertNotNull(result);
            assertEquals(expectedResponse, result.getResponseBody());
            assertEquals(expectedStatusCode, result.getStatusCode());

            // Verify
            verify(timeOutUtil).setUpTimeOut(eq(serviceTimeOut), any(HttpGet.class));
            verify(httpClient).execute(any(HttpGet.class));
        }
    }
}