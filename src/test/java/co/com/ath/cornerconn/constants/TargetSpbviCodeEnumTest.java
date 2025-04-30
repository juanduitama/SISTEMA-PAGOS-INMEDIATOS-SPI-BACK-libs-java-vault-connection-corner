package co.com.ath.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TargetSpbviCodeEnumTest {
    @ParameterizedTest
    @EnumSource(TargetSpbviCodeEnum.class)
    void testSpbviCodeEnum(TargetSpbviCodeEnum targetSpbviCodeEnum) {
        switch (targetSpbviCodeEnum) {
            case CREDIBANCO:
                assertEquals("CRB", targetSpbviCodeEnum.getCornerValue());
                break;
            case ENTRE_CUENTAS:
                assertEquals("ENT", targetSpbviCodeEnum.getCornerValue());
                break;
            case TRANSFIYA:
                assertEquals("TFY", targetSpbviCodeEnum.getCornerValue());
                break;
            case VISIONAMOS:
                assertEquals("VIS", targetSpbviCodeEnum.getCornerValue());
                break;
            default:
                fail("Unexpected value: " + targetSpbviCodeEnum);
        }
    }
}
