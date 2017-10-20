package com.proyecto.agenda.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.model.Direccion;

@Repository
public class DireccionesDAOImpl implements IDireccionesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public DireccionesDAOImpl(){
		
	}
	
	public DireccionesDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Direccion> list(){
		@SuppressWarnings("unchecked")
		List<Direccion> listDireccion=(List<Direccion>) sessionFactory.getCurrentSession().createCriteria(Direccion.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listDireccion;
	}
	
	@Override
	@Transactional
	public Direccion get(int id){
		String hql = "from direcciones where iddirecciones=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Direccion> listDireccion=(List<Direccion>) query.list();
		
		if(listDireccion != null && !listDireccion.isEmpty()){
			return listDireccion.get(0);
		}
		
		return null;
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(Direccion dir){
		sessionFactory.getCurrentSession().saveOrUpdate(dir);
	}
	
	@Override
	@Transactional
	public void delete(int id){
		Direccion dirToDelete = new Direccion();
		dirToDelete.setIddirecciones(id);
		sessionFactory.getCurrentSession().delete(dirToDelete);
	}
}
