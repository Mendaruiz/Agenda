package com.proyecto.agenda.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name= "TELEFONOS")
public class Telefono {
	
	private int idtelefonos;
	private Persona persona;
	private String telefono;
	
	public Telefono(){
		
	}

	public Telefono(int idtelefonos, Persona persona, String telefono) {
		this.idtelefonos = idtelefonos;
		this.persona = persona;
		this.telefono = telefono;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtelefonos", unique = true, nullable = false)
	public int getIdtelefonos() {
		return idtelefonos;
	}

	public void setIdtelefonos(int idtelefonos) {
		this.idtelefonos = idtelefonos;
	}
	/*//Funciona
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPersona")*/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPersona")
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Telefono [idtelefonos=" + idtelefonos + ", persona=" + persona + ", telefono=" + telefono + "]";
	}
	
	
	
	
	

}
