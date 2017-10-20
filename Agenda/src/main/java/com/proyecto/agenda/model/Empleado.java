package com.proyecto.agenda.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "empleados", catalog = "agenda")
public class Empleado implements java.io.Serializable {

	private Integer idempleados;
	private Categoria categorias;
	private Departamento departamentos;
	private String codEmpleado;
	private String salario;
	private Date fechaAlta;
	private Set personas = new HashSet(0);

	public Empleado() {
	}

	public Empleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public Empleado(Categoria categorias, Departamento departamentos, String codEmpleado, String salario,
			Date fechaAlta, Set personas) {
		this.categorias = categorias;
		this.departamentos = departamentos;
		this.codEmpleado = codEmpleado;
		this.salario = salario;
		this.fechaAlta = fechaAlta;
		this.personas = personas;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "idempleados", unique = true, nullable = false)
	public Integer getIdempleados() {
		return this.idempleados;
	}

	public void setIdempleados(Integer idempleados) {
		this.idempleados = idempleados;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategoria")
	public Categoria getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDepartamento")
	public Departamento getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Departamento departamentos) {
		this.departamentos = departamentos;
	}

	@Column(name = "codEmpleado", nullable = false, length = 45)
	public String getCodEmpleado() {
		return this.codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	@Column(name = "salario", length = 45)
	public String getSalario() {
		return this.salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaAlta", length = 19)
	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleados")
	public Set getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set personases) {
		this.personas = personases;
	}

}


/*
@Entity
@Table(name="EMPLEADOS")
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDEMPLEADOS")
	private int idempleados;
	private String codEmpleado;
	private String salario;
	private Date fechaAlta;
	
	@OneToOne(mappedBy = "empleado",cascade = CascadeType.ALL)
	@JoinColumn(name="idpersonas")
	private Persona personaId;
	
	@ManyToOne
	@JoinColumn(name="departamento", referencedColumnName = "iddepartamento")
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name="departamento", referencedColumnName = "idcategorias")
	private Categoria categoria;
	
	public Empleado() {
	}

	public int getIdempleados() {
		return idempleados;
	}

	public void setIdempleados(int idempleados) {
		this.idempleados = idempleados;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Persona getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Persona personaId) {
		this.personaId = personaId;
	}

	
}
*/