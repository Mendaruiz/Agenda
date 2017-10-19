package com.proyecto.agenda.dao;

import java.util.List;

import com.proyecto.agenda.model.Categoria;

public interface ICategoriasDAO {
	public List<Categoria> list();
	
	public Categoria get(int id);
	
	public void saveOrUpdate(Categoria dir);
	
	public void delete(int id);
}
