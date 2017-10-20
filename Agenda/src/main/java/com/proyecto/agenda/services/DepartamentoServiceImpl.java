package com.proyecto.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.model.Departamento;
import com.proyecto.agenda.dao.*;

@Service
@Transactional
public class DepartamentoServiceImpl implements IDepartamentoService {

	@Autowired
	private IDepartamentosDAO iDepartamentosDAO;
	
	@Override
	public List<Departamento> list() {
		// TODO Auto-generated method stub
		return iDepartamentosDAO.list();
	}

	@Override
	public Departamento get(int iddepartamento) {
		// TODO Auto-generated method stub
		return iDepartamentosDAO.get(iddepartamento);
	}

	@Override
	public void saveOrUpdate(Departamento departamento) {
		// TODO Auto-generated method stub
		iDepartamentosDAO.saveOrUpdate(departamento);
	}

	@Override
	public void delete(int iddepartamento) {
		// TODO Auto-generated method stub
		iDepartamentosDAO.delete(iddepartamento);
	}

	
}
