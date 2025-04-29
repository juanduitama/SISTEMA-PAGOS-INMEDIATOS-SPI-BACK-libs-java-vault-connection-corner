package co.com.ath.cornerconn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TargetSpbviCodeEnum
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
 * TargetSpbviCodeEnum define los valores para el código de destino de la cámara
 */
@Getter
@AllArgsConstructor
public enum TargetSpbviCodeEnum {

    /**
     * Enum que representa los códigos de destino  de la camara TRANSFIYA para SPBVI.
     */
    TRANSFIYA("TFY"),

    /**
     * Enum que representa los códigos de destino de la camara ENTRE_CUENTAS para SPBVI.
     */
    ENTRE_CUENTAS("ENT"),

    /**
     * Enum que representa los códigos de destino de la camara CREDIBANCO para SPBVI.
     */
    CREDIBANCO("CRB"),

    /**
     * Enum que representa los códigos de destino de la camara VISANET para SPBVI.
     */
    VISIONAMOS("VIS");

    private final String cornerValue;
}
