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

import com.upc.Entities.Operador;
import com.upc.Service.OperadorService;

@Controller
public class OperadorController 
{
	@Autowired
	private OperadorService operadorserv;
	
	@RequestMapping(value="/nuevooperador")
	public String nuevoOperador(Model m)
	{
		m.addAttribute("operador", new Operador());
		return "nuevooperador";
	}

		
	@RequestMapping(value="/crearoperador", method=RequestMethod.POST)
	public String crearoperador(@Valid Operador o,BindingResult result, Model m)
	{
		try 
		{
			if(result.hasErrors())
			{
				m.addAttribute("mensaje",result.toString());
				return "nuevooperador"; 
			}
			operadorserv.crear(o);
			m.addAttribute("message", "Este operador fue registrado satisfactoriamente");
			return "nuevooperador";
			
		} 
		catch (Exception e) 
		{
			m.addAttribute("mensaje",e.getMessage());
			return "nuevooperador"; 
			// TODO: handle exception
		}
	}

	@RequestMapping(value="/listoperador")
	public String listOperador(Model m)
	{
		m.addAttribute("operadores", operadorserv.listAll());
		return "Operadores";
	}

	//-----------------Redirige a la vista "verOperador"-------------
	@RequestMapping(value="/verOperador{cop}", method=RequestMethod.GET)
	public String verOperador(@PathVariable int cop, Model model)
	{
		model.addAttribute("operador", operadorserv.getporcoperador(cop));
		return "verOperador";
	}
	
	//-----------------Redirige a la vista "editarOperador"-------------
	@RequestMapping(value="/editarOperador{cop}", method=RequestMethod.GET)
	public String editarOperador(@PathVariable int cop, Model model)
	{
		model.addAttribute("operador", operadorserv.getporcoperador(cop));
		return "editarOperador";
	}
	
	//-------------Elimina "operador"------------------
	@RequestMapping(value="/eliminarOperador{cop}", method=RequestMethod.GET)
	public String deleteOperador(@PathVariable int cop)
	{
		operadorserv.eliminaroperador(cop);
		return "redirect:/listoperador";
	}
	
	@RequestMapping(value="/listoperadorpornombre", method=RequestMethod.POST)
	public String findByNnombresAsc(String nnombres, Model m)
	{
		m.addAttribute("operadores", operadorserv.findByNnombresAsc(nnombres));
		return "Operadores";
	}

	@RequestMapping(value="/listoperadorporapellidos", method=RequestMethod.POST)
	public String findByNapellidosAsc(String napellidos, Model m)
	{
		m.addAttribute("operadores", operadorserv.findByNapellidosAsc(napellidos));
		return "Operadores";
	}

	@RequestMapping(value="/listoperadorpordni", method=RequestMethod.POST)
	public String finByDni(@RequestParam int dni, Model m)
	{
		m.addAttribute("operadores", operadorserv.finByDni(dni));
		return "Operadores";
	}
}
