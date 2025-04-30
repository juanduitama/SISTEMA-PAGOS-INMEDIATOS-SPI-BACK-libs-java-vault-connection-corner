package co.com.ath.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ConstantsEnumTest {
    @ParameterizedTest
    @EnumSource(ConstantsEnum.class)
    void testConstantsEnum(ConstantsEnum constantsEnum){
        switch (constantsEnum){
            case APPLICATION_JSON :
                assertEquals("application/json", constantsEnum.getValue());
                break;
            default:
                fail("Unexpected value: " + constantsEnum);
        }
    }
}
