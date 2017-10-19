package com.proyecto.agenda.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="CATEGORIAS")
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcategorias;
	private String nombre;
	private String descripcion;
	
	@OneToMany(mappedBy="categoria")
	private List<Empleado> emps;

	public int getIdcategorias() {
		return idcategorias;
	}

	public void setIdcategorias(int idcategorias) {
		this.idcategorias = idcategorias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Empleado> getEmps() {
		return emps;
	}

	public void setEmps(List<Empleado> emps) {
		this.emps = emps;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
