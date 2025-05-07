package co.com.avc.cornerconn.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

/**
 * CornersHeadersRq
 * <p>
 * Desarrollo ATH - SPBVI
 * <p>
 * Creado el: 23 de octubre de 2024
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
 * Clase CornersHeadersRq que representa el modelo de los headers del request
 */
@Getter
@Setter
@Introspected
@SerdeImport(CornersHeadersRq.class)
public class CornersHeadersRq {

    /**
     * Este parámetro es para que reconozca la peticion
     */
    @JsonProperty("Content-Type")
    private String contentType;
}
