package com.proyecto.agenda.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.model.Categoria;

@Repository
public class CategoriaDAOImpl implements ICategoriasDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoriaDAOImpl(){
		
	}
	
	public CategoriaDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Categoria> list(){
		@SuppressWarnings("unchecked")
		List<Categoria> listCategoria=(List<Categoria>) sessionFactory.getCurrentSession().createCriteria(Categoria.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategoria;
	}
	
	@Override
	@Transactional
	public Categoria get(int id){
		String hql = "from categorias where idcategorias=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Categoria> listCategoria=(List<Categoria>) query.list();
		
		if(listCategoria != null && !listCategoria.isEmpty()){
			return listCategoria.get(0);
		}
		
		return null;
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(Categoria dir){
		sessionFactory.getCurrentSession().saveOrUpdate(dir);
	}
	
	@Override
	@Transactional
	public void delete(int id){
		Categoria catToDelete = new Categoria();
		catToDelete.setIdcategorias(id);
		sessionFactory.getCurrentSession().delete(catToDelete);
	}
	
	
}
