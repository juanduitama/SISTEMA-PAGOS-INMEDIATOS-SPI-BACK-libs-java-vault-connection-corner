package co.com.avc.cornerconn.models.inquiries;
import co.com.avc.cornerconn.models.Key;
import co.com.avc.cornerconn.models.PaymentMethod;
import co.com.avc.cornerconn.models.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Introspected
@SerdeImport(InquiryValueKeyRs.class)
public class InquiryValueKeyRs {

    @JsonProperty("person")
    private Person person;
    @JsonProperty("key")
    private Key key;
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
    @JsonProperty("description")
    private String description;
    @JsonProperty("cd_state_key")
    private String cdStateKey;

}
