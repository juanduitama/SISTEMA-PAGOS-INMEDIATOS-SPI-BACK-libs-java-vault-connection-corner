package co.com.ath.cornerconn.service.update;

import co.com.ath.commons.util.ATHException;
import co.com.ath.cornerconn.models.CornersHeadersRq;
import co.com.ath.cornerconn.models.Key;
import co.com.ath.cornerconn.models.Person;
import co.com.ath.cornerconn.models.update.CornerUpdateRq;
import jakarta.ws.rs.core.UriBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CornerUpdateKeyServiceImplTest {
    ICornerUpdateKeyService updateKeyService = new CornerUpdateKeyServiceImpl();

    MockedStatic<UriBuilder> mockedStatic;

    private Set<AutoCloseable> mocks = new HashSet<>();

    @BeforeEach
    void setup() {
        mockedStatic = Mockito.mockStatic(UriBuilder.class);
        mocks.add(mockedStatic);
    }

    @AfterEach
    void closeMock() throws Exception {
        for (AutoCloseable mocked : mocks) {
            mocked.close();
        }
    }

    @Test
    void updateKey() throws IOException, InterruptedException {
        CornerUpdateRq updateRq = new CornerUpdateRq();
        CornersHeadersRq headersRq = new CornersHeadersRq();
        headersRq.setContentType("application/json");

        String keyId = "01";
        String entityId = "02";
        String uriConnection = "http://example.com/api/" + entityId + "/" + keyId;

        System.out.println("URI: " + uriConnection);

        HttpResponse<String> response = mock(HttpResponse.class);
        when(response.body()).thenReturn("RespuestaTest");

        HttpClient client = mock(HttpClient.class);
        when(client.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(response);

        assertThrows(ATHException.class, () -> {
            updateKeyService.updateKey(updateRq, keyId, headersRq, uriConnection, 15);
        });
    }

    @Test
    void updateKeyStatus() throws IOException, InterruptedException {
        CornerUpdateRq updateRq = new CornerUpdateRq();
        updateRq.setPerson(new Person()); // Inicializa la propiedad person
        updateRq.setKey(new Key());

        CornersHeadersRq headersRq = new CornersHeadersRq();
        headersRq.setContentType("application/json");

        String keyId = "01";
        String entityId = "02";
        String uriConnection = "http://example.com/api/" + entityId + "/" + keyId;

        HttpResponse response = mock(HttpResponse.class);
        when(response.body()).thenReturn("RespuestaTest");

        HttpClient client = mock(HttpClient.class);
        when(client.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(response);


        assertThrows(ATHException.class, () -> {
            updateKeyService.updateKeyStatus(updateRq, keyId, headersRq, uriConnection, 15);
        });
    }

}
