package com.upc.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.upc.Entities.Tipo_de_fondo;
import com.upc.Service.Tipo_de_fondoService;

@Controller
public class TipodeFondoController {
	@Autowired
	private Tipo_de_fondoService tfondoserv;

@RequestMapping(value="/nuevofondo")
public String nuevo(Model m)
{	m.addAttribute("fondo",new Tipo_de_fondo());
	return "nuevofondo";
}
@RequestMapping(value="/crearfondo")
public String crear(@Valid Tipo_de_fondo fondo, BindingResult result,Model m)
{	try {
	if(result.hasErrors())
	{	m.addAttribute("mensaje",result.toString());
		return "nuevofondo";
	}
	tfondoserv.crear(fondo);
	return "redirect:/fondos";
} catch (Exception e) {
	// TODO: handle exception
	m.addAttribute("mensaje",e.getMessage());
	return "nuevofondo";
}
}

@RequestMapping(value="/fondos")
public String listar(Model m)
{	m.addAttribute("fondos",tfondoserv.listartodos());
	return "fondos";
}
@RequestMapping(value="/verfondo{id}")
public String ver(@PathVariable int id, Model m)
{	m.addAttribute("fondo",tfondoserv.getbyid(id));
	return "verfondo";
}
@RequestMapping(value="/editarfondo{id}")
public String editar(@PathVariable int id, Model m)
{	m.addAttribute("fondo",tfondoserv.getbyid(id));
	return "editarfondo";
}
}
