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
            case VALUE_KEY:
                assertEquals("{valueKey}", queryParamsEnum.getValue());
                break;
            case URL_DICE:
                assertEquals("/lookup.dice", queryParamsEnum.getValue());
                break;
            default:
                fail("Unexpected value: " + queryParamsEnum);
        }
    }
}
