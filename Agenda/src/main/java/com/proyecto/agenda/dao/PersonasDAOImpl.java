package com.proyecto.agenda.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.model.Persona;

@Repository
public class PersonasDAOImpl implements IPersonasDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PersonasDAOImpl() {
		
	}

	public PersonasDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Persona> list() {
		@SuppressWarnings("unchecked")
		List<Persona> listPersona = (List<Persona>) sessionFactory.getCurrentSession()
				.createCriteria(Persona.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listPersona;
	}

	@Override
	@Transactional
	public Persona get(int id) {
		String hql = "from personas where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Persona> listUser = (List<Persona>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Persona persona) {
		sessionFactory.getCurrentSession().saveOrUpdate(persona);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		Persona userToDelete = new Persona();
		userToDelete.setIdpersonas(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
		
	}

}
