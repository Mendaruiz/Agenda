package com.proyecto.agenda.controller;

import java.io.UnsupportedEncodingException;
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
		model.addObject("lista", personas);
		return model;
		
	}

	
	@RequestMapping(value = "/telefonos", method = RequestMethod.GET)
	public ModelAndView listarTelfonos(){
		System.out.println("/telefonos");
		ModelAndView model = new ModelAndView("TelList");
		List<Telefono> telefonos = telefonoService.list();
		model.addObject("telefonos", telefonos);
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
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deletePersona(HttpServletRequest request){
		int personaId = Integer.parseInt(request.getParameter("id"));
		personaService.delete(personaId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/deleteDir", method=RequestMethod.GET)
	public ModelAndView deleteDireccion(HttpServletRequest request){
		int personaId = Integer.parseInt(request.getParameter("id"));
		direccionService.delete(personaId);
		return new ModelAndView("redirect:/direcciones");
	}
	@RequestMapping(value="/deleteTel", method=RequestMethod.GET)
	public ModelAndView deleteTelefono(HttpServletRequest request){
		int personaId = Integer.parseInt(request.getParameter("id"));
		telefonoService.delete(personaId);
		return new ModelAndView("redirect:/telefonos");
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
		
		for(int i = 0; i < lista.size(); i++){
			System.out.println(lista.get(i).getNombre());
		}
		
		
		ModelAndView model = new ModelAndView("UserSearch");
		model.addObject("lista", lista);
		return model;	
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/newTel", method = RequestMethod.GET)
	public ModelAndView newTelefono(HttpServletRequest request) {
		System.out.println("------------------  Entra en newTel ----------------------");
		System.out.println("/newTel");
		int idPersona = Integer.parseInt(request.getParameter("id"));
		ModelAndView model = new ModelAndView("TlfForm");
		Telefono telefono = new Telefono();
		telefono.setPersona(personaService.get(idPersona));
		model.addObject("telefono", telefono);
		model.addObject("idPersona", idPersona);
		return model;		
	}
	
	@RequestMapping(value = "/saveTlf", method = RequestMethod.POST)
	public ModelAndView saveTlf(@ModelAttribute Telefono telefono ,BindingResult br, HttpServletRequest request) {
		if(br.hasErrors()){
			System.out.println("------------------------- Entra en el error -------------------------");
			ModelAndView model = new ModelAndView("TlfForm");
			model.addObject("telefono", telefono);
			return model;
		}
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------------  Entra en saveTlf ----------------------");
		System.out.println(telefono.toString());
		telefonoService.saveOrUpdate(telefono);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/newDir", method = RequestMethod.GET)
	public ModelAndView newDireccion(HttpServletRequest request) {
		System.out.println("------------------  Entra en newDir ----------------------");
		System.out.println("/newDir");
		int idPersona = Integer.parseInt(request.getParameter("id"));
		ModelAndView model = new ModelAndView("DirForm");
		Direccion direccion = new Direccion();
		System.out.println("Introducimos en el telefono la persona con la id correspondiente");
		direccion.setPersona(personaService.get(idPersona));
		System.out.println("Mostramos el nombre de la persona: " + direccion.getPersona().getNombre());
		model.addObject("direccion", direccion);
		model.addObject("idPersona", idPersona);
		return model;		
	}
	
	@RequestMapping(value = "/saveDir", method = RequestMethod.POST)
	public ModelAndView saveDir(@ModelAttribute Direccion direccion ,BindingResult br, HttpServletRequest request) {
		if(br.hasErrors()){
			System.out.println("------------------------- Entra en el error -------------------------");
			System.out.println(direccion.toString());
			System.out.println();
			ModelAndView model = new ModelAndView("DirForm");
			model.addObject("direccion", direccion);
			return model;
		}
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("------------------  Entra en saveDir ----------------------");
		System.out.println(direccion.toString());
		direccionService.saveOrUpdate(direccion);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editPerson", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		Persona persona = personaService.get(userId);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("persona", persona);
		return model;		
	}
	
}
