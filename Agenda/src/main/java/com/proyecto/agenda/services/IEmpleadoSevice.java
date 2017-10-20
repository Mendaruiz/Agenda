package com.proyecto.agenda.services;

import java.util.List;

import com.proyecto.agenda.model.Empleado;

public interface IEmpleadoSevice {
	
	public List<Empleado> list();
	
	public Empleado get(int id);
	
	public void saveOrUpdate(Empleado Empleado);
	
	public void delete(int id);
	
}
