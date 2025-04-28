package co.com.ath.cornerconn.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Introspected
@SerdeImport(PaymentMethod.class)
public class PaymentMethod {

    protected String typePaymentAcc;
    protected String accountNumber;
}
