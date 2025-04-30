package co.com.ath.cornerconn.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MsgErrorsTest {

    @Nested
    @DisplayName("Field Accessors")
    class FieldAccessorsTests {

        @Test
        @DisplayName("Correctly sets and gets detail errors")
        void correctlySetsAndGetsDetailErrors() {
            MsgErrors msgErrors = new MsgErrors();
            DetailErrors detailErrors = new DetailErrors();
            msgErrors.setDetailErrors(detailErrors);

            assertEquals(detailErrors, msgErrors.getDetailErrors());
        }

        @Test
        @DisplayName("Handles null value for detail errors")
        void handlesNullValueForDetailErrors() {
            MsgErrors msgErrors = new MsgErrors();

            assertNull(msgErrors.getDetailErrors());
        }
    }
}