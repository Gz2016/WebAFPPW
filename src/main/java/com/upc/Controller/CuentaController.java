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

import com.upc.Entities.Cuenta;
import com.upc.Service.AfiliadoService;
import com.upc.Service.CuentaService;

@Controller
public class CuentaController {
@Autowired
private CuentaService cuentaserv;
@Autowired
private AfiliadoService aserv;
@RequestMapping(value="/nuevacuenta")
public String nuevacuenta(Model m)
{	m.addAttribute("afiliados",aserv.listartodos() );
	m.addAttribute("cuenta",new Cuenta());
	return "nuevacuenta";
}
@RequestMapping(value="/crearcuenta", method=RequestMethod.POST)
public String crearcuenta(@Valid Cuenta c, BindingResult result, Model m)
{	
	try {
		if(result.hasErrors())
		{
			m.addAttribute("mensaje", result.toString());
			m.addAttribute("afiliados",aserv.listartodos() );
			return "nuevacuenta";
		}
		//c.setFondo(0.0);
		cuentaserv.crear(c);
		return "redirect:/cuentas";
	} catch (Exception e) {
		// TODO: handle exception
		m.addAttribute("mensaje", e.getMessage());
		m.addAttribute("afiliados",aserv.listartodos() );
		return "nuevacuenta";
		//EN LA VISTA EL BOTON DONDE SE MOSTRARA EL ID AFILIADO DEBE TENER name="cafiliado", id="cafiliado" 
	}
	
}
@RequestMapping(value="/vercuenta{id}")
public String vercuenta(@PathVariable int id, Model m)
{ 	m.addAttribute("cuenta",cuentaserv.getCuentaporCcuenta(id));
	return "vercuenta";
}
@RequestMapping(value="/editarcuenta{id}")
public String editarcuenta(@PathVariable int id, Model m)
{ 	m.addAttribute("afiliados",aserv.listartodos() );
	m.addAttribute("cuenta",cuentaserv.getCuentaporCcuenta(id));
	return "editarcuenta";
}
@RequestMapping(value="/cuentas")
public String listar(Model m)
{	m.addAttribute("cuentas",cuentaserv.listartodos());
	return "cuentas";
}
@RequestMapping(value="/cuentasporafiliado{id}")
public String listarporafiliado(@PathVariable int id,Model m)
{	m.addAttribute("cuentas",cuentaserv.listarporCafiliado(id));
	return "cuentas";
}
@RequestMapping(value="/cuentasporrangofondo", method=RequestMethod.POST)
public String listarporrangofondo(@RequestParam double f1,@RequestParam double f2,Model m)
{	m.addAttribute("cuentas",cuentaserv.listarporrangofondoacumulado(f1,f2));
	return "cuentas";
}
@RequestMapping(value="/cuentasporrangosueldo", method=RequestMethod.POST)
public String listarporrangosueldo(@RequestParam double s1,@RequestParam double s2,Model m)
{	m.addAttribute("cuentas",cuentaserv.listarporsueldodeafiliado(s1, s2));
	return "cuentas";
}

}
