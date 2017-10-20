package com.proyecto.agenda.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "departamentos")

public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddepartamento;
	
	
	@Column(name="nombre")
    private String nombre;
	
	 @OneToMany (mappedBy = "departamento") 
	   
	 private Set<Empleado> empleados;
	 
	public Departamento(){
		
	}

	public Departamento(int iddepartamento, String nombre) {
		
		this.iddepartamento = iddepartamento;
		this.nombre = nombre;
	}

	public int getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Departamento [iddepartamento=" + iddepartamento + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
}
