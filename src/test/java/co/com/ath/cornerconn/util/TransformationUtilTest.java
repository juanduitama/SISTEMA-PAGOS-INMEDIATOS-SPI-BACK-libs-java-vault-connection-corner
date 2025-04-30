package co.com.ath.cornerconn.util;

import co.com.ath.cornerconn.constants.KeyTypeEnum;
import co.com.ath.cornerconn.constants.PersonTypeEnum;
import co.com.ath.cornerconn.constants.StatusEnum;
import co.com.ath.cornerconn.models.Key;
import co.com.ath.cornerconn.models.Person;
import co.com.ath.cornerconn.models.enrollment.EnrollmentRq;
import co.com.ath.cornerconn.models.update.CornerUpdateRq;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;
class TransformationUtilTest {

    /**
     * Permite inyectar la clase TransformationUtil
     * para ser usada en la prueba
     */
    @InjectMocks
    TransformationUtil transformationUtil;

    @Test
    void transformDateFormatBody() {
        /**
         * Instancia de la clase TransformationUtil
         */
        transformationUtil = new TransformationUtil();

        // Arrange
        String inputDate = "2025-03-19T15:12:55.993Z";
        String expectedOutput = "2025-03-19T15:12:55.993-05:00";


        // Act
        String result = transformationUtil.transformDateFormatBody(inputDate);


        System.out.println("result = " + result);
        // Assert
        assertEquals(expectedOutput, result);

    }

    @Test
    void transformStatus() {
        /**
         * Instancia de la clase TransformationUtil
         */
        transformationUtil = new TransformationUtil();

        String status = StatusEnum.ACTIVE.getAthValue();

        String result = transformationUtil.transformStatus(status);

        assertEquals(StatusEnum.ACTIVE.getCornerValue(),result);

        assertNotEquals(null, result);
    }

    @Test
    void transformKeyType() {

        /**
         * Instancia de la clase TransformationUtil
         */
        transformationUtil = new TransformationUtil();

        String keyType = KeyTypeEnum.KEY_ALPHANUMERIC.getAthValue();

        String result = transformationUtil.transformKeyType(keyType);

        assertEquals(KeyTypeEnum.KEY_ALPHANUMERIC.getCornerValue(),result);

        assertNotEquals(null, result);
    }

    @Test
    void transformPersonType() {
        /**
         * Instancia de la clase TransformationUtil
         */
        transformationUtil = new TransformationUtil();

        String personType = PersonTypeEnum.PN.getAthValue();

        String result = transformationUtil.transformPersonType(personType);

        assertEquals(PersonTypeEnum.PN.getCornerValue(),result);

        assertNotEquals(null, result);
    }

    @Test
    void transformEnrollmentRq() {
        EnrollmentRq enrollmentDto = new EnrollmentRq();
        Person person = new Person();
        person.setTypePerson("oldType");
        enrollmentDto.setPerson(person);
        Key key = new Key();
        key.setKeyType("oldKeyType");
        enrollmentDto.setKey(key);

        EnrollmentRq result = transformationUtil.transformEnrollmentRq(enrollmentDto);

        assertEquals("transformedType", result.getPerson().getTypePerson());
        assertEquals("transformedKeyType", result.getKey().getKeyType());
    }

    @Test
    void transformUpdateKeyRq() {
        CornerUpdateRq cornerUpdateRq = new CornerUpdateRq();
        Person person = new Person();
        person.setTypePerson("oldType");
        cornerUpdateRq.setPerson(person);
        Key key = new Key();
        key.setKeyType("oldKeyType");
        cornerUpdateRq.setKey(key);

        CornerUpdateRq result = transformationUtil.transformUpdateKeyRq(cornerUpdateRq);

        assertEquals("transformedType", result.getPerson().getTypePerson());
        assertEquals("transformedKeyType", result.getKey().getKeyType());
    }
}