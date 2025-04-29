package co.com.ath.cornerconn.util;


import co.com.ath.cornerconn.constants.ConstantsEnum;
import co.com.ath.cornerconn.models.CornersHeadersRq;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

import java.net.http.HttpRequest;

import static co.com.ath.cornerconn.constants.HeadersEnum.CONTENT_TYPE;

//@Slf4j
public class HeadersUtil {

    /**
     * Método que permite añadir encabezados para realiza el consumo,
     * se envían por parámetros el objeto para la solicitud Http y los
     * encabezados.
     * @param requestBuilder objeto para realizar la solicitud HTTP
     * @param cornersHeadersRq encabezados necesarios para la consulta
     */
    public void addKeyHeaders(HttpRequest.Builder requestBuilder,
                              CornersHeadersRq cornersHeadersRq) {

        requestBuilder.header(CONTENT_TYPE.getValue(), ConstantsEnum.APPLICATION_JSON.getValue());
        //log.info("Headers camara ACH: {}", Util.object2String(headers));

    }
    public void addEnrollmentHeaders(HttpPost httpPost,
                                     CornersHeadersRq cornersHeadersRq) {

        httpPost.setHeader(CONTENT_TYPE.getValue(), ConstantsEnum.APPLICATION_JSON.getValue());

    }

    public void addInquiriesHeaders(HttpGet httpGet, CornersHeadersRq cornersHeadersRq){
        httpGet.setHeader(CONTENT_TYPE.getValue(), ConstantsEnum.APPLICATION_JSON.getValue());
    }

    public void addUpdateHeaders(HttpPut httpPut, CornersHeadersRq cornersHeadersRq){
        httpPut.setHeader(CONTENT_TYPE.getValue(), ConstantsEnum.APPLICATION_JSON.getValue());
    }


}
