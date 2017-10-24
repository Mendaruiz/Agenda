package com.proyecto.agenda.services;

import java.util.List;

import com.proyecto.agenda.model.Persona;

public interface IPersonaService {
	public List<Persona> list();
	
	public Persona get(int id);
	
	public List<Persona> get(String nombre);
	
	public void saveOrUpdate(Persona persona);
	
	public void delete(int id);
}
