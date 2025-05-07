package co.com.avc.cornerconn.models.enrollment;

import co.com.avc.cornerconn.models.Key;
import co.com.avc.cornerconn.models.PaymentMethod;
import co.com.avc.cornerconn.models.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

/**
 * enrollmentRq
 * <p>
 * Desarrollo ATH - SPBVI
 * <p>
 * Creado el: 29 de Abril de 2025
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
 * Clase enrollmentRq que es el modelo del request de la petición del servicio de Corner.
 */

@Getter
@Setter
@Introspected
@SerdeImport(EnrollmentRq.class)
public class EnrollmentRq {

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
     * Método de pago (Información de la cuenta por participante).
     */
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

    /**
     * Descripción de la llave por participante.
     */
    @JsonProperty("description")
    private String description;

}
