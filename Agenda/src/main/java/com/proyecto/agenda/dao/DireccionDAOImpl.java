package com.proyecto.agenda.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.model.Direccion;
import com.proyecto.agenda.model.Direccion;
import com.proyecto.agenda.model.Direccion;

@Repository
public class DireccionDAOImpl implements IDireccionesDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public DireccionDAOImpl() {
		
	}

	
	public DireccionDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<Direccion> list() {
		@SuppressWarnings("unchecked")
		List<Direccion> listDir = (List<Direccion>) sessionFactory.getCurrentSession()
				.createCriteria(Direccion.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		System.out.println("entra list");
		return listDir;
	}

	@Transactional
	public Direccion get(int iddirecciones) {
		String hql = "from tdirecciones where iddirecciones=" + iddirecciones;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Direccion> listDireccion= (List<Direccion>) query.list();
		
		if (listDireccion != null && !listDireccion.isEmpty()){
			return listDireccion.get(0);
		}
		
		return null;
	}

	@Transactional
	public List<Direccion> getDirPer(int idpersona) {
		List<Direccion> listaDir = (List<Direccion>) sessionFactory.getCurrentSession().createCriteria(Direccion.class).add(Restrictions.eq("idPersona", idpersona)).list();

		return listaDir;
	}

	@Transactional
	public void saveOrUpdate(Direccion direccion) {
		sessionFactory.getCurrentSession().saveOrUpdate(direccion);
		
	}

	@Transactional
	public void delete(int iddirecciones) {
		Direccion DireccionDelete = new Direccion();
		DireccionDelete.setIddirecciones(iddirecciones);
		sessionFactory.getCurrentSession().delete(DireccionDelete);
		
	}

	
}
