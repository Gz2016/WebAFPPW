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

import com.upc.Entities.Aporte;
import com.upc.Service.AporteService;
import com.upc.Service.InteresxmoraService;

@Controller
public class AporteController {
@Autowired
private AporteService aserv;
@Autowired
private InteresxmoraService iserv;

@RequestMapping(value="/nuevoaporte")
public String nuevo(Model m)
{
	m.addAttribute("aporte",new Aporte());
	
	return "nuevoaporte"; //VISTA
}
@RequestMapping(value="/crearaporte", method=RequestMethod.POST)
public String crear(@Valid Aporte a,BindingResult result, Model m)
{
	try {
		if(result.hasErrors())
		{
			m.addAttribute("mensaje",result.toString());
			return "nuevoaporte"; 
		}

		iserv.crear(a.getCintxmora());//CREA UN OBJETOINTXMORA				
		aserv.crear(a);	
		
		return "redirect:/aportes";//PARA ESTO EN LA VISTA SE DEBE INDICAR name="ccuenta" ,id="ccuenta" en el control donde se mostrara id de la cuenta
		
	} catch (Exception e) {
		m.addAttribute("mensaje",e.getMessage());
		return "nuevoaporte";
		// TODO: handle exception
	}
}
@RequestMapping(value="/veraporte{id}")
public String ver(@PathVariable int id, Model m)
{	Aporte a =aserv.getporcaporte(id);
	m.addAttribute("aporte", a);
	m.addAttribute("interesxmora", iserv.getInteresxmoraporid(a.getCintxmora().getCintxmora()));
	return "veraporte";
}
@RequestMapping(value="/editaraporte{id}")
public String editar(@PathVariable int id,Model m)
{	Aporte a =aserv.getporcaporte(id);
	m.addAttribute("aporte", a);
	m.addAttribute("interesxmora", iserv.getInteresxmoraporid(a.getCintxmora().getCintxmora()));
return "editaraporte";
}
@RequestMapping(value="/aportes")
public String listar(Model m)
{	m.addAttribute("aportes", aserv.listartodos());
	return "aportes";
}
@RequestMapping(value="/aportesporcuenta", method=RequestMethod.POST)
public String listarporcuenta(@RequestParam int ccuenta,Model m)//TODOS LOS APORTES DE UNA CUENTA
{	m.addAttribute("aportes", aserv.listarporcuenta(ccuenta));
	return "aportes";
}
@RequestMapping(value="/aportesporcuenta{id}")
public String listarporccuenta(@PathVariable int id,Model m)//TODOS LOS APORTES DE UNA CUENTA
{	m.addAttribute("aportes", aserv.listarporcuenta(id));
	return "aportes";
}
@RequestMapping(value="/aportespordniafiliado", method=RequestMethod.POST)
public String listarpordniafiliado(@RequestParam int dni,Model m)//TODOS LOS APORTES DE UNA CUENTA
{	m.addAttribute("aportes", aserv.listarpordniafiliado(dni));
	return "aportes";
}

//FORMATO PARA FECHA 11-11-1111
@RequestMapping(value="/aportesporidyrangofecha", method=RequestMethod.POST)
public String listarporidyrangofecha(@RequestParam int idcuenta, @RequestParam String f1, @RequestParam String f2, Model m)
{	m.addAttribute("aportes", aserv.listarporcuentayrangofechadepago(idcuenta, f1, f2));//EL AFILIADO INGRESA SU CODIGO DE CUENTA Y FECHAS PARA VER SUS APORTES
	return "aportes";
}
@RequestMapping(value="/aportesporrangofecha", method=RequestMethod.POST)
public String listarporrangofecha(@RequestParam String f1, @RequestParam String f2, Model m)//LOS APORTES DE TODOS LOS AFILIADOS POR UN RANGO DE FECHA 
{	m.addAttribute("aportes", aserv.listarporrangodefechapago(f1, f2));
	return "aportes";
}
@RequestMapping(value="/aportesporrangomonto", method=RequestMethod.POST)//LOS APORTES DE TODOS LOS AFILIADOS POR RANGO DE MONTO ACUMULADO
public String listarrangofecha(@RequestParam double m1, @RequestParam double m2, Model m)
{	m.addAttribute("aportes", aserv.listarporrangodemontoaporte(m1, m2));
	return "aportes";
}



}
