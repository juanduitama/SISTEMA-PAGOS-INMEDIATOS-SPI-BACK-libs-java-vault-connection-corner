package co.com.avc.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryParamsEnumTest {
    @ParameterizedTest
    @EnumSource(QueryParamsEnum.class)
    void testQueryParamsEnum(QueryParamsEnum queryParamsEnum) {
        switch (queryParamsEnum) {
            case KEY_ID:
                assertEquals("{value_key}", queryParamsEnum.getValue());
                break;
            default:
                fail("Unexpected value: " + queryParamsEnum);
        }
    }
}
