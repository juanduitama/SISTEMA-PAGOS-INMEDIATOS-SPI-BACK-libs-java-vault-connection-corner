package co.com.avc.cornerconn.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class KeyTest {

    @Nested
    @DisplayName("Field Accessors")
    class FieldAccessorsTests {

        @Test
        @DisplayName("Correctly sets and gets key type")
        void correctlySetsAndGetsKeyType() {
            Key key = new Key();
            key.setKeyType("Primary");

            assertEquals("Primary", key.getKeyType());
        }

        @Test
        @DisplayName("Correctly sets and gets value key")
        void correctlySetsAndGetsValueKey() {
            Key key = new Key();
            key.setValueKey("12345");

            assertEquals("12345", key.getValueKey());
        }

        @Test
        @DisplayName("Handles null values for all fields")
        void handlesNullValuesForAllFields() {
            Key key = new Key();

            assertNull(key.getKeyType());
            assertNull(key.getValueKey());
        }
    }
}