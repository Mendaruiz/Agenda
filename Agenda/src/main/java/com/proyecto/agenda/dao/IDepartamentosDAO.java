package com.proyecto.agenda.dao;

import java.util.List;

import com.proyecto.agenda.model.Departamento;

public interface IDepartamentosDAO {
	public List<Departamento> list();
	
public Departamento get(int iddepartamento);

public void saveOrUpdate(Departamento departamento);

public void delete(int iddepartamento);


}
