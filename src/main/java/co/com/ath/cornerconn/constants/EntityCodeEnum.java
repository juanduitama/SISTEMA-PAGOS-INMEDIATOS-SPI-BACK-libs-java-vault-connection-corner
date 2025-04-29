package co.com.ath.cornerconn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AcctTypeEnum
 * <p>
 * Desarrollo ATH - SPBVI
 * <p>
 * Creado el: 16 de abril de 2025
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
 * EntityCodeEnum define los valores para el código de entidad asociado al participante
 */
@Getter
@AllArgsConstructor
public enum EntityCodeEnum {

    /**
     * Define valor para cuentas de ahorro
     */
    BAVV("0052", "1052"),

    /**
     * Define valor para cuentas corrientes
     */
    BBOG("0001", "1001"),

    /**
     * Define valor para depósitos de bajo monto
     */
    BOCC("0023", "1023"),

    /**
     * Define valor para depósitos ordinarios
     */
    BPOP("0002", "1002"),

    /**
     * Define valor para depósitos de bajo monto inclusivos
     */
    DALE("0097", "1097");

    private final String athValue;
    private final String cornerValue;


}
