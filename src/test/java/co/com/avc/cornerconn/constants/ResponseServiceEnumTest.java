package co.com.avc.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ResponseServiceEnumTest {
    @ParameterizedTest
    @EnumSource(ResponseServiceEnum.class)
    void testResponseServiceEnum(ResponseServiceEnum responseServiceEnum) {
        switch (responseServiceEnum) {
            case ERROR_TEC_EXCEPTION_VAULT_CONN :
                assertEquals(500, responseServiceEnum.getStatusCode());
                assertEquals("500", responseServiceEnum.getServerStatusCode());
                assertEquals("Error", responseServiceEnum.getSeverity());
                assertEquals("Error al intentar operación sobre directorio federado", responseServiceEnum.getStatusDesc());
                assertEquals("VaultSync", responseServiceEnum.getAdditionalStatusDesc());
                assertEquals(500, responseServiceEnum.getAdditionalStatusCode());
                break;
            default:
                fail("Unexpected value: " + responseServiceEnum);
        }
    }
}
