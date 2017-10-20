package com.proyecto.agenda.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.agenda.model.Empleado;

public class EmpleadosDAOImpl implements IEmpleadosDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public EmpleadosDAOImpl() {
	}
	

	public EmpleadosDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Empleado> list() {
		@SuppressWarnings("unchecked")
		List<Empleado> listEmpleado = (List<Empleado>) sessionFactory.getCurrentSession()
				.createCriteria(Empleado.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listEmpleado;
	}

	@Override
	@Transactional
	public Empleado get(int id) {
		String hql = "from Empleados where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Empleado> listUser = (List<Empleado>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}

	@Override
	public void saveOrUpdate(Empleado empleado) {
		sessionFactory.getCurrentSession().saveOrUpdate(empleado);
		
	}

	@Override
	public void delete(int id) {
		Empleado userToDelete = new Empleado();
		userToDelete.setIdempleados(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
		
	}

}
