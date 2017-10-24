package com.proyecto.agenda.dao;

import java.util.List;

import com.proyecto.agenda.model.Direccion;


public interface IDireccionesDAO {
	

	public List<Direccion> list();
	
	public Direccion get(int iddirecciones);
	
	public List<Direccion> getDirPer(int idpersona);
	
	public void saveOrUpdate(Direccion direccion);
	
	public void delete(int iddirecciones);

}
