package com.proyecto.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.agenda.dao.IEmpleadosDAO;
import com.proyecto.agenda.model.Empleado;

public class EmpleadoServiceImpl implements IEmpleadoSevice {

	@Autowired
	private IEmpleadosDAO empleadosDAO;
	
	@Override
	public List<Empleado> list() {
		return empleadosDAO.list();
	}

	@Override
	public Empleado get(int id) {
		return empleadosDAO.get(id);
	}

	@Override
	public void saveOrUpdate(Empleado Empleado) {
		empleadosDAO.saveOrUpdate(Empleado);
	}

	@Override
	public void delete(int id) {
		empleadosDAO.delete(id);
		
	}
	
	
	
}
