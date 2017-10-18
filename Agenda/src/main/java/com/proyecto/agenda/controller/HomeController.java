package com.proyecto.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.agenda.model.User;


public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		
		//Cuando se tenga la lista Usuario
		//List<User> listUsers = userService.list();
		List<User> list = new ArrayList<User>();
		
		User u1 = new User();
		u1.setUsername("prueba1");
		u1.setPassword("prueba1");
		u1.setEmail("prueba1@hotmail");
		
		User u2 = new User();
		u1.setUsername("prueba2");
		u1.setPassword("prueba2");
		u1.setEmail("prueba2@hotmail");
		
		list.add(u1);
		list.add(u2);
		
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("userList", list);
		return model;
		
	}
	
}
