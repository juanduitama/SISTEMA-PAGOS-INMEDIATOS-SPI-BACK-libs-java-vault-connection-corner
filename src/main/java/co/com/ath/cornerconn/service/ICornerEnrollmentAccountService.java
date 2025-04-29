package co.com.ath.cornerconn.service;

import co.com.ath.cornerconn.models.enrollment.EnrollmentRq;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ICornerEnrollmentAccountService {
    HttpResponseWrapper enrollmentKeyService(EnrollmentRq req, String uriConnection,
                                             int serviceTimeOut)
            throws URISyntaxException, IOException, InterruptedException;
}
