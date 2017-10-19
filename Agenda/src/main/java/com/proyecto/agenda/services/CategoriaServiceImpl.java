package com.proyecto.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.dao.CategoriaDAOImpl;
import com.proyecto.agenda.model.Categoria;

@Service
@Transactional
public class CategoriaServiceImpl implements ICategoriaService {
	
	@Autowired
	private CategoriaDAOImpl catDao;
	
	@Override
	public List<Categoria> list(){
		return catDao.list();
	}
	
	@Override
	public Categoria get(int id){
		return catDao.get(id);
	}
	
	@Override
	public void saveOrUpdate(Categoria dir){
		catDao.saveOrUpdate(dir);
	}
	
	@Override
	public void delete(int id){
		catDao.delete(id);
	}
}
