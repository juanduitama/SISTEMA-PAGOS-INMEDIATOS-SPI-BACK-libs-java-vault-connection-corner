package co.com.ath.cornerconn.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Introspected
@SerdeImport(PersonModel.class)
public class PersonModel {

    protected String firstName;
    protected String secondName;
    protected String firstSurName;
    protected String secondSurName;
    protected String typePerson;
    protected String businessName;
    protected String documentType;
    protected String documentNumber;
}
