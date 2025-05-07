package co.com.avc.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class EntityCodeEnumTest {

    @ParameterizedTest
    @EnumSource(EntityCodeEnum.class)
    void testEntityCodeEnum(EntityCodeEnum entityCodeEnum) {
        switch (entityCodeEnum) {
            case BAVV:
                assertEquals("0052", entityCodeEnum.getAthValue());
                assertEquals("1052", entityCodeEnum.getCornerValue());
                break;
            case BBOG:
                assertEquals("0001", entityCodeEnum.getAthValue());
                assertEquals("1001", entityCodeEnum.getCornerValue());
                break;
            case BOCC:
                assertEquals("0023", entityCodeEnum.getAthValue());
                assertEquals("1023", entityCodeEnum.getCornerValue());
                break;
            case BPOP:
                assertEquals("0002", entityCodeEnum.getAthValue());
                assertEquals("1002", entityCodeEnum.getCornerValue());
                break;
            case DALE:
                assertEquals("0097", entityCodeEnum.getAthValue());
                assertEquals("1097", entityCodeEnum.getCornerValue());
                break;
            default:
                fail("Unexpected value: " + entityCodeEnum);
        }
    }

}
