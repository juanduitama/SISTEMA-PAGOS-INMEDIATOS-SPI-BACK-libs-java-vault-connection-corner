package co.com.ath.cornerconn.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TimeOutUtilTest {
    @Test
    void setUpTimeOut_ConfiguresHttpPostCorrectly() {
        int timeout = 5000;
        HttpPost httpPost = new HttpPost();

        new TimeOutUtil().setUpTimeOut(timeout, httpPost);

        RequestConfig config = httpPost.getConfig();
        assertNotNull(config);
        assertEquals(timeout, config.getConnectTimeout());
        assertEquals(timeout, config.getSocketTimeout());
    }

    @Test
    void setUpTimeOut_ConfiguresHttpPutCorrectly() {
        int timeout = 5000;
        HttpPut httpPut = new HttpPut();

        new TimeOutUtil().setUpTimeOut(timeout, httpPut);

        RequestConfig config = httpPut.getConfig();
        assertNotNull(config);
        assertEquals(timeout, config.getConnectTimeout());
        assertEquals(timeout, config.getSocketTimeout());
    }

    @Test
    void setUpTimeOut_ConfiguresHttpPatchCorrectly() {
        int timeout = 5000;
        HttpPatch httpPatch = new HttpPatch();

        new TimeOutUtil().setUpTimeOut(timeout, httpPatch);

        RequestConfig config = httpPatch.getConfig();
        assertNotNull(config);
        assertEquals(timeout, config.getConnectTimeout());
        assertEquals(timeout, config.getSocketTimeout());
    }

    @Test
    void setUpTimeOut_ConfiguresHttpGetCorrectly() {
        int timeout = 5000;
        HttpGet httpGet = new HttpGet();

        new TimeOutUtil().setUpTimeOut(timeout, httpGet);

        RequestConfig config = httpGet.getConfig();
        assertNotNull(config);
        assertEquals(timeout, config.getConnectTimeout());
        assertEquals(timeout, config.getSocketTimeout());
    }

    @Test
    void setUpTimeOut_ConfiguresHttpDeleteCorrectly() {
        int timeout = 5000;
        HttpDelete httpDelete = new HttpDelete();

        new TimeOutUtil().setUpTimeOut(timeout, httpDelete);

        RequestConfig config = httpDelete.getConfig();
        assertNotNull(config);
        assertEquals(timeout, config.getConnectTimeout());
        assertEquals(timeout, config.getSocketTimeout());
    }
}
