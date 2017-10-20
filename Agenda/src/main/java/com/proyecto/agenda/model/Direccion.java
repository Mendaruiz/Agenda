package com.proyecto.agenda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DIRECCIONES")
public class Direccion implements Serializable{
	
		private static final long serialVersionUID = 1L;
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int iddirecciones;
		private String direccion;
		private String codPostal;
		private String localidad;
		private String provincia;
		
		@ManyToOne()
		@JoinColumn(name="idpersonas", referencedColumnName="idpersonas")
		private Persona idPersona;
		
		public int getIddirecciones() {
			return iddirecciones;
		}
		public void setIddirecciones(int iddirecciones) {
			this.iddirecciones = iddirecciones;
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
		public Persona getIdPersona() {
			return idPersona;
		}
		public void setIdPersona(Persona idPersona) {
			this.idPersona = idPersona;
		}
}
