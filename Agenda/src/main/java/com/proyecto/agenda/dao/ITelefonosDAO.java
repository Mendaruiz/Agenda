package com.proyecto.agenda.dao;

import java.util.List;

import com.proyecto.agenda.model.*;

public interface ITelefonosDAO {

	public List<Telefono> list();
	
	public Telefono get(int idtelefonos);
	
	public List<Telefono> getTelPer(int idpersona);
	
	public void saveOrUpdate(Telefono telefono);
	
	public void delete(int idtelefonos);
}