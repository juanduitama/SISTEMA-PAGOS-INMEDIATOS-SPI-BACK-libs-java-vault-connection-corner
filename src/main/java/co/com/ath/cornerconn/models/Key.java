package co.com.ath.cornerconn.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

/**
 * Key
 * <p>
 * Desarrollo ATH - SPBVI
 * <p>
 * Creado el: 29 de abril de 2025
 *
 * @author Luis F. Herreño Mateus
 * @version 1.0
 * @since 1.0
 * <p>
 * Requerimiento: SPBVI - Sistema de pagos de bajo valor inmediatos
 * <p>
 * Copyright © A Toda Hora S.A. Todos los derechos reservados
 * <p>
 * Este software es confidencial y es propiedad de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 * <p>
 * <p>
 * Key modelo de respuesta para mapear el objeto key
 */
@Getter
@Setter
@Introspected
@SerdeImport(Key.class)
public class Key {

    /**
     * Tipo de llave
     */
    @JsonProperty("key_type")
    private String keyType;

    /**
     * Valor de la llave
     */
    @JsonProperty("value_key")
    private String valueKey;
}
