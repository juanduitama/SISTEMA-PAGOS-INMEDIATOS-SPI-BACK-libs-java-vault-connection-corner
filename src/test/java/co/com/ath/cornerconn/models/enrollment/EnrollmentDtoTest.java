package co.com.ath.cornerconn.models.enrollment;

import co.com.ath.cornerconn.models.Key;
import co.com.ath.cornerconn.models.PaymentMethod;
import co.com.ath.cornerconn.models.Person;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentDtoTest {
    /**
     * Método que prueba modelo EnrollmentDto
     */
    @Test
    void testEnrollmentDto() {

        /**
         * Instancias de clase necesarias para asignar y obtener datos
         */
        EnrollmentRq enrollmentDto = new EnrollmentRq();
        Person person = new Person();
        Key key = new Key();
        PaymentMethod account = new PaymentMethod();

        /**
         * Se asignan valores de prueba de Person
         */
        String firstName = "Hector";
        String secondName = "Daniel";
        String firstSurname = "Perez";
        String secondSurname = "Lopez";
        String typePerson = "N";
        String businessName = "";
        String documentType = "CC";
        String documentNumber = "1000333333";

        person.setFirstName(firstName);
        person.setSecondName(secondName);
        person.setFirstSurName(firstSurname);
        person.setSecondSurName(secondSurname);
        person.setTypePerson(typePerson);
        person.setBusinessName(businessName);
        person.setDocumentType(documentType);
        person.setDocumentNumber(documentNumber);

        enrollmentDto.setPerson(person);

        /**
         * Se asignan valores de prueba de Key
         */
        String keyType = "NRIC";
        String keyValue = "1000333333";

        key.setKeyType(keyType);
        key.setValueKey(keyValue);

        enrollmentDto.setKey(key);

        /**
         * Se asignan valores de prueba de PaymentMethod
         */
        String accType = "CAHO";
        String accNumber = "103434305";

        account.setTypePaymentAcc(accType);
        account.setAccountNumber(accNumber);

        enrollmentDto.setPaymentMethod(account);

        /**
         * Se asigna valor de prueba para descripción de la llave
         */
        String description = "Llave cliente";
        enrollmentDto.setDescription(description);

        /**
         * Valida que los valores obtenidos sean iguales a los esperados
         */
        assertEquals(person, enrollmentDto.getPerson());
        assertEquals(key, enrollmentDto.getKey());
        assertEquals(account, enrollmentDto.getPaymentMethod());
        assertEquals(description, enrollmentDto.getDescription());

        /**
         * Valida que los objetos no sean nulos
         */

        assertNotNull(enrollmentDto.getPerson());
        assertNotNull(enrollmentDto.getKey());
        assertNotNull(enrollmentDto.getPaymentMethod());
        assertNotNull(enrollmentDto.getDescription());


    }
}