package co.com.ath.cornerconn.util;



import co.com.ath.cornerconn.constants.QueryParamsEnum;
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

            String uriWithAliasValue = uri.replace(QueryParamsEnum.KEY_ID.getValue(), keyValue);

            return new URI(uriWithAliasValue);
        }

        return new URI(uri);
    }
}
