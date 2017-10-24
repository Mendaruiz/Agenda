package com.proyecto.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.dao.DireccionesDAOImpl;
import com.proyecto.agenda.dao.IDireccionesDAO;
import com.proyecto.agenda.model.Direccion;

@Service
@Transactional
public class DireccionServiceImpl implements IDireccionService {
	
	@Autowired
	private IDireccionesDAO direccionDao;
	
	@Override
	public List<Direccion> list(){
		return direccionDao.list();
	}
	
	@Override
	public Direccion get(int iddirecciones){
		return direccionDao.get(iddirecciones);
	}
	
	@Override
	public void saveOrUpdate(Direccion direccion){
		direccionDao.saveOrUpdate(direccion);
	}
	
	@Override
	public void delete(int iddirecciones){
		direccionDao.delete(iddirecciones);
	}
}