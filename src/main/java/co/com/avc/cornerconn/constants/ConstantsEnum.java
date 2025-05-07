package co.com.avc.cornerconn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ConstantsEnum
 * <p>
 * Desarrollo ATH - SPBVI
 * <p>
 * Creado el: 29 de octubre de 2024
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
 * ConstantsEnum define el valor del patch para Http
 */
@AllArgsConstructor
@Getter
public enum ConstantsEnum {


    /**
     * Define valor para el método POST
     */
    APPLICATION_JSON("application/json")

    ;


    private final String value;

}
