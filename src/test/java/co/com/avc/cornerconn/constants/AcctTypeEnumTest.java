package co.com.avc.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AcctTypeEnumTest {
    @ParameterizedTest
    @EnumSource(AcctTypeEnum.class)
    void testAcctTypeEnum(AcctTypeEnum acctTypeEnum){
        switch (acctTypeEnum){
            case CAHO :
                assertEquals("CAHO", acctTypeEnum.getAthValue());
                break;
            case CCTE:
                assertEquals("CCTE", acctTypeEnum.getAthValue());
                break;
            case DBMO:
                assertEquals("DBMO", acctTypeEnum.getAthValue());
                break;
            case DORD:
                assertEquals("DORD", acctTypeEnum.getAthValue());
                break;
            case DBMI:
                assertEquals("DBMI", acctTypeEnum.getAthValue());
                break;
            default:
                fail("Unexpected value: " + acctTypeEnum);
        }
    }
}
