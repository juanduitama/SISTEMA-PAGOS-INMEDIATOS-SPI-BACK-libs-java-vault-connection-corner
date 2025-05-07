package co.com.avc.cornerconn.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class DetailsErrorsTest {

    @Nested
    @DisplayName("Field Accessors")
    class FieldAccessorsTests {

        @Test
        @DisplayName("Correctly sets and gets error type")
        void correctlySetsAndGetsErrorType() {
            DetailErrors detailErrors = new DetailErrors();
            detailErrors.setType("ValidationError");

            assertEquals("ValidationError", detailErrors.getType());
        }

        @Test
        @DisplayName("Correctly sets and gets error location")
        void correctlySetsAndGetsErrorLocation() {
            DetailErrors detailErrors = new DetailErrors();
            ArrayList<Object> loc = new ArrayList<>();
            loc.add("field1");
            loc.add("field2");
            detailErrors.setLoc(loc);

            assertEquals(loc, detailErrors.getLoc());
        }

        @Test
        @DisplayName("Correctly sets and gets error message")
        void correctlySetsAndGetsErrorMessage() {
            DetailErrors detailErrors = new DetailErrors();
            detailErrors.setMsgError("Invalid input");

            assertEquals("Invalid input", detailErrors.getMsgError());
        }

        @Test
        @DisplayName("Correctly sets and gets correlation ID")
        void correctlySetsAndGetsCorrelationId() {
            DetailErrors detailErrors = new DetailErrors();
            detailErrors.setCorrelationId("12345");

            assertEquals("12345", detailErrors.getCorrelationId());
        }

        @Test
        @DisplayName("Handles null values for all fields")
        void handlesNullValuesForAllFields() {
            DetailErrors detailErrors = new DetailErrors();

            assertNull(detailErrors.getType());
            assertNull(detailErrors.getLoc());
            assertNull(detailErrors.getMsgError());
            assertNull(detailErrors.getCorrelationId());
        }

        @Test
        @DisplayName("Handles empty error location list")
        void handlesEmptyErrorLocationList() {
            DetailErrors detailErrors = new DetailErrors();
            detailErrors.setLoc(new ArrayList<>());

            assertEquals(0, detailErrors.getLoc().size());
        }
    }
}