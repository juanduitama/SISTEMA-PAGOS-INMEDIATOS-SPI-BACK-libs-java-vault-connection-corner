package co.com.ath.cornerconn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * StatusEnum
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
 * StatusEnum define los valores de los estados que puede tener una llave
 */
@AllArgsConstructor
@Getter
public enum StatusEnum {

    /**
     * Define valor de estado para llaves activas
     */
    ACTIVE("ACTIVA", "ACTIVE"),

    /**
     * Define valor de estado para llaves inactivas
     */
    BLOCKED_BY_CLIENT("BLOQUEADA", "SUSPENDED_BY_CLIENT"),

    /**
     * Define valor de estado para llaves bloqueadas por el participante
     */
    BLOCKED_BY_PARTICIPANT("ON_HOLD", "SUSPENDED_BY_PARTICIPANT"),

    /**
     * Define valor de estado para llaves bloqueadas por el sistema
     */
    CANCEL("CANCELADA","CANCEL");

    private final String athValue;
    private final String cornerValue;


}
