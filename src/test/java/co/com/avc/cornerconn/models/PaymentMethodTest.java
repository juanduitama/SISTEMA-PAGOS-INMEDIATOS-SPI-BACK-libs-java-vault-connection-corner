package co.com.avc.cornerconn.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PaymentMethodTest {

    @Nested
    @DisplayName("Field Accessors")
    class FieldAccessorsTests {

        @Test
        @DisplayName("Correctly sets and gets type of payment account")
        void correctlySetsAndGetsTypePaymentAcc() {
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setTypePaymentAcc("Credit");

            assertEquals("Credit", paymentMethod.getTypePaymentAcc());
        }

        @Test
        @DisplayName("Correctly sets and gets account number")
        void correctlySetsAndGetsAccountNumber() {
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setAccountNumber("123456789");

            assertEquals("123456789", paymentMethod.getAccountNumber());
        }

        @Test
        @DisplayName("Handles null values for all fields")
        void handlesNullValuesForAllFields() {
            PaymentMethod paymentMethod = new PaymentMethod();

            assertNull(paymentMethod.getTypePaymentAcc());
            assertNull(paymentMethod.getAccountNumber());
        }
    }
}