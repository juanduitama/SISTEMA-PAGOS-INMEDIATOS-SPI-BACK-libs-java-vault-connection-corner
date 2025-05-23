package co.com.avc.cornerconn.util;



import co.com.avc.cornerconn.constants.QueryParamsEnum;
import jakarta.ws.rs.core.UriBuilderException;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class UriUtil {

    /**
     * buildUri con el valor de la llave aplica servicios de consulta, modificación y cancelación
     * @param uri
     * @param valueKey
     * @return
     * @throws URISyntaxException
     */
    public URI buildStringToUriKey(String uri, String valueKey) throws URISyntaxException {

        if(uri.contains(QueryParamsEnum.VALUE_KEY.getValue())) {
            String newUri = uri.replace(QueryParamsEnum.VALUE_KEY.getValue(), valueKey);
            return new URI(newUri);
        }
        return new URI(uri);
        //String cleanUrl = uri.trim().replace("\"", "").replace("\n", "").replace("\r", "");

        //return new URI(cleanUrl);
    }

    public URI buildStringToUri(String uri) throws URISyntaxException {

        return new URI(uri);
    }
}
