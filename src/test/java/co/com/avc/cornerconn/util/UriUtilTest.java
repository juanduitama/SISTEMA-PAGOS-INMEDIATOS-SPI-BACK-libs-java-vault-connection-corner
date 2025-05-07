package co.com.avc.cornerconn.util;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class UriUtilTest {

    /**
     * Instancia de la clase UriUtil
     */
    private UriUtil uriUtil = new UriUtil();


    @Test
    void buildStringToUriKey() throws URISyntaxException {

        /**
         * Se asignan valores de prueba
         */
        String uri = "http://example.com/api/dict/directory-keys/{value_key}";
        String keyValue = "keyValue";

        URI expectedUri = new URI("http://example.com/api/dict/directory-keys/keyValue");

        /**
         * Llamar al método que se va a probar
         */
        URI resultUri = uriUtil.buildStringToUriKey(uri, keyValue);

        /**
         * Verificar que la URI resultante es la esperada
         */
        assertEquals(expectedUri, resultUri);
    }
}