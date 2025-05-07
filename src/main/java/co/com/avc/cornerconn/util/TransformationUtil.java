package co.com.avc.cornerconn.util;

import co.com.avc.cornerconn.constants.KeyTypeEnum;
import co.com.avc.cornerconn.constants.PersonTypeEnum;
import co.com.avc.cornerconn.constants.StatusEnum;
import co.com.avc.cornerconn.models.enrollment.EnrollmentRq;
import co.com.avc.cornerconn.models.update.CornerUpdateRq;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * TransformationUtil
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
 * Clase TransformationUtil encargada de hacer las transformaciones de los valores de ATH  a los valores de ACH
 */
public class TransformationUtil {


    /**
     * Método encargado de transformar el formato de la fecha.
     * Recibe la fecha como parámetro,realiza la transformación
     * correspondiente y retorna la fecha formateada.
     *
     * @param date fecha
     * @return fecha formateada
     */
    public static String transformDateFormatBody(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime newDate = LocalDateTime.parse(date, format);
        OffsetDateTime offsetDateTime = newDate.atZone(ZoneId.of("America/Bogota")).toOffsetDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return offsetDateTime.format(formatter);
    }


    /**
     * transformStatus
     * Función que transforma los tipos de estados de ATH a los de ACH
     * @param status estado a transformar en parametros validos
     * @return un estado valido en ACH
     */
    public static String transformStatus(String status) {
        for (StatusEnum statusEnum : StatusEnum.values()){
            if (statusEnum.getAthValue().equals(status)) {
                return statusEnum.getCornerValue();
            }
        }
        return null;
    }

    /**
     * transformKeyType
     * Función que transforma los tipos de llave de ATH a los tipos de cuenta en ACH
     * @param keyType tipo de llave a transformar en parametros validos
     * @return un tipo de llave valido en ACH
     */
    public static String transformKeyType(String keyType) {
        for (KeyTypeEnum entityCodeEnum : KeyTypeEnum.values()){
            if (entityCodeEnum.getAthValue().equals(keyType)) {
                return entityCodeEnum.getCornerValue();
            }
        }
        return null;
    }

    /**
     * transformPersonType
     * Función que transforma los tipos de personas de ATH a los tipos de personas en ACH
     * @param personType tipo de persona a transformar en parametros validos
     * @return un tipo de persona valido en ACH
     */
    public static String transformPersonType(String personType) {
        for (PersonTypeEnum personTypeEnum : PersonTypeEnum.values()) {
            if (personTypeEnum.getAthValue().equals(personType)) {
                return personTypeEnum.getCornerValue();
            }
        }
        throw new IllegalArgumentException("Invalid person type: " + personType);
    }

    public static EnrollmentRq transformEnrollmentRq(EnrollmentRq enrollmentDto){
        enrollmentDto.getPerson().setTypePerson(transformPersonType(enrollmentDto.getPerson().getTypePerson()));
        enrollmentDto.getKey().setKeyType(transformKeyType(enrollmentDto.getKey().getKeyType()));

        return enrollmentDto;
    }

    public static CornerUpdateRq transformUpdateKeyRq(CornerUpdateRq cornerUpdateRq){
        if (cornerUpdateRq.getPerson() == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        if (cornerUpdateRq.getKey() == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        cornerUpdateRq.getPerson().setTypePerson(transformPersonType(cornerUpdateRq.getPerson().getTypePerson()));
        cornerUpdateRq.getKey().setKeyType(transformKeyType(cornerUpdateRq.getKey().getKeyType()));
        return cornerUpdateRq;
    }

    public static CornerUpdateRq transformUpdateStatusKeyRq(CornerUpdateRq cornerUpdateRq){
        cornerUpdateRq.setStatus(transformStatus(cornerUpdateRq.getStatus()));
        return cornerUpdateRq;
    }
}

