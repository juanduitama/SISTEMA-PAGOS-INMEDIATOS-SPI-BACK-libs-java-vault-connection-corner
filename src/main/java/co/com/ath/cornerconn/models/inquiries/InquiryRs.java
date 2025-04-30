package co.com.ath.cornerconn.models.inquiries;

import co.com.ath.cornerconn.models.Key;
import co.com.ath.cornerconn.models.delete.MessageRs;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * InquiryRs
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
 * <p>
 * Clase Inquiry que es el modelo del response de la petición del servicio de Corner.
 * que retorna el estado de la llave
 */

@Getter
@Setter
@Introspected
@SerdeImport(InquiryRs.class)
public class InquiryRs {
    /**
     * Información del estado de la llave
     */
    @JsonProperty("page")
    private int page;

    /**
     * Información del estado de la llave
     */
    @JsonProperty("size")
    private int size;

    /**
     * Información del estado de la llave
     */
    @JsonProperty("total")
    private int total;

    /**
     * Información del estado de la llave
     */
    @JsonProperty("keys")
    private ArrayList<Key> keys;
}
