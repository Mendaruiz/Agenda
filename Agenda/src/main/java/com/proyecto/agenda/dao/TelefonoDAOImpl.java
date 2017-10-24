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
import com.proyecto.agenda.model.Telefono;

@Repository
public class TelefonoDAOImpl implements ITelefonosDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public TelefonoDAOImpl(){
	}

	public TelefonoDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void delete (int idtelefonos){
		Telefono telefonoDelete = new Telefono();
		telefonoDelete.setIdtelefonos(idtelefonos);
		sessionFactory.getCurrentSession().delete(telefonoDelete);
	}
	
	@Transactional
	public Telefono get(int idtelefonos){
		
		String hql = "from telefonos where idtelefonos=" + idtelefonos;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Telefono> listTelefono = (List<Telefono>) query.list();
		
		if (listTelefono != null && !listTelefono.isEmpty()){
			return listTelefono.get(0);
		}
		
		return null;
	}

	@Override
	@Transactional
	public List<Telefono> list() {
		@SuppressWarnings("unchecked")
		List<Telefono> listTlf = (List<Telefono>) sessionFactory.getCurrentSession()
				.createCriteria(Telefono.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		System.out.println("entra list");
		return listTlf;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Telefono telefono) {
		sessionFactory.getCurrentSession().saveOrUpdate(telefono);
	}
	
	@Transactional
	public List<Telefono> getTelPer(int idpersona){
		
		List<Telefono> listaTel = (List<Telefono>) sessionFactory.getCurrentSession().createCriteria(Telefono.class).add(Restrictions.eq("idPersona", idpersona)).list();

		return listaTel;
	}
	
}