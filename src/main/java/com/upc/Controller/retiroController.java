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

import com.upc.Entities.retiro;
import com.upc.Service.CuentaService;
import com.upc.Service.retiroService;
import com.upc.Service.solicitud_retiroService;

@Controller
public class retiroController {
	
 @Autowired
 retiroService retiroservice;
 
 @Autowired
 solicitud_retiroService solicitudservice;
 
 @Autowired
 CuentaService cuentaservice;
 
 double montoretiro;
 //--------------------------Cargar vista de retiro ------------------
 @RequestMapping(value="/retironuevo")
 public String retiro(Model model)
 {
	 model.addAttribute("retiro", new retiro());
	 model.addAttribute("solicitudes", solicitudservice.findsolicitudByEstadoEnEspera());
	 model.addAttribute("cuentas", cuentaservice.listartodos());
	 return "newRetiro";
 }
 
 //--------------------------Agregar un retiro-----------------------
 @RequestMapping(value="/retiro", method=RequestMethod.POST)
 public String saveretiro(Model model, @Valid retiro r, BindingResult result)
 {

	 try
	 {
		 if(result.hasErrors())
		 {
			 model.addAttribute("message", result.toString());
		 model.addAttribute("solicitudes",solicitudservice.findsolicitudByEstadoEnEspera());
			 model.addAttribute("cuentas", cuentaservice.listartodos());
			 return "newRetiro";
		 }
		 //montoretiro=retiroservice.calcularmontoretiro(r);
		 //r.setMontoretiro(montoretiro);
		 retiroservice.saveretiro(r);
		 
		 return "redirect:/retiros";
	 }
	 catch (Exception e)
	 {
		 model.addAttribute("message", e.getMessage());
        model.addAttribute("solicitudes",solicitudservice.findsolicitudByEstadoEnEspera());
          model.addAttribute("cuentas", cuentaservice.listartodos());
		 return "newRetiro";
	 }
 }
 
 //------------------------Lista todos los retiros-----------------
 @RequestMapping(value="/retiros", method=RequestMethod.GET)
 public String listretiros (Model model)
 {
	 model.addAttribute("retiros", retiroservice.findall());
	 return "retiros";

 }
 
 //-----------------Lista retiros por cuenta-------------------
 @RequestMapping(value="/retirobycuenta", method= RequestMethod.POST)
 public String listretirobyCuenta(Model model, @RequestParam int id)
 {
	 model.addAttribute("retiros", retiroservice.getretiroByCuenta(id));
	 return"retiros";
 }
 
 //-----------Obtener retiro por solicitud--------------
 @RequestMapping(value="/retirobysolicitud",method=RequestMethod.POST)
 public String getretirobySolicitud( Model model, @RequestParam int id)
 {
	 model.addAttribute("retiros", retiroservice.getretiroBySolicitud(id));
	 return "retiros";
 }
 //--------Elimina retiro----------------
	@RequestMapping(value="/retirosdelete{id}",method=RequestMethod.GET)
	public String deleteretiro(Model model,@PathVariable int id)
	{ 
		retiroservice.deleteretiro(id);
		return"redirect:/retiros";
	}
 
 
 
}
