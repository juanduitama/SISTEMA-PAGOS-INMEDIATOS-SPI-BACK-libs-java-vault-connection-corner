package co.com.avc.cornerconn.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Nested
    @DisplayName("Field Accessors")
    class FieldAccessorsTests {

        @Test
        @DisplayName("Correctly sets and gets first name")
        void correctlySetsAndGetsFirstName() {
            Person person = new Person();
            person.setFirstName("John");

            assertEquals("John", person.getFirstName());
        }

        @Test
        @DisplayName("Correctly sets and gets second name")
        void correctlySetsAndGetsSecondName() {
            Person person = new Person();
            person.setSecondName("Michael");

            assertEquals("Michael", person.getSecondName());
        }

        @Test
        @DisplayName("Correctly sets and gets first surname")
        void correctlySetsAndGetsFirstSurname() {
            Person person = new Person();
            person.setFirstSurName("Doe");

            assertEquals("Doe", person.getFirstSurName());
        }

        @Test
        @DisplayName("Correctly sets and gets second surname")
        void correctlySetsAndGetsSecondSurname() {
            Person person = new Person();
            person.setSecondSurName("Smith");

            assertEquals("Smith", person.getSecondSurName());
        }

        @Test
        @DisplayName("Correctly sets and gets type of person")
        void correctlySetsAndGetsTypePerson() {
            Person person = new Person();
            person.setTypePerson("Individual");

            assertEquals("Individual", person.getTypePerson());
        }

        @Test
        @DisplayName("Correctly sets and gets business name")
        void correctlySetsAndGetsBusinessName() {
            Person person = new Person();
            person.setBusinessName("TechCorp");

            assertEquals("TechCorp", person.getBusinessName());
        }

        @Test
        @DisplayName("Correctly sets and gets document type")
        void correctlySetsAndGetsDocumentType() {
            Person person = new Person();
            person.setDocumentType("Passport");

            assertEquals("Passport", person.getDocumentType());
        }

        @Test
        @DisplayName("Correctly sets and gets document number")
        void correctlySetsAndGetsDocumentNumber() {
            Person person = new Person();
            person.setDocumentNumber("123456789");

            assertEquals("123456789", person.getDocumentNumber());
        }

        @Test
        @DisplayName("Handles null values for all fields")
        void handlesNullValuesForAllFields() {
            Person person = new Person();

            assertNull(person.getFirstName());
            assertNull(person.getSecondName());
            assertNull(person.getFirstSurName());
            assertNull(person.getSecondSurName());
            assertNull(person.getTypePerson());
            assertNull(person.getBusinessName());
            assertNull(person.getDocumentType());
            assertNull(person.getDocumentNumber());
        }
    }
}