package com.proyecto.agenda.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.model.Persona;
import com.proyecto.agenda.model.Telefono;
import com.proyecto.agenda.services.ITelefonoService;
import com.proyecto.agenda.services.TelefonoServiceImpl;

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
	public List<Persona> list() throws NullPointerException{
		@SuppressWarnings("unchecked")
		List<Persona> listPersona = (List<Persona>) sessionFactory.getCurrentSession()
				.createCriteria(Persona.class)
				.setFetchMode("idtelefonos", FetchMode.JOIN).setFetchMode("iddirecciones", FetchMode.JOIN)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listPersona;
	}

	@Override
	@Transactional
	public Persona get(int id) {
		
		Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(Persona.class).add(Restrictions.eq("idpersonas", id));
		Persona p1 = (Persona) criteria.uniqueResult();
		System.out.println("Entra en el get de Persona");
		System.out.println(p1.toString());
		System.out.println("Sale del get");
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

	@Override
	public List<Persona> get(String nombre) {
		
		System.out.println("Entra en el get persona con el nombre: " + nombre);
		@SuppressWarnings("unchecked")
		List<Persona> list = (List<Persona>) sessionFactory.getCurrentSession()
		.createCriteria(Persona.class)
		.add(Restrictions.like("nombre", "%" + nombre + "%"))
		.setFetchMode("idtelefonos", FetchMode.JOIN).setFetchMode("iddirecciones", FetchMode.JOIN)
		.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		
		
		
		return list;
	}

}
