package co.com.avc.cornerconn.util;



import co.com.avc.cornerconn.constants.QueryParamsEnum;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class UriUtil {

    /**
     * buildUri con el valor de la llave
     * @param uri
     * @param keyValue
     * @return
     * @throws URISyntaxException
     */
    public URI buildStringToUriKey(String uri, String keyValue) throws URISyntaxException {

        if(uri.contains(QueryParamsEnum.KEY_ID.getValue())){

            String uriWithKeyValue = uri.replace(QueryParamsEnum.KEY_ID.getValue(), keyValue);
            uriWithKeyValue.replace("\"", "");
            return new URI(uriWithKeyValue);
        }

        return new URI(uri);
    }
}
