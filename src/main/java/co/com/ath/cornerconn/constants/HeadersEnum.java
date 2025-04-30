package co.com.ath.cornerconn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * HeadersEnum
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
 * HeadersEnum define los valores para los encabezados
 */
@Getter
@AllArgsConstructor
public enum HeadersEnum {


    /**
    * Define el tipo de contenido de la solicitud
    */
    CONTENT_TYPE("Content-Type"),

    ;
    private final String value;
}
