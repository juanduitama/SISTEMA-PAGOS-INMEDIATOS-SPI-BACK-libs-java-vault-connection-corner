package co.com.ath.cornerconn.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;

public class TimeOutUtil {


    public void setUpTimeOut(int serviceTimeOut, HttpPost httpPost) {

        final RequestConfig params = RequestConfig.custom().setConnectTimeout(serviceTimeOut).setSocketTimeout(serviceTimeOut).build();

        httpPost.setConfig(params);

    }


    public void setUpTimeOut (int serviceTimeOut, HttpPut httpPut){

        final RequestConfig params = RequestConfig.custom().setConnectTimeout(serviceTimeOut).setSocketTimeout(serviceTimeOut).build();

        httpPut.setConfig(params);

    }

    public void setUpTimeOut(int serviceTimeOut, HttpPatch httpPatch) {
        final RequestConfig params = RequestConfig.custom()
                .setConnectTimeout(serviceTimeOut)
                .setSocketTimeout(serviceTimeOut)
                .build();
        httpPatch.setConfig(params);
    }

    public void setUpTimeOut(int serviceTimeOut, HttpGet httpGet) {
        final RequestConfig params = RequestConfig.custom()
                .setConnectTimeout(serviceTimeOut)
                .setSocketTimeout(serviceTimeOut)
                .build();
        httpGet.setConfig(params);
    }

    public void setUpTimeOut(int serviceTimeOut, HttpDelete httpDelete) {
        final RequestConfig params = RequestConfig.custom()
                .setConnectTimeout(serviceTimeOut)
                .setSocketTimeout(serviceTimeOut)
                .build();
        httpDelete.setConfig(params);
    }


}

