package com.upc.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.Service.AfiliadoService;
import com.upc.Service.OperadorService;
import com.upc.Service.solicitud_retiroService;


import com.upc.Entities.solicitud_retiro;
@Controller
public class solicitud_retiroController {

	@Autowired 
	solicitud_retiroService solicitudservice;
	@Autowired
	AfiliadoService afiliadoservice;
	@Autowired
	OperadorService operadorservice;
	
	//---------------------- Cargar vista newSolicitudRetiro--------------------
	@RequestMapping(value="/solicitud_retironuevo")
	public String solicitud_retiro(Model model)
	{
		model.addAttribute("solicitud_retiro", new solicitud_retiro());
		model.addAttribute("afiliados", afiliadoservice.listartodos());
		model.addAttribute("operadores", operadorservice.listAll());
		return "newSolicitudRetiro";
	}
	//-----------------------Editar Solicitud----------------------------- ESTE ES PRUEBA, SE CONSIDERA QUE AL CREAR UNA SOLICITUD SE RECHAZA O SE APRUEBA AL INSTANTE, NO HAY UNA ESPERA
	@RequestMapping(value="/editarsolicitud{id}")
	public String editar(@PathVariable int id, Model m)
	{ solicitud_retiro s= solicitudservice.getsolicitudById(id);
		m.addAttribute("solicitud_retiro",s);
		m.addAttribute("afiliados", afiliadoservice.listartodos());
		m.addAttribute("operadores", operadorservice.listAll());
		return "editarsolicitud";
	}
	
	
	//---------------------------GuardaSolicitud--------------------------------
	
	@RequestMapping(value="/solicitud_retiro", method=RequestMethod.POST)
	public String savesolicitud(Model model, @Valid solicitud_retiro sr, BindingResult result)
	{
		try
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				model.addAttribute("afiliados", afiliadoservice.listartodos());
				model.addAttribute("operadores", operadorservice.listAll());
				return "newSolicitudRetiro";
			}
			
			solicitudservice.savesolicitud(sr);
			return "redirect:/solicitudes";
		}
		catch(Exception e)
		{
			model.addAttribute("message",e.getMessage());
			
			return " newSolicitudRetiro";
		}
	}
	
	//------------------------------ListalasSolicitudes sin ningun criterio--------------------
	@RequestMapping(value="/solicitudes", method=RequestMethod.GET)
	public String listsolicitudes(Model model)
	{
		model.addAttribute("solicitudes", solicitudservice.findall());
		return "solicitudes";
	}
	
	//----------------------------Lista las solicitudes por afiliado --------------------------
	
	@RequestMapping(value="/solicitudesporafiliado",method=RequestMethod.POST)
	public String solicitudesbyAfiliado(Model model, @RequestParam int id)
	{
		model.addAttribute("solicitudes", solicitudservice.findsolicitudByIdAfiliado(id));
		return "solicitudes";
	}
	
	//----------------------------Lista las solicitudes por estado --------------------------
	
		@RequestMapping(value="/solicitudesporestado",method=RequestMethod.POST)
		public String solicitudesbyEstado(Model model, @RequestParam String estado)
		{
			model.addAttribute("solicitudes", solicitudservice.findsolicitudByEstado(estado));
			return "solicitudes";
		}
	
	//------------------------Lista las solicitudes atendidas por operador------------------
	@RequestMapping(value="/solicitudes/operador",method=RequestMethod.POST)
	public String solicitudesbyOperador(Model model, @RequestParam int id)
	{
		model.addAttribute("solicitudes", solicitudservice.findsolicitudByIdOperador(id));
		return "solicitudes";
	}
	
	//-----------------------Elimina Solicitud----------------------------
	@RequestMapping(value="/solicitudesdelete{id}",method=RequestMethod.GET)
	public String deletesolicitud(Model model,@PathVariable int id)
	{ 
		solicitudservice.deletesolicitud(id);
		return"redirect:/solicitudes";
	}
	
	//---------------Obtener Solicitud por Id------------------------------------
	@RequestMapping(value="/solicitudes",method=RequestMethod.POST)
	public String findsolicitudbyId(Model model, @RequestParam int id)
	{
		model.addAttribute("solicitudes", solicitudservice.getsolicitudById(id));
		return"redirect:/solicitudes";
	}
	
}
