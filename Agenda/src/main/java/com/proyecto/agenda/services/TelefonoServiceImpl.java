package com.proyecto.agenda.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.agenda.dao.ITelefonosDAO;
import com.proyecto.agenda.model.Telefono;

@Service
@Transactional
public class TelefonoServiceImpl implements ITelefonoService {
	
	@Autowired
	private  ITelefonosDAO itelefonoDAO;
	
	@Override
	public List<Telefono> list() {
		// TODO Auto-generated method stub
		return itelefonoDAO.list();
	}

	@Override
	public Telefono get(int idtelefonos) {
		// TODO Auto-generated method stub
		return itelefonoDAO.get(idtelefonos);
	}

	@Override
	public void saveOrUpdate(Telefono Telefono) {
		itelefonoDAO.saveOrUpdate(Telefono);
	}

	@Override
	public void delete(int idtelefonos) {
		itelefonoDAO.delete(idtelefonos);
	}

	@Override
	public List<Telefono> getTelPer(int idpersona) {
		// TODO Auto-generated method stub
		return itelefonoDAO.getTelPer(idpersona);
	}
	

}