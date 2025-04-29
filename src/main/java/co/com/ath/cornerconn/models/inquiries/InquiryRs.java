package co.com.ath.cornerconn.models.inquiries;

import co.com.ath.cornerconn.models.Key;
import co.com.ath.cornerconn.models.delete.MessageRs;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Introspected
@SerdeImport(InquiryRs.class)
public class InquiryRs {
    /**
     * Información del estado de la llave
     */
    @JsonProperty("page")
    private int page;

    /**
     * Información del estado de la llave
     */
    @JsonProperty("size")
    private int size;

    /**
     * Información del estado de la llave
     */
    @JsonProperty("total")
    private int total;

    /**
     * Información del estado de la llave
     */
    @JsonProperty("keys")
    private ArrayList<Key> keys;
}
