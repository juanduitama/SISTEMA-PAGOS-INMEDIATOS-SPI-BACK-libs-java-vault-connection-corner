package co.com.ath.cornerconn.util;

import co.com.ath.cornerconn.constants.KeyTypeEnum;
import co.com.ath.cornerconn.constants.PersonTypeEnum;
import co.com.ath.cornerconn.constants.StatusEnum;
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
}