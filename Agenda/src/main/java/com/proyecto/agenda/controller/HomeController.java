package com.proyecto.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.agenda.model.Persona;
import com.proyecto.agenda.model.User;
import com.proyecto.agenda.services.IPersonaService;

@Controller
public class HomeController {
	
	@Autowired
	private IPersonaService personaService;
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		
		/*System.out.println("Entra en la /");
		//Cuando se tenga la lista Usuario
		//List<User> listUsers = userService.list();
		List<User> list = new ArrayList<User>();
		
		User u1 = new User();
		u1.setUsername("prueba1");
		u1.setPassword("prueba1");
		u1.setEmail("prueba1@hotmail");
		System.out.println(u1.toString());
		
		
		User u2 = new User();
		u2.setUsername("prueba2");
		u2.setPassword("prueba2");
		u2.setEmail("prueba2@hotmail");
		
		System.out.println(u2.toString());
		
		User u3 = new User();
		u3.setUsername("prueba3");
		u3.setPassword("prueba3");
		u3.setEmail("prueba3@hotmail");
		
		System.out.println(u3.toString());
		
		list.add(u1);
		list.add(u2);
		list.add(u3);
		
		//Comprobar la lista
		for(int i= 0; i < list.size(); i++){
			System.out.println("Entra for");
			System.out.println(i);
			System.out.println(list.get(i).toString());
		}
		
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("list", list);*/
		
		System.out.println("Entra en la /");
		
		
		List<Persona> personas = personaService.list();
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("lista", personas);
		return model;
		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editPersona(HttpServletRequest request) {
		int personaId = Integer.parseInt(request.getParameter("idpersonas"));
		Persona persona = personaService.get(personaId);
		ModelAndView model = new ModelAndView("UserDetalles");
		model.addObject("persona", persona);
		return model;		
	}
	
}
