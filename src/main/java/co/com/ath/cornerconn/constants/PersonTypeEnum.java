package co.com.ath.cornerconn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * PersonTypeEnum
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
 * PersonTypeEnum define los valores para el tipo de persona que se va a registrar
 */
@Getter
@AllArgsConstructor
public enum PersonTypeEnum {

    /**
     * NATURAL PERSON
     */
    PN("PN", "PERSON"),

    /**
     * LEGAL PERSON
     */
    PJ("PJ", "BUSINESS");

    private final String athValue;
    private final String cornerValue;
}
