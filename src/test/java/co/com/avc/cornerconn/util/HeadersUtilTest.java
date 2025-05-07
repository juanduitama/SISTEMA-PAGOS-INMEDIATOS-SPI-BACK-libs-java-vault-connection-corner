package co.com.avc.cornerconn.util;

import co.com.avc.cornerconn.constants.ConstantsEnum;
import co.com.avc.cornerconn.models.CornersHeadersRq;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.junit.jupiter.api.Test;

import static co.com.avc.cornerconn.constants.HeadersEnum.CONTENT_TYPE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HeadersUtilTest {

    @Test
    void addEnrollmentHeaders_AddsCorrectHeaders() {
        HttpPost httpPost = new HttpPost();
        CornersHeadersRq cornersHeadersRq = new CornersHeadersRq();

        new HeadersUtil().addEnrollmentHeaders(httpPost, cornersHeadersRq);

        assertEquals(ConstantsEnum.APPLICATION_JSON.getValue(), httpPost.getFirstHeader(CONTENT_TYPE.getValue()).getValue());
    }

    @Test
    void addInquiriesHeaders_AddsCorrectHeaders() {
        HttpGet httpGet = new HttpGet();
        CornersHeadersRq cornersHeadersRq = new CornersHeadersRq();

        new HeadersUtil().addInquiriesHeaders(httpGet, cornersHeadersRq);

        assertEquals(ConstantsEnum.APPLICATION_JSON.getValue(), httpGet.getFirstHeader(CONTENT_TYPE.getValue()).getValue());
    }

    @Test
    void addUpdateHeaders_AddsCorrectHeaders() {
        HttpPut httpPut = new HttpPut();
        CornersHeadersRq cornersHeadersRq = new CornersHeadersRq();

        new HeadersUtil().addUpdateHeaders(httpPut, cornersHeadersRq);

        assertEquals(ConstantsEnum.APPLICATION_JSON.getValue(), httpPut.getFirstHeader(CONTENT_TYPE.getValue()).getValue());
    }
}
