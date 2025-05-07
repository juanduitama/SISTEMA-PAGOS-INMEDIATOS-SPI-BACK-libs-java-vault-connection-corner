package co.com.avc.cornerconn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ResponseServiceEnum
 * <p>
 * Enum que contiene la información necesaria
 * para las respuestas de la lambda.
 * <p>
 * Desarrollo ATH - SPBVI
 * <p>
 * Creado él: 29 de Abril de 2025
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
 */
@AllArgsConstructor
@Getter
public enum ResponseServiceEnum {

    /**
     * Constante de error en caso de que se presente un fallo al intentar operación sobre DynamoDB.
     */
    ERROR_TEC_EXCEPTION_VAULT_CONN(500, "500", "Error",
            "Error al intentar operación sobre directorio federado", 500,
            "VaultSync"),

    ;

    private final Integer statusCode;
    private final String serverStatusCode;
    private final String severity;
    private final String statusDesc;
    private final Integer additionalStatusCode;
    private final String additionalStatusDesc;

}
