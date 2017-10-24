package com.proyecto.agenda.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.agenda.dao.IDireccionesDAO;
import com.proyecto.agenda.dao.ITelefonosDAO;
import com.proyecto.agenda.model.Direccion;

@Service
@Transactional
public class DireccionService implements IDireccionService{

	
	@Autowired
	private  IDireccionesDAO idireccionDAO;
	
	@Override
	public List<Direccion> list() {
		return idireccionDAO.list();
	}

	@Override
	public Direccion get(int iddirecciones) {
		return idireccionDAO.get(iddirecciones);
	}

	@Override
	public List<Direccion> getDirPer(int idpersona) {
		return idireccionDAO.getDirPer(idpersona);
	}

	@Override
	public void saveOrUpdate(Direccion direccion) {
		idireccionDAO.saveOrUpdate(direccion);
		
	}

	@Override
	public void delete(int iddirecciones) {
		idireccionDAO.delete(iddirecciones);
		
	}
	
	

}
