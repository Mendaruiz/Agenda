package com.proyecto.agenda.services;

import java.util.List;

import com.proyecto.agenda.model.Telefono;;

public interface ITelefonoService {
		
		public List<Telefono> list();
		
		public Telefono get(int idtelefonos);
		
		public void saveOrUpdate(Telefono Telefono);
		
		public void delete(int idtelefonos);
}
