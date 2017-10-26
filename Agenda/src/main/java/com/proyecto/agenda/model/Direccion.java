package com.proyecto.agenda.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="DIRECCIONES")
public class Direccion{
	
		private int iddirecciones;
		/*
		@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
		@JoinColumn(name="idPersona")
		*/
		private Persona persona;
		private String direccion;
		private String codPostal;
		private String localidad;
		private String provincia;
		
		
		public Direccion() {
			
		}
		
		public Direccion(int iddirecciones, Persona persona, String direccion, String codPostal, String localidad, String provincia
				) {
			this.iddirecciones = iddirecciones;
			this.direccion = direccion;
			this.codPostal = codPostal;
			this.localidad = localidad;
			this.provincia = provincia;
			this.persona = persona;
		}

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "iddirecciones", unique = true, nullable = false)
		public int getIddirecciones() {
			return iddirecciones;
		}
		public void setIddirecciones(int iddirecciones) {
			this.iddirecciones = iddirecciones;
		}
		
		@ManyToOne(fetch = FetchType.EAGER)
		@Fetch (FetchMode.SELECT)
		@JoinColumn(name = "idPersona")
		
		public Persona getPersona() {
			return persona;
		}
		public void setPersona(Persona persona) {
			this.persona = persona;
		}
		
		public String getDireccion() {
			return direccion;
		}
		
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		
		public String getCodPostal() {
			return codPostal;
		}
		
		public void setCodPostal(String codPostal) {
			this.codPostal = codPostal;
		}
		
		public String getLocalidad() {
			return localidad;
		}
		
		public void setLocalidad(String localidad) {
			this.localidad = localidad;
		}
		
		public String getProvincia() {
			return provincia;
		}
		
		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}

		@Override
		public String toString() {
			return "Direccion [iddirecciones=" + iddirecciones + ", direccion=" + direccion + ", codPostal=" + codPostal
					+ ", localidad=" + localidad + ", provincia=" + provincia + ", persona=" + persona + "]";
		}
		
		
		
}
