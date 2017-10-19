package com.proyecto.agenda.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.model.Departamento;

@Repository
public class DepartamentosDAOImpl implements IDepartamentosDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public DepartamentosDAOImpl(){
		
	}
	
	public DepartamentosDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Departamento> list() {
		// TODO Auto-generated method stub
		List<Departamento> listUser = (List<Departamento>) sessionFactory.getCurrentSession()
				.createCriteria(Departamento.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public Departamento get(int iddepartamento) {
		// TODO Auto-generated method stub
		String hql = "from departamento where iddepartamento=" + iddepartamento;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Departamento> listDepartamento = (List<Departamento>) query.list();
		
		if (listDepartamento != null && !listDepartamento.isEmpty()) {
			return listDepartamento.get(0);
		}
		
		return null;
	}

	@Override
	public void saveOrUpdate(Departamento departamento) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(departamento);
	}

	@Override
	public void delete(int iddepartamento) {
		// TODO Auto-generated method stub
		Departamento departamentoToDelete = new Departamento();
		departamentoToDelete.setIddepartamento(iddepartamento);
		sessionFactory.getCurrentSession().delete(departamentoToDelete);
		
	}

	
	
}
