package seguimproyectos_back.model.investigador.joven;

import java.util.Date;

import lombok.Data;

@Data
public class JovenInvestigadorDTO {

	private String tipoIdentificacion;
	private String identificacion;
	private String lugarExpedicion;
	private String apellido1;
	private String apellido2;
	private String nombrePila;
	private String ciudadNacimiento;
	private String departamentoNacimiento;
	private String paisNacimiento;
	private Date fechaNacimiento;
	private String municipio;
	private String direccion;
	private String barrio;
	private String estrato;
	private String tipoVivienda;
	private String contactoPrincipal;
	private String celular;
	private String correoElectronico;
	private String banco;
	private String cuenta;
	private String tipoCuenta;
	private Date fechaModificaParticipante;
	private String confirmado;
	private String confirmadoConvenio;
	private String dependencia;
	private String resumenActividades;
	private Long identificadorParticipante;
	private String nombreTutor;
	private String identificacionTutor;
	private String correoTutor;
	private String contactoTutor;
	private String programa;
	private String semestre;
	private Date fechaInicioSemestre;
	private Date fechaFinSemestre;
	private String nombreGrupoTutor;

}
