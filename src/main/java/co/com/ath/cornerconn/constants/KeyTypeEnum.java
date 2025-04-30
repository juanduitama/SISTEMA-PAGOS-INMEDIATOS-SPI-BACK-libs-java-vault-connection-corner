package co.com.ath.cornerconn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * KeyTypeEnum
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
 * KeyTypeEnum define valores para tipo de llave y datos del usuario
 */

@Getter
@AllArgsConstructor
public enum KeyTypeEnum {

    /**
     * Numero de identificacion
     */
    USER_IDENTIFICATION("1", "NRIC"),

    /**
     * Numero de celular
     */
    PHONE("2", "N"),

    /**
     * Correo electronico
     */
    EMAIL("3", "E"),

    /**
     * Codigo del comercio
     */
    MERCHANT("5", "B"),

    /**
     * Llave alfanumerica
     */
    KEY_ALPHANUMERIC("4", "O"),

    ;

    private final String athValue;
    private final String cornerValue;

}
