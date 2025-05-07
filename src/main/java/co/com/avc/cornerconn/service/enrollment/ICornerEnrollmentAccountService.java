package co.com.avc.cornerconn.service.enrollment;

import co.com.avc.cornerconn.models.HttpResponseWrapper;
import co.com.avc.cornerconn.models.enrollment.EnrollmentRq;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ICornerEnrollmentAccountService {
    HttpResponseWrapper enrollmentKeyService(EnrollmentRq req, String uriConnection,
                                             int serviceTimeOut)
            throws URISyntaxException, IOException, InterruptedException;
}
