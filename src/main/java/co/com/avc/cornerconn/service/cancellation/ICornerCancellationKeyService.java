package co.com.avc.cornerconn.service.cancellation;

import co.com.avc.cornerconn.models.CornersHeadersRq;
import co.com.avc.cornerconn.models.HttpResponseWrapper;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ICornerCancellationKeyService {

    HttpResponseWrapper deleteKey(String keyValue, CornersHeadersRq cornersHeadersRq,
                                  String uriConnection, int serviceTimeOut)
            throws URISyntaxException, IOException, InterruptedException;
}
