package co.com.ath.cornerconn.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

/**
 * MsgInformationResponse
 * <p>
 * Desarrollo ATH - SPBVI
 * <p>
 * Creado el: 31 de octubre de 2024
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
 * Modelo que representa la Información de respuesta
 */
@Getter
@Setter
@Introspected
@Serdeable.Serializable
@SerdeImport(MsgInformationResponse.class)
public class MsgInformationResponse {

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
     * Descripción del estado de la llave.
     */
    @JsonProperty("cd_state_key")
    private String statusKey;
}
