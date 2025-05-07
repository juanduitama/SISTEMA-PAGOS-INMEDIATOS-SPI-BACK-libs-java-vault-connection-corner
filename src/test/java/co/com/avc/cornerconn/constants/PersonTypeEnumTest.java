package co.com.avc.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class PersonTypeEnumTest {
    @ParameterizedTest
    @EnumSource(PersonTypeEnum.class)
    void testPersonTypeEnum(PersonTypeEnum personTypeEnum) {
        switch (personTypeEnum) {
            case PN:
                assertEquals("PN", personTypeEnum.getAthValue());
                assertEquals("N", personTypeEnum.getCornerValue());
                break;
            case PJ:
                assertEquals("PJ", personTypeEnum.getAthValue());
                assertEquals("J", personTypeEnum.getCornerValue());
                break;
            default:
                fail("Unexpected value: " + personTypeEnum);
        }
    }

}
