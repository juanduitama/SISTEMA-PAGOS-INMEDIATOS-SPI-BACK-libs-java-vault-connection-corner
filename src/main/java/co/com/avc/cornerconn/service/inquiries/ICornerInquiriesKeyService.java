package co.com.avc.cornerconn.service.inquiries;

import co.com.avc.cornerconn.models.CornersHeadersRq;
import co.com.avc.cornerconn.models.HttpResponseWrapper;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * ICornerInquiriesKeyService
 * <p>
 * Desarrollo ATH - SPBVI
 * <p>
 * Creado el: 23 de octubre de 2024
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
 * interfaz ICornerInquiriesKeyService donde se define método para consumo
 * de servicio de consulta
 */
public interface ICornerInquiriesKeyService {

    HttpResponseWrapper keyInquiryRs(String keyValue, CornersHeadersRq cornersHeadersRq,
                                     String uriConnection, int serviceTimeOut)
            throws URISyntaxException, IOException, InterruptedException;

    HttpResponseWrapper keysInquirysRs(String uriConnection, CornersHeadersRq cornersHeadersRq,int serviceTimeOut)
            throws URISyntaxException, IOException, InterruptedException;


}
