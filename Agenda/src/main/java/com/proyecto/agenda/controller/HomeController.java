package com.proyecto.agenda.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Binding;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.agenda.model.Persona;
import com.proyecto.agenda.model.Telefono;
import com.proyecto.agenda.model.User;
import com.proyecto.agenda.services.IPersonaService;
import com.proyecto.agenda.services.ITelefonoService;

@Controller
public class HomeController {
	
	@Autowired
	private IPersonaService personaService;
	@Autowired
	private ITelefonoService telefonoService;
	
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
		
		/* 
		for(int i = 0; i < personas.size(); i ++){
			System.out.println(personas.get(i).toString());
		}*/
		
		model.addObject("lista", personas);	
		return model;
		
	}
	/*
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public ModelAndView principal(){
		ModelAndView model = new ModelAndView("/");
	}
	*/
	
	@RequestMapping(value = "/telefonos", method = RequestMethod.GET)
	public ModelAndView listarTelfonos(){
		System.out.println("/telefonos");
		ModelAndView model = new ModelAndView("TelList");
		List<Telefono> telefonos = telefonoService.list();
		model.addObject("telefonos", telefonos);
		return model;
		
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newPersona() {
		System.out.println("/new");
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("persona", new Persona());
		return model;		
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchPersona(HttpServletRequest request) {
		System.out.println("/search");
		String nombre = request.getParameter("nombre");
		List<Persona> lista = new ArrayList<>();
		lista = personaService.get(nombre);
		ModelAndView model = new ModelAndView("UserSearch");
		model.addObject("lista", lista);
		return model;	
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView saveUser(@ModelAttribute Persona persona ,BindingResult br) {
		System.out.println("Entra");
		if(br.hasErrors()){
			System.out.println("Entra en el error");
			//System.out.println(fecha.toString());
			System.out.println(persona.toString());
			ModelAndView model = new ModelAndView("UserForm");
			model.addObject("persona", new Persona());
			return model;
		}
		//System.out.println(fecha.toString());
		System.out.println(persona.toString());
		System.out.println("/save");
		personaService.saveOrUpdate(persona);
		System.out.println(persona.toString());
		return new ModelAndView("redirect:/");
	}
	
}
