package co.com.ath.cornerconn.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Introspected
@SerdeImport(Key.class)
public class Key {

    protected String keyType;
    protected String valueKey;
}
