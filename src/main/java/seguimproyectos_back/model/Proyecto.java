/*
 * Copyright (c) 2012 - 2013 UNIVERSIDAD DE ANTIOQUIA - SIIU - SMAP.
 * All Rights Reserved.
 * This software is the confidential and proprietary information of U DE A
 * Developed By CONSULT-SOFT S.A, Development Team 2012 - 2013.
 *
 */
package seguimproyectos_back.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Proyecto extends ProyectoBase {

    private static final long serialVersionUID = -5549017032114431885L;

    private boolean selected;
    private String nombreCortoConvocatoria;
    private Long identificadorInstanciaAdministrativa;
    private Integer administraProyectoInstanciaAdministrativa;
    private String nombreInstanciaAdministrativa;
    private String nombreCortoInstanciaAdministrativa;
    private String jefeInstanciaAdministrativa;
    private String documentoJefeInstanciaAdm;
    private String cargoJefe;
    private String nombreCentroGestionNivelAdministrativo;
    private Date notificadoFechaPrepuestoTotalEjecutado;
    private Date notificadoFechaPorcentajeEjecutado;
    private Date fechaInicioInicioFormal;
    private Date fechaInicioFinalizacionFormal;
    private String financiador;
    private String nitFinanciador;
    private String nombreCompletoResponsable;
    private String subtipoProyectoNombre;
    private String tipoProyectoNombre;
    private String centroGestionStr;
    private String centroGestionCortoStr;
    private Long maxProrrogaInicioFormal;
    private Long maxProrrogaEjecucion;
    private Long maxInicioFormal;
    private Long fechaFinalTiempo;
    private Long fechaFinalIdPeriodo;
    private Long fechaFinalIdNotificarA;
    private Long idNotificacion;
    private Long idCentroGestion;
    private String idNotificarA;
    private String usuarioCrea;
    private Long fechaFinalTiempoDet;
    private Long fechaFinalIdPeriodoDet;
    private Long fechaFinalIdNotificarADet;
    private String responsableProyectoDet;
    private Long idTipoNotificacion;
    private String estadoProyectoDet;
    private Long porcentajeValor;
    private Long porcentajeIdNotificarA;
    private Long porcentajeNumeroDias;
    private Long porcentajeNumeroDiasDet;
    private Long porcentajeValorDet;
    private Long porcentajeIdNotificarADet;
    private Long valorFrescoPresupuestado;
    private Long presupuestoDisponible;
    private Long valorFrescoEjecutado;
    private Long valorEspecie;
    private Long valorTotalProyecto;
    private Long ejecutadoMargen;
    private Long ejecutadoNumeroDias;
    private Long ejecutadoIdNotificarA;
    private Long ejecutadoMargenDet;
    private Long ejecutadoNumeroDiasDet;
    private Long ejecutadoIdNotificarADet;
    private String textoMensajePersonalizado;
    private String textoMensaje;
    private String nombreProcesoSeleccion;
    private String tipoSubtipoNombre;
    private Long valorFrescoDisponible;
    private Long valorFrescoReserva;
    private String nombreModalidadConvocatoria;

}