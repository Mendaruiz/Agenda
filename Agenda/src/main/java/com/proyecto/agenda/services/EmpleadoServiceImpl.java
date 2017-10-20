package com.proyecto.agenda.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.agenda.dao.IEmpleadosDAO;
import com.proyecto.agenda.model.Empleado;

@Service
@Transactional
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
