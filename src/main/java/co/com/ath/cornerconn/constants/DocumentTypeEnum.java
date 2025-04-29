package co.com.ath.cornerconn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DocumentTypeEnum
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
 * DocumentTypeEnum define los valores de los tipos de documentos, sea para ach como para ath
 */
@Getter
@AllArgsConstructor
public enum DocumentTypeEnum {

    /**
     * Cédula de ciudadanía
     */
    CC("CC","CC"),

    /**
     * Cédula de Extranjería
     */
    CE("CE","CE"),

    /**
     * Número Único de Identificación Personal
     */
    NUIP("NUIP","NUIP"),

    /**
     * Permiso de Protección Temporal
     */
    PPT("PPT","PPT"),

    /**
     * Número de Identificación Tributaria, sin digito de verificación
     */
    NIT("NIT","NIT"),

    /**
     * Permiso Especial de Permanencia
     */
    PEP("PEP","PEP"),

    /**
     * Número de Pasaporte
     */
    PAS("PAS","PA"),

    /**
     * TDI - Tarjeta de identidad
     */
    TDI("TDI","TI");


    private final String athValue;
    private final String cornerValue;
}
