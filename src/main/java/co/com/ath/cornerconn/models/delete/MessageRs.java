package co.com.ath.cornerconn.models.delete;

import co.com.ath.cornerconn.models.Key;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Introspected
@SerdeImport(MessageRs.class)
public class MessageRs {

    /**
     * Información del estado de la llave
     */
    @JsonProperty("value_key")
    private String valueKey;

}
