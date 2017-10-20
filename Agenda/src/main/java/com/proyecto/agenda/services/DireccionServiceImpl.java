package com.proyecto.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.dao.DireccionesDAOImpl;
import com.proyecto.agenda.model.Direccion;

@Service
@Transactional
public class DireccionServiceImpl implements IDireccionService {
	
	@Autowired
	private DireccionesDAOImpl dirDao;
	
	@Override
	public List<Direccion> list(){
		return dirDao.list();
	}
	
	@Override
	public Direccion get(int id){
		return dirDao.get(id);
	}
	
	@Override
	public void saveOrUpdate(Direccion dir){
		dirDao.saveOrUpdate(dir);
	}
	
	@Override
	public void delete(int id){
		dirDao.delete(id);
	}
}
