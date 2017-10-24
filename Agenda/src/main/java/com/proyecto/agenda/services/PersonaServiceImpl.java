package com.proyecto.agenda.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.agenda.dao.IPersonasDAO;
import com.proyecto.agenda.model.Persona;

@Service
@Transactional
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonasDAO personaDao;
	
	@Override
	public List<Persona> list() {
		return personaDao.list();
	}

	@Override
	public Persona get(int id) {
		return personaDao.get(id);
	}

	@Override
	public void saveOrUpdate(Persona persona) {
		personaDao.saveOrUpdate(persona);
		
	}

	@Override
	public void delete(int id) {
		personaDao.delete(id);
		
	}

	@Override
	public List<Persona> get(String nombre) {
		return personaDao.get(nombre);
	}

}
