package co.com.avc.cornerconn.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import lombok.Getter;
import lombok.Setter;

/**
 * Person
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
 * Person modelo que mapea la información del cliente
 */
@Getter
@Setter
@Introspected
@SerdeImport(Person.class)
public class Person {


    /**
     * Primer nombre del cliente
     */
    @JsonProperty("first_name")
    private String firstName;

    /**
     * Segundo nombre del cliente
     */
    @JsonProperty("second_name")
    private String secondName;

    /**
     * Primer apellido del cliente
     */
    @JsonProperty("first_surname")
    private String firstSurName;

    /**
     * Segundo apellido del cliente
     */
    @JsonProperty("second_surname")
    private String secondSurName;

    /**
     * Tipo de persona
     */
    @JsonProperty("type_person")
    private String typePerson;

    /**
     * Nombre legal de la empresa
     */
    @JsonProperty("business_name")
    private String businessName;

    /**
     * Tipo de documento
     */
    @JsonProperty("document_type")
    private String documentType;

    /**
     * Numero de documento
     */
    @JsonProperty("document_number")
    private String documentNumber;
}
