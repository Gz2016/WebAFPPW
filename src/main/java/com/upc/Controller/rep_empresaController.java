package com.upc.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.Entities.rep_empresa;
import com.upc.Service.rep_empresaService;

@Controller
public class rep_empresaController 
{
	@Autowired
	private rep_empresaService EmpSer;
	
	//-------------Cargar vista "nuevoRepEmpresa"------------------
	@RequestMapping(value="/rep_empresa")
	public String rep_empresas(Model model)
	{
		model.addAttribute("rep_empresa", new rep_empresa());
		return "nuevoRepEmpresa";
	}
	
	//-------------Guarda y actualiza "rep_empresa"------------------
	@RequestMapping(value="/rep_empresanew", method=RequestMethod.POST)
	public String saveRep_Empresa(@Valid rep_empresa r, BindingResult result, Model model)
	{
		try 
		{
			if(result.hasErrors())
			{
				model.addAttribute("message", result.toString());
				return "nuevoRepEmpresa";
			}
			
			EmpSer.save(r);
			model.addAttribute("message", "Este representante ha sido registrado con éxito.");
			return "nuevoRepEmpresa";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "nuevoRepEmpresa";
		}
	}
	//---------------Listar rep_empresas-------------------
	@RequestMapping(value="/listRepEmpresas")
	public String listRepEmpresas(Model model)
	{
		model.addAttribute("rep_empresas", EmpSer.listAllRepEmpresas());
		return "RepEmpresas";
	}
	
	//-----------------Redirige a la vista "verRepEmpresa"-------------
		@RequestMapping(value="/verRepEmpresa{crep}", method=RequestMethod.GET)
		public String verRepEmpresa(@PathVariable int crep, Model model)
		{
			model.addAttribute("rep_empresa", EmpSer.getRepById(crep));
			return "verRepEmpresa";
		}
	
	//-----------------Redirige a la vista "editarRepEmpresa"-------------
	@RequestMapping(value="/editarRepEmpresa{crep}", method=RequestMethod.GET)
	public String editRepEmpresa(@PathVariable int crep, Model model)
	{
		model.addAttribute("rep_empresa", EmpSer.getRepById(crep));
		return "editarRepEmpresa";
	}
	
	//-------------Elimina "rep_empresa"------------------
	@RequestMapping(value="/eliminarRepEmpresa{crep}", method=RequestMethod.GET)
	public String deleteRepEmpresa(@PathVariable int crep)
	{
		EmpSer.deleteRepEmpresa(crep);
		return "redirect:/listRepEmpresas";
	}
}
