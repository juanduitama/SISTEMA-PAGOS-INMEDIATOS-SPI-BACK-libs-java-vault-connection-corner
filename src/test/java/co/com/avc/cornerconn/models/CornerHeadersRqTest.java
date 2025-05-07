package co.com.avc.cornerconn.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CornerHeadersRqTest {

    @Test
    void testAchHeadersRq() {
        CornersHeadersRq headersRq  = new CornersHeadersRq();

        headersRq.setContentType("Content-Type");

        assertEquals("Content-Type", headersRq.getContentType());
    }
}