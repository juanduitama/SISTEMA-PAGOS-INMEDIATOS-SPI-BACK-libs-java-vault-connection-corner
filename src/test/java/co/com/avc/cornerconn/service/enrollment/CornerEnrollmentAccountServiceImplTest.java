package co.com.avc.cornerconn.service.enrollment;

import co.com.ath.commons.util.Util;
import co.com.avc.cornerconn.models.HttpResponseWrapper;
import co.com.avc.cornerconn.models.Key;
import co.com.avc.cornerconn.models.PaymentMethod;
import co.com.avc.cornerconn.models.Person;
import co.com.avc.cornerconn.models.enrollment.EnrollmentRq;
import co.com.avc.cornerconn.util.*;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
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
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CornerEnrollmentAccountServiceImplTest {

    @InjectMocks
    private CornerEnrollmentAccountServiceImpl cornerEnrollmentAccountService;

    @Mock
    private UriUtil uriUtil;

    @Mock
    private HeadersUtil headersUtil;

    @Mock
    private TimeOutUtil timeOutUtil;

    @Mock
    private TransformationUtil transformationUtil;

    @Mock
    private CloseableHttpClient httpClient;

    @Mock
    private CloseableHttpResponse httpResponse;

    @Mock
    private StatusLine statusLine;

    @BeforeEach
    public void setUp() {
        // Inyectamos manualmente los mocks en las propiedades
        try {
            Field uriUtilField = CornerEnrollmentAccountServiceImpl.class.getDeclaredField("uriUtil");
            uriUtilField.setAccessible(true);
            uriUtilField.set(cornerEnrollmentAccountService, uriUtil);

            Field headersUtilField = CornerEnrollmentAccountServiceImpl.class.getDeclaredField("headersUtil");
            headersUtilField.setAccessible(true);
            headersUtilField.set(cornerEnrollmentAccountService, headersUtil);

            Field timeOutUtilField = CornerEnrollmentAccountServiceImpl.class.getDeclaredField("timeOutUtil");
            timeOutUtilField.setAccessible(true);
            timeOutUtilField.set(cornerEnrollmentAccountService, timeOutUtil);

            Field transformationUtilField = CornerEnrollmentAccountServiceImpl.class.getDeclaredField("transformationUtil");
            transformationUtilField.setAccessible(true);
            transformationUtilField.set(cornerEnrollmentAccountService, transformationUtil);
        } catch (Exception e) {
            fail("Error configurando los mocks: " + e.getMessage());
        }
    }

    /**
     * Método para crear un objeto EnrollmentRq de prueba
     *
     * @return EnrollmentRq con datos de prueba
     */
    private EnrollmentRq createMockEnrollmentRq() {
        EnrollmentRq enrollmentRq = new EnrollmentRq();

        Person person = new Person();
        person.setFirstName("string");
        person.setSecondName("string");
        person.setFirstSurName("string");
        person.setSecondSurName("string");
        person.setTypePerson("N");
        person.setDocumentType("CC");
        person.setDocumentNumber("string");

        Key key = new Key();
        key.setKeyType("NRIC");
        key.setValueKey("string");

        PaymentMethod payment = new PaymentMethod();
        payment.setTypePaymentAcc("CAHO");
        payment.setAccountNumber("23839178034552277830165783565");

        enrollmentRq.setPerson(person);
        enrollmentRq.setKey(key);
        enrollmentRq.setPaymentMethod(payment);
        enrollmentRq.setDescription("string");

        return enrollmentRq;
    }

    @Test
    public void enrollmentKeyService_Success() throws URISyntaxException, IOException, InterruptedException,
            NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        // Arrange
        EnrollmentRq enrollmentRq = createMockEnrollmentRq();
        String uriConnection = "http://example.com/api/dict/directory-keys";
        int serviceTimeOut = 30000;

        String expectedRequestBody = "{\"person\":{\"typePerson\":\"NATURAL\",\"id\":\"123456789\"},\"key\":{\"keyType\":\"PHONE\",\"keyValue\":\"3001234567\"},\"payment_method\":{\"account\":\"123456789\",\"accountType\":\"SAVINGS\"},\"description\":\"Test Key\"}";
        String expectedResponse = "{\"status\":\"ACTIVE\",\"handleId\":\"12345\"}";
        int expectedStatusCode = 201;

        // Mock para TransformationUtil.transformEnrollmentRq
        try (MockedStatic<TransformationUtil> transformationUtilMock = mockStatic(TransformationUtil.class);
             MockedStatic<Util> utilMock = mockStatic(Util.class);
             MockedStatic<CertificadoUtil> certMock = mockStatic(CertificadoUtil.class)) {

            // Configurar TransformationUtil.transformEnrollmentRq
            transformationUtilMock.when(() -> TransformationUtil.transformEnrollmentRq(any(EnrollmentRq.class)))
                    .thenReturn(enrollmentRq);

            // Configurar Util.object2String para que retorne el JSON del cuerpo sin comillas
            utilMock.when(() -> Util.object2String(any(EnrollmentRq.class))).thenReturn(expectedRequestBody);

            // Mock para CertificadoUtil.buildClient()
            certMock.when(CertificadoUtil::buildClient).thenReturn(httpClient);

            // Mock para las respuestas HTTP
            when(httpClient.execute(any(HttpPost.class))).thenReturn(httpResponse);
            when(httpResponse.getEntity()).thenReturn(new StringEntity(expectedResponse));
            when(httpResponse.getStatusLine()).thenReturn(statusLine);
            when(statusLine.getStatusCode()).thenReturn(expectedStatusCode);

            // Act
            HttpResponseWrapper result = cornerEnrollmentAccountService.enrollmentKeyService(enrollmentRq, uriConnection, serviceTimeOut);

            // Assert
            assertNotNull(result);
            assertEquals(expectedResponse, result.getResponseBody());
            assertEquals(expectedStatusCode, result.getStatusCode());

            // Verify
            verify(timeOutUtil).setUpTimeOut(eq(serviceTimeOut), any(HttpPost.class));
            verify(httpClient).execute(any(HttpPost.class));
        }
    }

    @Test
    public void enrollmentKeyService_HttpClientThrowsIOException() throws URISyntaxException, NoSuchAlgorithmException,
            KeyStoreException, KeyManagementException {
        // Arrange
        EnrollmentRq enrollmentRq = createMockEnrollmentRq();
        String uriConnection = "http://example.com/api/dict/directory-keys";
        int serviceTimeOut = 30000;

        String expectedRequestBody = "{\"person\":{\"typePerson\":\"NATURAL\",\"id\":\"123456789\"},\"key\":{\"keyType\":\"PHONE\",\"keyValue\":\"3001234567\"},\"payment_method\":{\"account\":\"123456789\",\"accountType\":\"SAVINGS\"},\"description\":\"Test Key\"}";

        // Mock para TransformationUtil.transformEnrollmentRq
        try (MockedStatic<TransformationUtil> transformationUtilMock = mockStatic(TransformationUtil.class);
             MockedStatic<Util> utilMock = mockStatic(Util.class);
             MockedStatic<CertificadoUtil> certMock = mockStatic(CertificadoUtil.class)) {

            // Configurar TransformationUtil.transformEnrollmentRq
            transformationUtilMock.when(() -> TransformationUtil.transformEnrollmentRq(any(EnrollmentRq.class)))
                    .thenReturn(enrollmentRq);

            // Configurar Util.object2String para que retorne el JSON del cuerpo sin comillas
            utilMock.when(() -> Util.object2String(any(EnrollmentRq.class))).thenReturn(expectedRequestBody);

            // Mock para CertificadoUtil.buildClient()
            certMock.when(CertificadoUtil::buildClient).thenReturn(httpClient);

            // Mock para que el cliente HTTP lance una IOException
            IOException testException = new IOException("Test IO exception");
            when(httpClient.execute(any(HttpPost.class))).thenThrow(testException);

            // Act & Assert
            IOException exception = assertThrows(IOException.class, () -> {
                cornerEnrollmentAccountService.enrollmentKeyService(enrollmentRq, uriConnection, serviceTimeOut);
            });

            // Verify
            assertEquals("Test IO exception", exception.getMessage());
            verify(timeOutUtil).setUpTimeOut(eq(serviceTimeOut), any(HttpPost.class));
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}