package com.proyecto.agenda.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(Persona.class).add(Restrictions.eq("idpersonas", id));
		Persona p1 = (Persona) criteria.uniqueResult();
		System.out.println(p1);

		return p1;
		
		/*
		Query query =  sessionFactory.getCurrentSession().createQuery("from Personas where idpersonas = :id");
        query.setInteger("id", id);
        //devuelve el objeto. Si no hay devuelve null
        Persona p1 = (Persona) query.uniqueResult();
		
		return p1;
		*/
		
		/*
		String hql = "from personas where idpersonas=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Persona> listUser = (List<Persona>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
		*/
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
