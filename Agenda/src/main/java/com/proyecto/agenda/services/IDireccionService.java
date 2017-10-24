package com.proyecto.agenda.services;

import java.util.List;

import com.proyecto.agenda.model.Direccion;

public interface IDireccionService {
	public List<Direccion> list();
	
	public Direccion get(int iddirecciones);
	
	public void saveOrUpdate(Direccion Direccion);
	
	public void delete(int iddirecciones);
}