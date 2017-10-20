package com.proyecto.agenda.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERSONAS")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDPERSONAS")
	private int idpersonas;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private Date fechaNacimiento;
	
	/*@OneToOne
	@JoinColumn(name = "persona_Id",referencedColumnName = "idempleados")
	private Empleado empleado;*/
	
	/*@OneToMany (mappedBy="idPersona")
	private List<Direccion> direcciones;*/
	
	/*@OneToMany (mappedBy="idTelefonos")
	private List<Telefono> telefonos;*/
	
	public Persona() {
		
	}
	
	
	
	public Persona(int idpersonas, String nombre, String apellido1, String apellido2, String dni,
			Date fechaNacimiento) {
		this.idpersonas = idpersonas;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}



	public int getIdpersonas() {
		return idpersonas;
	}
	public void setIdpersonas(int idpersonas) {
		this.idpersonas = idpersonas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/*public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}*/

	
	
	
}
