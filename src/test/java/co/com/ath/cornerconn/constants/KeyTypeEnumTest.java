package co.com.ath.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class KeyTypeEnumTest {
    @ParameterizedTest
    @EnumSource(KeyTypeEnum.class)
    void testKeyTypeEnum(KeyTypeEnum keyTypeEnum){

        switch (keyTypeEnum){
            case USER_IDENTIFICATION:
                assertEquals("1", keyTypeEnum.getAthValue());
                assertEquals("NRIC", keyTypeEnum.getCornerValue());
                break;
            case PHONE:
                assertEquals("2", keyTypeEnum.getAthValue());
                assertEquals("N", keyTypeEnum.getCornerValue());
                break;
            case EMAIL:
                assertEquals("3", keyTypeEnum.getAthValue());
                assertEquals("E", keyTypeEnum.getCornerValue());
                break;
            case KEY_ALPHANUMERIC:
                assertEquals("4", keyTypeEnum.getAthValue());
                assertEquals("O", keyTypeEnum.getCornerValue());
                break;
            case MERCHANT:
                assertEquals("5", keyTypeEnum.getAthValue());
                assertEquals("B", keyTypeEnum.getCornerValue());
                break;
            default:
                fail("Unexpected value: " + keyTypeEnum);
        }

    }
}
