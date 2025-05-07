package co.com.avc.cornerconn.models;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * HttpResponseWrapper
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
 * Clase HttpResponseWrapper que es el modelo del response a la hora de realizar la petición
 */
@Getter
@Setter
@AllArgsConstructor
@Introspected
@SerdeImport(HttpResponseWrapper.class)
public class HttpResponseWrapper {

    /**
     * Cuerpo de la respuesta
     */
    private String responseBody;

    /**
     *
     */
    private int statusCode;

}
