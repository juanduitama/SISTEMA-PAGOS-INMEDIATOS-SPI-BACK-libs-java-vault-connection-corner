package co.com.ath.cornerconn.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MsgInformationResponseTest {

    /**
     * Método que prueba modelo MessageInformationResponse
     */
    @Test
    void testMsgInformationResponse() {

        /**
         * Instancias de clase necesarias para asignar y obtener datos
         */
        MsgInformationResponse messageInformationResponse = new MsgInformationResponse();
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

        messageInformationResponse.setPerson(person);

        /**
         * Se asignan valores de prueba de Key
         */
        String keyType = "NRIC";
        String keyValue = "1000333333";

        key.setKeyType(keyType);
        key.setValueKey(keyValue);

        messageInformationResponse.setKey(key);

        /**
         * Se asignan valores de prueba de PaymentMethod
         */
        String accType = "CAHO";
        String accNumber = "103434305";

        account.setTypePaymentAcc(accType);
        account.setAccountNumber(accNumber);

        messageInformationResponse.setPaymentMethod(account);

        /**
         * Se asigna valor de prueba para descripción de la llave
         */
        String description = "Llave cliente";
        messageInformationResponse.setDescription(description);

        /**
         * Se asigna valor de prueba para status de la llave
         */
        String status = "ACTV";
        messageInformationResponse.setStatusKey(status);

        /**
         * Valida que los valores obtenidos sean iguales a los esperados
         */
        assertEquals(person, messageInformationResponse.getPerson());
        assertEquals(key, messageInformationResponse.getKey());
        assertEquals(account, messageInformationResponse.getPaymentMethod());
        assertEquals(status, messageInformationResponse.getStatusKey());
        assertEquals(description, messageInformationResponse.getDescription());

        /**
         * Valida que los objetos no sean nulos
         */
        assertNotNull(person);
        assertNotNull(key);
        assertNotNull(account);
        assertNotNull(status);
        assertNotNull(description);

    }
}