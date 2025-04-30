package co.com.ath.cornerconn.service.cancellation;

import co.com.ath.commons.util.ATHException;
import co.com.ath.commons.util.Util;
import co.com.ath.cornerconn.constants.ResponseServiceEnum;
import co.com.ath.cornerconn.models.CornersHeadersRq;
import co.com.ath.cornerconn.models.HttpResponseWrapper;
import co.com.ath.cornerconn.util.*;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
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
public class CornerCancellationKeyServiceImplTest {

    @InjectMocks
    private CornerCancellationKeyServiceImpl cornerCancellationKeyService;

    @Mock
    private UriUtil uriUtil;

    @Mock
    private HeadersUtil headersUtil;

    @Mock
    private TransformationUtil transformationUtil;

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
            Field uriUtilField = CornerCancellationKeyServiceImpl.class.getDeclaredField("uriUtil");
            uriUtilField.setAccessible(true);
            uriUtilField.set(cornerCancellationKeyService, uriUtil);

            Field headersUtilField = CornerCancellationKeyServiceImpl.class.getDeclaredField("headersUtil");
            headersUtilField.setAccessible(true);
            headersUtilField.set(cornerCancellationKeyService, headersUtil);

            Field transformationUtilField = CornerCancellationKeyServiceImpl.class.getDeclaredField("transformationUtil");
            transformationUtilField.setAccessible(true);
            transformationUtilField.set(cornerCancellationKeyService, transformationUtil);

            Field timeOutUtilField = CornerCancellationKeyServiceImpl.class.getDeclaredField("timeOutUtil");
            timeOutUtilField.setAccessible(true);
            timeOutUtilField.set(cornerCancellationKeyService, timeOutUtil);
        } catch (Exception e) {
            fail("Error configurando los mocks: " + e.getMessage());
        }
    }

    @Test
    public void deleteKey_Success() throws URISyntaxException, IOException, InterruptedException,
            NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        // Arrange
        String keyValue = "testKey123";
        CornersHeadersRq cornersHeadersRq = new CornersHeadersRq();
        cornersHeadersRq.setContentType("application/json");
        String uriConnection = "http://example.com/api/dict/directory-keys/{key_id}";
        int serviceTimeOut = 30000;

        String expectedUriString = "http://example.com/api/dict/directory-keys/testKey123";
        String expectedResponse = "{\"status\":\"OK\"}";
        int expectedStatusCode = 200;

        // Mock para buildStringToUriKey - retornamos un URI (como lo hace el método real)
        URI mockUri = new URI(expectedUriString);
        when(uriUtil.buildStringToUriKey(uriConnection, keyValue)).thenReturn(mockUri);

        // Mock para Util.object2String y CertificadoUtil.buildClient()
        try (MockedStatic<Util> utilMock = mockStatic(Util.class);
             MockedStatic<CertificadoUtil> certMock = mockStatic(CertificadoUtil.class)) {

            // CLAVE: El método real añade comillas, nosotros devolvemos sin comillas
            utilMock.when(() -> Util.object2String(any(URI.class))).thenReturn(expectedUriString);

            // Mock para CertificadoUtil.buildClient()
            certMock.when(CertificadoUtil::buildClient).thenReturn(httpClient);

            // Mock para las respuestas HTTP
            when(httpClient.execute(any(HttpDelete.class))).thenReturn(httpResponse);
            when(httpResponse.getEntity()).thenReturn(new StringEntity(expectedResponse));
            when(httpResponse.getStatusLine()).thenReturn(statusLine);
            when(statusLine.getStatusCode()).thenReturn(expectedStatusCode);

            // Act
            HttpResponseWrapper result = cornerCancellationKeyService.deleteKey(keyValue, cornersHeadersRq, uriConnection, serviceTimeOut);

            // Assert
            assertNotNull(result);
            assertEquals(expectedResponse, result.getResponseBody());
            assertEquals(expectedStatusCode, result.getStatusCode());

            // Verify
            verify(uriUtil).buildStringToUriKey(uriConnection, keyValue);
            verify(timeOutUtil).setUpTimeOut(eq(serviceTimeOut), any(HttpDelete.class));
            verify(httpClient).execute(any(HttpDelete.class));

            // Verificar que Util.object2String se llamó con el URI correcto
            utilMock.verify(() -> Util.object2String(mockUri));
        }
    }

    @Test
    public void deleteKey_ThrowsATHException() throws URISyntaxException, IOException, InterruptedException {
        // Arrange
        String keyValue = "testKey123";
        CornersHeadersRq cornersHeadersRq = new CornersHeadersRq();
        String uriConnection = "http://example.com/api/dict/directory-keys/{key_id}";
        int serviceTimeOut = 30000;

        String expectedUriString = "http://example.com/api/dict/directory-keys/testKey123";

        // Mock para buildStringToUriKey
        URI mockUri = new URI(expectedUriString);
        when(uriUtil.buildStringToUriKey(uriConnection, keyValue)).thenReturn(mockUri);

        // Mock para Util.object2String y CertificadoUtil.buildClient()
        try (MockedStatic<Util> utilMock = mockStatic(Util.class);
             MockedStatic<CertificadoUtil> certMock = mockStatic(CertificadoUtil.class)) {

            utilMock.when(() -> Util.object2String(any(URI.class))).thenReturn(expectedUriString);

            // Mock para CertificadoUtil.buildClient() que lanza excepción
            certMock.when(CertificadoUtil::buildClient).thenThrow(new KeyManagementException("Test exception"));

            // Act & Assert
            ATHException exception = assertThrows(ATHException.class, () -> {
                cornerCancellationKeyService.deleteKey(keyValue, cornersHeadersRq, uriConnection, serviceTimeOut);
            });

            // Verify exception details
            assertEquals(ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getServerStatusCode(), exception.getHttpCode());
            assertEquals(ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusDesc(), exception.getMessage());
            assertEquals(ResponseServiceEnum.ERROR_TEC_EXCEPTION_VAULT_CONN.getStatusCode(), exception.getErrorCode());

            // Verify
            verify(uriUtil).buildStringToUriKey(uriConnection, keyValue);
            utilMock.verify(() -> Util.object2String(mockUri));
        }
    }

    @Test
    public void deleteKey_HttpClientThrowsIOException() throws URISyntaxException, NoSuchAlgorithmException,
            KeyStoreException, KeyManagementException {
        // Arrange
        String keyValue = "testKey123";
        CornersHeadersRq cornersHeadersRq = new CornersHeadersRq();
        String uriConnection = "http://example.com/api/dict/directory-keys/{key_id}";
        int serviceTimeOut = 30000;

        String expectedUriString = "http://example.com/api/dict/directory-keys/testKey123";

        // Mock para buildStringToUriKey
        URI mockUri = new URI(expectedUriString);
        when(uriUtil.buildStringToUriKey(uriConnection, keyValue)).thenReturn(mockUri);

        // Mock para Util.object2String y CertificadoUtil.buildClient()
        try (MockedStatic<Util> utilMock = mockStatic(Util.class);
             MockedStatic<CertificadoUtil> certMock = mockStatic(CertificadoUtil.class)) {

            utilMock.when(() -> Util.object2String(any(URI.class))).thenReturn(expectedUriString);

            // Mock para CertificadoUtil.buildClient()
            certMock.when(CertificadoUtil::buildClient).thenReturn(httpClient);

            // Mock para que el cliente HTTP lance una IOException
            IOException testException = new IOException("Test IO exception");
            when(httpClient.execute(any(HttpDelete.class))).thenThrow(testException);

            // Act & Assert
            IOException exception = assertThrows(IOException.class, () -> {
                cornerCancellationKeyService.deleteKey(keyValue, cornersHeadersRq, uriConnection, serviceTimeOut);
            });

            // Verify
            assertEquals("Test IO exception", exception.getMessage());
            verify(uriUtil).buildStringToUriKey(uriConnection, keyValue);
            verify(timeOutUtil).setUpTimeOut(eq(serviceTimeOut), any(HttpDelete.class));
            utilMock.verify(() -> Util.object2String(mockUri));
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}