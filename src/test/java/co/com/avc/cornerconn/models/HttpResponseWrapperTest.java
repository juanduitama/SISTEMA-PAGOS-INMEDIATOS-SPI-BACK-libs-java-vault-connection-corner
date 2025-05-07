package co.com.avc.cornerconn.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class HttpResponseWrapperTest {

    @Nested
    @DisplayName("Field Accessors")
    class FieldAccessorsTests {

        @Test
        @DisplayName("Correctly sets and gets response body")
        void correctlySetsAndGetsResponseBody() {
            HttpResponseWrapper wrapper = new HttpResponseWrapper("Success", 200);
            wrapper.setResponseBody("Updated Response");

            assertEquals("Updated Response", wrapper.getResponseBody());
        }

        @Test
        @DisplayName("Correctly sets and gets status code")
        void correctlySetsAndGetsStatusCode() {
            HttpResponseWrapper wrapper = new HttpResponseWrapper("Success", 200);
            wrapper.setStatusCode(404);

            assertEquals(404, wrapper.getStatusCode());
        }

        @Test
        @DisplayName("Handles empty response body")
        void handlesEmptyResponseBody() {
            HttpResponseWrapper wrapper = new HttpResponseWrapper("", 200);

            assertEquals("", wrapper.getResponseBody());
        }

        @Test
        @DisplayName("Handles negative status code")
        void handlesNegativeStatusCode() {
            HttpResponseWrapper wrapper = new HttpResponseWrapper("Error", -1);

            assertEquals(-1, wrapper.getStatusCode());
        }
    }
}