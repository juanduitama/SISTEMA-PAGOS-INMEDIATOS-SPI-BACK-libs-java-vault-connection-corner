package co.com.avc.cornerconn.models.update;

import co.com.avc.cornerconn.models.Key;
import co.com.avc.cornerconn.models.PaymentMethod;
import co.com.avc.cornerconn.models.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CornerUpdateRqTest {

    @Nested
    @DisplayName("Field Accessors")
    class FieldAccessorsTests {

        @Test
        @DisplayName("Correctly sets and gets person information")
        void correctlySetsAndGetsPersonInformation() {
            CornerUpdateRq request = new CornerUpdateRq();
            Person person = new Person();
            request.setPerson(person);

            assertEquals(person, request.getPerson());
        }

        @Test
        @DisplayName("Correctly sets and gets key information")
        void correctlySetsAndGetsKeyInformation() {
            CornerUpdateRq request = new CornerUpdateRq();
            Key key = new Key();
            request.setKey(key);

            assertEquals(key, request.getKey());
        }

        @Test
        @DisplayName("Correctly sets and gets payment method information")
        void correctlySetsAndGetsPaymentMethodInformation() {
            CornerUpdateRq request = new CornerUpdateRq();
            PaymentMethod paymentMethod = new PaymentMethod();
            request.setPaymentMethod(paymentMethod);

            assertEquals(paymentMethod, request.getPaymentMethod());
        }

        @Test
        @DisplayName("Correctly sets and gets description")
        void correctlySetsAndGetsDescription() {
            CornerUpdateRq request = new CornerUpdateRq();
            request.setDescription("Test Description");

            assertEquals("Test Description", request.getDescription());
        }

        @Test
        @DisplayName("Correctly sets and gets status")
        void correctlySetsAndGetsStatus() {
            CornerUpdateRq request = new CornerUpdateRq();
            request.setStatus("Active");

            assertEquals("Active", request.getStatus());
        }

        @Test
        @DisplayName("Handles null values for all fields")
        void handlesNullValuesForAllFields() {
            CornerUpdateRq request = new CornerUpdateRq();

            assertNull(request.getPerson());
            assertNull(request.getKey());
            assertNull(request.getPaymentMethod());
            assertNull(request.getDescription());
            assertNull(request.getStatus());
        }
    }
}