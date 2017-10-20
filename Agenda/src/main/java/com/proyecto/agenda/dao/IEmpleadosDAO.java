package com.proyecto.agenda.dao;

import java.util.List;

import com.proyecto.agenda.model.Empleado;

public interface IEmpleadosDAO {
	
	public List<Empleado> list();
	
	public Empleado get(int id);
	
	public void saveOrUpdate(Empleado empleado);
	
	public void delete(int id);
	
	
}
