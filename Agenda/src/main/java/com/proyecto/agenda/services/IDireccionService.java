package com.proyecto.agenda.services;

import java.util.List;

import com.proyecto.agenda.model.Direccion;

public interface IDireccionService {
	public List<Direccion> list();
	
	public Direccion get(int id);
	
	public void saveOrUpdate(Direccion dir);
	
	public void delete(int id);
}
