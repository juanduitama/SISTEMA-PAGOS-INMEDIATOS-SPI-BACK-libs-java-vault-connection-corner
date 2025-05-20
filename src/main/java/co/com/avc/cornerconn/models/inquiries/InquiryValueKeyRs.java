package co.com.avc.cornerconn.models.inquiries;
import co.com.avc.cornerconn.models.Key;
import co.com.avc.cornerconn.models.PaymentMethod;
import co.com.avc.cornerconn.models.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Generated;

@Introspected
@SerdeImport(InquiryValueKeyRs.class)
public class InquiryValueKeyRs {
    @JsonProperty("Key")
    private Key key;
    @JsonProperty("Person")
    private Person person;
    @JsonProperty("PaymentMethod")
    private PaymentMethod paymentMethod;
    @JsonProperty("description")
    private String description;
    @JsonProperty("cdStatusKey")
    private String cdStatusKey;


    public InquiryValueKeyRs() {
    }

    @Generated
    public Key getKey() {
        return this.key;
    }

    @Generated
    public Person getPerson() {
        return this.person;
    }

    @Generated
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    @JsonProperty("Key")
    @Generated
    public void setKey(final Key key) {
        this.key = key;
    }

    @JsonProperty("Person")
    @Generated
    public void setPerson(final Person person) {
        this.person = person;
    }

    @JsonProperty("PaymentMethod")
    @Generated
    public void setPaymentMethod(final PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    @Generated
    public void setDescription(String description) {
        this.description = description;
    }
    @JsonProperty("CdStatusKey")
    public String getCdStatusKey() {
        return cdStatusKey;
    }
    @JsonProperty("CdStatusKey")
    @Generated
    public void setCdStatusKey(String cdStatusKey) {
        this.cdStatusKey = cdStatusKey;
    }
}