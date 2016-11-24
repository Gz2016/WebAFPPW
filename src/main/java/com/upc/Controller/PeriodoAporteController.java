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

import com.upc.Entities.Periododeaporte;
import com.upc.Service.AfiliadoService;
import com.upc.Service.PeriododeaporteService;

@Controller
public class PeriodoAporteController {
@Autowired
private PeriododeaporteService paporteserv;
@Autowired
private AfiliadoService afiliadoService;

@RequestMapping(value="/nuevoperiododeaporte")
public String nuevo(Model m)
{
	m.addAttribute("periododeaporte",new Periododeaporte());
	m.addAttribute("afiliados", afiliadoService.listartodos());
	return "nuevoperiodo";
}
@RequestMapping(value="/crearperiododeaporte", method=RequestMethod.POST)
public String crear(@Valid Periododeaporte p, BindingResult result, Model m)
{try {
	if(result.hasErrors())
	{
		m.addAttribute("mensaje",result.toString());
		return "nuevoperiodo";
	}
	paporteserv.crear(p);
	return "redirect:/periodosdeaporte";	
} catch (Exception e) {
	m.addAttribute("mensaje",e.getMessage());
	return "nuevoperiodo";
	// TODO: handle exception
}
}
@RequestMapping(value="/periodosdeaporte")
public String listar(Model m)
{	m.addAttribute("periodos",paporteserv.listartodos());
	return "periodos";
}
@RequestMapping(value="/periodosdeaporteporfpago", method=RequestMethod.POST)
public String listarporestadodepago(@RequestParam String fpago,Model m)
{	m.addAttribute("periodos",paporteserv.listarporFpago(fpago));
	return "periodos";
}

@RequestMapping(value="/periodosdeaportedeafiliadoporfpago", method=RequestMethod.POST)
public String listarporafiliadoyfpago(@RequestParam int cafiliado,@RequestParam String fpago,Model m)
{	m.addAttribute("periodos",paporteserv.listarporFpagoyCafiliado(cafiliado, fpago));//EL AFILIADO INGRESA SU ID Y SELECCIONA UN ESTADO PAGADO O NO PAGADO-> SE ENVIA SI O NO 
	return "periodos";
}
@RequestMapping(value="/verperiodosdeaporte{id}")
public String Verperiododeaporte(@PathVariable int id,Model m)
{	m.addAttribute("periododeaporte",paporteserv.getPeriododeaportebyid(id));
	return "verperiodo";
}
@RequestMapping(value="/editarperiodosdeaporte{id}")
public String Editarperiodo(@PathVariable int id,Model m)
{	m.addAttribute("periododeaporte",paporteserv.getPeriododeaportebyid(id));
    m.addAttribute("afiliados", afiliadoService.listartodos());
	return "editarperiodo";
}
}
