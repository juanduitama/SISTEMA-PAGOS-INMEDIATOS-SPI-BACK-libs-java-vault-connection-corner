package co.com.avc.cornerconn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AcctTypeEnum
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
 * AcctTypeEnum define los valores para tipo del medio de pago asociado al participante
 */
@Getter
@AllArgsConstructor
public enum AcctTypeEnum {

    /**
     * Define valor para cuentas de ahorro
     */
    CAHO("CAHO"),

    /**
     * Define valor para cuentas corrientes
     */
    CCTE("CCTE"),

    /**
     * Define valor para depósitos de bajo monto
     */
    DBMO("DBMO"),

    /**
     * Define valor para depósitos ordinarios
     */
    DORD("DORD"),

    /**
     * Define valor para depósitos de bajo monto inclusivos
     */
    DBMI("DBMI");

    private final String athValue;

}
