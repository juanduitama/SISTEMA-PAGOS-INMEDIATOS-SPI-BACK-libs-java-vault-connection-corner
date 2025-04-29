package co.com.ath.cornerconn.service.update;

import co.com.ath.cornerconn.models.CornersHeadersRq;
import co.com.ath.cornerconn.models.HttpResponseWrapper;
import co.com.ath.cornerconn.models.update.CornerUpdateRq;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ICornerUpdateKeyService {

    HttpResponseWrapper updateKey(CornerUpdateRq cornerUpdateRq, String keyValue, CornersHeadersRq cornersHeadersRq,
                                  String uriConnection, int serviceTimeOut)
            throws URISyntaxException, IOException, InterruptedException;

    HttpResponseWrapper updateKeyStatus(CornerUpdateRq cornerUpdateRq, String keyValue,CornersHeadersRq cornersHeadersRq,
                                    String uriConnection, int serviceTimeOut)
            throws URISyntaxException, IOException, InterruptedException;
}
