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

import com.proyecto.agenda.model.Direccion;
import com.proyecto.agenda.model.Persona;
import com.proyecto.agenda.model.Telefono;
import com.proyecto.agenda.model.User;
import com.proyecto.agenda.services.IDireccionService;
import com.proyecto.agenda.services.IPersonaService;
import com.proyecto.agenda.services.ITelefonoService;

@Controller
public class HomeController {
	
	@Autowired
	private IPersonaService personaService;
	@Autowired
	private ITelefonoService telefonoService;
	@Autowired
	private IDireccionService direccionService;
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {

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
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deletePersona(HttpServletRequest request){
		int personaId = Integer.parseInt(request.getParameter("id"));
		personaService.delete(personaId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public ModelAndView detailPerson(HttpServletRequest request) {
		System.out.println("/detalle");
		int id = Integer.parseInt(request.getParameter("idpersona"));
		System.out.println(id);
		Persona persona = personaService.get(id);
		ModelAndView model = new ModelAndView("UserDetalles");
		model.addObject("persona", persona);
		return model;	
	}
	
	@RequestMapping(value = "/direcciones", method = RequestMethod.GET)
	public ModelAndView listarDirecciones(){
		System.out.println("/direcciones");
		ModelAndView model = new ModelAndView("DirList");
		List<Direccion> direcciones = direccionService.list();
		model.addObject("direcciones", direcciones);
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
		if(br.hasErrors()){
			System.out.println("Entra en el error");
			System.out.println(persona.toString());
			ModelAndView model = new ModelAndView("UserForm");
			model.addObject("persona", new Persona());
			return model;
		}
		personaService.saveOrUpdate(persona);
		return new ModelAndView("redirect:/");
	}
	
}
