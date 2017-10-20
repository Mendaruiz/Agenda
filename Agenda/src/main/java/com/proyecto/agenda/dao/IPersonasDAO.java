package com.proyecto.agenda.dao;

import java.util.List;

import com.proyecto.agenda.model.Persona;

public interface IPersonasDAO {
	
	public List<Persona> list();
	
	public Persona get(int id);
	
	public void saveOrUpdate(Persona persona);
	
	public void delete(int id);
	
	
}
