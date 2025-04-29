package co.com.ath.cornerconn.service.cancellation;

import co.com.ath.cornerconn.models.CornersHeadersRq;
import co.com.ath.cornerconn.models.HttpResponseWrapper;
import co.com.ath.cornerconn.models.update.CornerUpdateRq;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ICornerCancellationKeyService {

    HttpResponseWrapper deleteKey(String keyValue, CornersHeadersRq cornersHeadersRq,
                                  String uriConnection, int serviceTimeOut)
            throws URISyntaxException, IOException, InterruptedException;
}
