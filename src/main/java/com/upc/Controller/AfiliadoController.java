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

import com.upc.Entities.Afiliado;
import com.upc.Service.AfiliadoService;
import com.upc.Service.Tipo_de_fondoService;
import com.upc.Service.rep_empresaService;

@Controller
public class AfiliadoController {
@Autowired
private AfiliadoService afiliadoserv;
@Autowired
private Tipo_de_fondoService tipodefondoserv;
@Autowired
private rep_empresaService repempresaService;

@RequestMapping(value="/nuevoafiliado")
public String nuevoafiliado(Model m)
{
	m.addAttribute("afiliado",new Afiliado());
	m.addAttribute("tipodefondos", tipodefondoserv.listartodos());
	m.addAttribute("empresas", repempresaService.listAllRepEmpresas());
	return "nuevoafiliado"; //VISTA <input placeholder="ID de la empresa" type="text" th:field="*{crep_empresa.crep_empresa}"/>
}
@RequestMapping(value="/crearafiliado", method=RequestMethod.POST)
public String crearafiliado(@Valid Afiliado a,BindingResult result, Model m)
{
	try {
		if(result.hasErrors())
		{
			m.addAttribute("mensaje",result.toString());
			m.addAttribute("tipodefondos", tipodefondoserv.listartodos());
			m.addAttribute("empresas", repempresaService.listAllRepEmpresas());
			return "nuevoafiliado"; 
		}
		afiliadoserv.crear(a);
		m.addAttribute("tipodefondos", tipodefondoserv.listartodos());//PARA QUE NO SE PIERDA LA LISTA DE PRODUCTOS
		return "redirect:/afiliados";//REGRESA A LA VISTA
		
	} catch (Exception e) {
		m.addAttribute("mensaje",e.getMessage());
		return "nuevoafiliado"; 
		// TODO: handle exception
	}
}
@RequestMapping(value="/verafiliado{id}")
public String verafiliado(@PathVariable int id, Model m)
{	Afiliado a =afiliadoserv.getporcafiliado(id);
	m.addAttribute("afiliado", a);
	m.addAttribute("fondo", tipodefondoserv.getbyid(a.getCtipofondo().getCtipofondo()));//PARA PODER MOSTRAR TODOS LOS ATRIBUTOS DEL OBJETO FONDO DEL AFILIADO
return "verafiliado";
}
@RequestMapping(value="/editarafiliado{id}")
public String editarafiliado(@PathVariable int id,Model m)
{	Afiliado a =afiliadoserv.getporcafiliado(id);
	m.addAttribute("afiliado", a);
	m.addAttribute("fondo", tipodefondoserv.getbyid(a.getCtipofondo().getCtipofondo()));//PARA PODER MOSTRAR TODOS LOS ATRIBUTOS DEL OBJETO FONDO DEL AFILIADO
	m.addAttribute("tipodefondos",tipodefondoserv.listartodos());
	m.addAttribute("empresas", repempresaService.listAllRepEmpresas());
	return "editarafiliado";
}
@RequestMapping(value="/eliminarafiliado{id}")
public String eliminarafiliado(@PathVariable int id)
{afiliadoserv.eliminarafiliado(id);
return "redirect:/afiliados";
}
@RequestMapping(value="/afiliados")
public String listar(Model m)
{	m.addAttribute("afiliados", afiliadoserv.listartodos());
	return "afiliados";
}
@RequestMapping(value="/afiliadosporfondo", method=RequestMethod.POST)
public String listarporfondo(@RequestParam String nfondo,Model m)
{	m.addAttribute("afiliados", afiliadoserv.listarpornfondo(nfondo));
	return "afiliados";
}

@RequestMapping(value="/afiliadosporrangosueldo", method=RequestMethod.POST)//QUIENES PRESENTAN SUELDOS ELEVADOS
public String listarporrangosueldo(@RequestParam double s1, @RequestParam double s2 ,Model m)
{	m.addAttribute("afiliados", afiliadoserv.listarporrangosueldo(s1, s2));
	return "afiliados";
}

@RequestMapping(value="/afiliadosporrangointeres", method=RequestMethod.POST) //QUE TAN MOROSOS SON LOS AFILIADOS
public String listarporrangointeres(@RequestParam double m1, @RequestParam double m2 ,Model m)
{	m.addAttribute("afiliados", afiliadoserv.listarporrangodeinteresdeaporte(m1, m2));
	return "afiliados";
}
@RequestMapping(value="/afiliadospordiasdemoramayora", method=RequestMethod.POST) //CUANTOS TIENEN MAS DIAS DE INCUMPLIMIENTO DE PAGO QUE EL INDICADO
public String listarpordiasdemoramayora(@RequestParam int qdias,Model m)
{	m.addAttribute("afiliados", afiliadoserv.listarpordiasdemoramayora(qdias));
	return "afiliados";
}

}
