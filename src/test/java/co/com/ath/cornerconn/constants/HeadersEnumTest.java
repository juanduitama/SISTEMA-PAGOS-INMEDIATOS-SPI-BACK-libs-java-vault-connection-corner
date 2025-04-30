package co.com.ath.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class HeadersEnumTest {
    @ParameterizedTest
    @EnumSource(HeadersEnum.class)
    void testHeadersEnum(HeadersEnum headersEnum){
        switch (headersEnum){
            case CONTENT_TYPE:
                assertEquals("Content-Type", headersEnum.getValue());
                break;
            default:
                fail("Unexpected value: " + headersEnum);
        }
    }
}
