package com.proyecto.agenda.services;

import java.util.List;

import com.proyecto.agenda.model.Categoria;

public interface ICategoriaService {
	public List<Categoria> list();
	
	public Categoria get(int id);
	
	public void saveOrUpdate(Categoria dir);
	
	public void delete(int id);
}
