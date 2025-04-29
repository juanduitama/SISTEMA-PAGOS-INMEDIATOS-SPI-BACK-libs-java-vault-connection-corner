package co.com.ath.cornerconn.models.update;

import co.com.ath.cornerconn.models.Key;
import co.com.ath.cornerconn.models.PaymentMethod;
import co.com.ath.cornerconn.models.Person;
import co.com.ath.cornerconn.models.enrollment.enrollmentRq;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Introspected
@SerdeImport(updateRq.class)
public class updateRq {

    /**
     * Información de la persona para la llave.
     */
    @JsonProperty("person")
    private Person person;

    /**
     * Información de la llave por participante.
     */
    @JsonProperty("key")
    private Key key;

    /**
     * Metodo de pago (Información de la cuenta por participante).
     */
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

    /**
     * Descripción de la llave por participante.
     */
    @JsonProperty("description")
    private String description;

    /**
     * Estado de la llave por participante.
     */
    @JsonProperty("status")
    private String status;
}
