package com.proyecto.agenda.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "telefonos")
public class Telefono implements Serializable {
	//Cada vez que pongamos serializable hay que poner esta línea
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="id_persona",referencedColumnName="idpersonas")
	@Id
	private Integer idtelefonos;
	private String telefono;
	
	public Telefono(){
	}
	
	//Tenemos 2 constructores así podemos coger uno u otro:
	public Telefono(Integer idtelefonos){
		this.idtelefonos = idtelefonos;
	}

	public Telefono(int idtelefonos, String telefono) {
		this.idtelefonos = idtelefonos;
		this.telefono = telefono;
	}

	public int getIdtelefonos() {
		return idtelefonos;
	}

	public void setIdtelefonos(int idtelefonos) {
		this.idtelefonos = idtelefonos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public int hashCode() {
	   int hash = 0;
	   hash += (idtelefonos != null ? idtelefonos.hashCode() : 0);
	   return hash;
	}
	
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefono other = (Telefono) obj;
        if (this.idtelefonos != other.idtelefonos) {
            return false;
        }
        if (!Objects.equals(this.idtelefonos, other.idtelefonos)) {
            return false;
        }
        return true;
    }
	 
	@Override
	public String toString() {
		return "Telefono [idtelefonos=" + idtelefonos + ", telefono=" + telefono + "]";
	}
}
