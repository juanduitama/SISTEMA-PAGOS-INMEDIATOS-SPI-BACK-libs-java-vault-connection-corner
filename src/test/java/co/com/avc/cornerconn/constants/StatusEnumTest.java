package co.com.avc.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class StatusEnumTest {
    @ParameterizedTest
    @EnumSource(StatusEnum.class)
    void testStatusEnum(StatusEnum personTypeEnum) {
        switch (personTypeEnum) {
            case ACTIVE:
                assertEquals("ACTIVA", personTypeEnum.getAthValue());
                assertEquals("ACTV", personTypeEnum.getCornerValue());
                break;
            case BLOCKED_BY_CLIENT:
                assertEquals("BLOQUEADA", personTypeEnum.getAthValue());
                assertEquals("SUSP", personTypeEnum.getCornerValue());
                break;
            case BLOCKED_BY_PARTICIPANT:
                assertEquals("ON_HOLD", personTypeEnum.getAthValue());
                assertEquals("SUSB", personTypeEnum.getCornerValue());
                break;
            case CANCEL:
                assertEquals("CANCELADA", personTypeEnum.getAthValue());
                assertEquals("ICTV", personTypeEnum.getCornerValue());
                break;
            default:
                fail("Unexpected value: " + personTypeEnum);
        }
    }
}
