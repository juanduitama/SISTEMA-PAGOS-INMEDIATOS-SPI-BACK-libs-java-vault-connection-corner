package co.com.ath.cornerconn.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * MsgErrors
 * <p>
 * Desarrollo ATH - SPBVI
 * <p>
 * Creado el: 29 de abril de 2025
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
 * MsgErrors modelo de respuesta para mapear los errores
 */
@Getter
@Setter
public class MsgErrors {

    /**
     * Detalle de los errores
     */
    @JsonProperty("detail")
    private DetailErrors detailErrors;
}
