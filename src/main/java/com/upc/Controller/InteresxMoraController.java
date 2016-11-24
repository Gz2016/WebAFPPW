package com.upc.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.upc.Entities.Interesxmora;
import com.upc.Service.InteresxmoraService;

@Controller
public class InteresxMoraController {
@Autowired
private InteresxmoraService iserv;
//ESTE METODO ES SOLO PARA ACTUALIZAR LA MORA CREADA EN APORTE CONTROLLER
@RequestMapping(value="/crearmora")
public String actualizar(@Valid Interesxmora i, BindingResult result, Model m)
{	try {
	if(result.hasErrors())
	{
		m.addAttribute("mensaje",result.toString());
		return "nuevamora";
	}
		iserv.crear(i);
		return "redirect:/moras";
} catch (Exception e) {
	// TODO: handle exception
	m.addAttribute("mensaje",e.getMessage());
}
	
	m.addAttribute("mora", new Interesxmora());
	return "nuevamora";
}
@RequestMapping(value="/todaslasmoras")
public String listar(Model m)
{	
	m.addAttribute("moras",iserv.listartodos());
	return "moras";
}
@RequestMapping(value="/vermora{id}")
public String vermora(@PathVariable int id, Model m)
{	
	m.addAttribute("mora",iserv.getInteresxmoraporid(id));
	return "vermora";
}

@RequestMapping(value="/editarmora{id}")
public String editar(@PathVariable int id ,Model m)
{	
	m.addAttribute("mora",iserv.getInteresxmoraporid(id));
	return "editarmora";
}

@RequestMapping(value="/moras")
public String listarmoras(Model m)
{	
	m.addAttribute("moras",iserv.listarpormontomayora(0.0));
	return "moras";
}


}
