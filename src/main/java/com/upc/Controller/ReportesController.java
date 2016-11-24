package com.upc.Controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upc.Service.AbstractJasperReport;

@Controller
public class ReportesController {
	
	private String dirtemplate;
	private String dirdestino;
	
	@RequestMapping(value="/reportes")
	public String reportes()
	{
		return "reportes";
	}
	
	@RequestMapping(value="/reportesafiliado")
	public String reportesafiliado(Model m) throws SQLException
	{
		try {
			dirtemplate="D:\\plantillasreportes\\afiliado.jasper";
			dirdestino="D:\\plantillasreportes\\aquiprueba\\reporteAfiliado.pdf";
			AbstractJasperReport.createReport(dirtemplate);
			//AbstractJasperReport.showViewer();
			AbstractJasperReport.exportToPDF(dirdestino);
			m.addAttribute("mensaje1","* Reporte pdf de AFILIADOS generado con exito en '"+dirdestino+"'.");
		} catch (Exception e) {
			m.addAttribute("mensaje1","!!!!!! ERROR: El reporte AFILIADOS no pudo ser generado por no existir registro alguno,"
					+ " o porque no se encontro el template del reporte en '"+dirtemplate+"'.");
		}		
		return "reportes";
	}
	
	@RequestMapping(value="/reportescuenta")
	public String reportescuenta(Model m) throws SQLException
	{
		try {
			dirtemplate="D:\\plantillasreportes\\cuenta.jasper";
			dirdestino="D:\\plantillasreportes\\aquiprueba\\reporteCuenta.pdf";
			AbstractJasperReport.createReport(dirtemplate);
			AbstractJasperReport.exportToPDF(dirdestino);
			m.addAttribute("mensaje1","* Reporte pdf de CUENTAS generado con exito en '"+dirdestino+"'.");
		} catch (Exception e) {
			m.addAttribute("mensaje1","!!!!!! ERROR: El reporte CUENTAS no pudo ser generado por no existir registro alguno,"
					+ " o porque no se encontro el template del reporte en '"+dirtemplate+"'.");		
		}
		return "reportes";
	}
	
	@RequestMapping(value="/reportesaporte")
	public String reportesaporte(Model m) throws SQLException
	{
		try {
			dirtemplate="D:\\plantillasreportes\\aporte.jasper";
			dirdestino="D:\\plantillasreportes\\aquiprueba\\reporteAporte.pdf";
			AbstractJasperReport.createReport(dirtemplate);
			AbstractJasperReport.exportToPDF(dirdestino);
			m.addAttribute("mensaje1","* Reporte pdf de APORTES generado con exito en '"+dirdestino+"'.");
		} catch (Exception e) {
			m.addAttribute("mensaje1","!!!!!! ERROR: El reporte APORTES no pudo ser generado por no existir registro alguno,"
					+ " o porque no se encontro el template del reporte en '"+dirtemplate+"'.");
		}
		return "reportes";
	}
	
	@RequestMapping(value="/reportesfondo")
	public String reportesfondo(Model m) throws SQLException
	{
		try {
			dirtemplate="D:\\plantillasreportes\\tipo_de_fondo.jasper";
			dirdestino="D:\\plantillasreportes\\aquiprueba\\reporteTipoFondo.pdf";
			AbstractJasperReport.createReport(dirtemplate);
			AbstractJasperReport.exportToPDF(dirdestino);
			m.addAttribute("mensaje1","* Reporte pdf de FONDOS generado con exito en '"+dirdestino+"'.");
		} catch (Exception e) {
			m.addAttribute("mensaje1","!!!!!! ERROR: El reporte FONDOS no pudo ser generado por no existir registro alguno,"
					+ " o porque no se encontro el template del reporte en '"+dirtemplate+"'.");
		}
		return "reportes";
	}
	
	@RequestMapping(value="/reportesoperador")
	public String reportesoperador(Model m) throws SQLException
	{
		try {
			dirtemplate="D:\\plantillasreportes\\operador.jasper";
			dirdestino="D:\\plantillasreportes\\aquiprueba\\reporteOperador.pdf";
			AbstractJasperReport.createReport(dirtemplate);
			AbstractJasperReport.exportToPDF(dirdestino);
			m.addAttribute("mensaje1","* Reporte pdf de OPERADORES generado con exito en '"+dirdestino+"'.");
		} catch (Exception e) {
			m.addAttribute("mensaje1","!!!!!! ERROR: El reporte OPERADORES no pudo ser generado por no existir registro alguno,"
					+ " o porque no se encontro el template del reporte en '"+dirtemplate+"'.");
		}
		return "reportes";
	}
	
	@RequestMapping(value="/reportessolicitud")
	public String reportessolicitud(Model m) throws SQLException
	{
		try {
			dirtemplate="D:\\plantillasreportes\\solicitud_retiro.jasper";
			dirdestino="D:\\plantillasreportes\\aquiprueba\\reporteSolicitud.pdf";
			AbstractJasperReport.createReport(dirtemplate);
			AbstractJasperReport.exportToPDF(dirdestino);
			m.addAttribute("mensaje1","* Reporte pdf de SOLICITUDES generado con exito en '"+dirdestino+"'.");
		} catch (Exception e) {
			m.addAttribute("mensaje1","!!!!!! ERROR: El reporte SOLICITUDES no pudo ser generado por no existir registro alguno,"
					+ " o porque no se encontro el template del reporte en '"+dirtemplate+"'.");
		}
		return "reportes";
	}
	
	@RequestMapping(value="/reportesretiro")
	public String reportesretiro(Model m) throws SQLException
	{
		try {
			dirtemplate="D:\\plantillasreportes\\retiro.jasper";
			dirdestino="D:\\plantillasreportes\\aquiprueba\\reporteRetiro.pdf";
			AbstractJasperReport.createReport(dirtemplate);
			AbstractJasperReport.exportToPDF(dirdestino);
			m.addAttribute("mensaje1","* Reporte pdf de RETIROS generado con exito en '"+dirdestino+"'.");
		} catch (Exception e) {
			m.addAttribute("mensaje1","!!!!!! ERROR: El reporte RETIROS no pudo ser generado por no existir registro alguno,"
					+ " o porque no se encontro el template del reporte en '"+dirtemplate+"'.");
		}
		return "reportes";
	}
	
	@RequestMapping(value="/reportesmora")
	public String reportesmora(Model m) throws SQLException
	{
		try {
			dirtemplate="D:\\plantillasreportes\\interesxmora.jasper";
			dirdestino="D:\\plantillasreportes\\aquiprueba\\reporteMora.pdf";
			AbstractJasperReport.createReport(dirtemplate);
			AbstractJasperReport.exportToPDF(dirdestino);
			m.addAttribute("mensaje1","* Reporte pdf de MORAS generado con exito en '"+dirdestino+"'.");
		} catch (Exception e) {
			m.addAttribute("mensaje1","!!!!!! ERROR: El reporte MORAS no pudo ser generado por no existir registro alguno,"
					+ " o porque no se encontro el template del reporte en '"+dirtemplate+"'.");
		}
		return "reportes";
	}
	
	@RequestMapping(value="/reportesperiodo")
	public String reportesperiodo(Model m) throws SQLException
	{
		try {
			dirtemplate="D:\\plantillasreportes\\periododeaporte.jasper";
			dirdestino="D:\\plantillasreportes\\aquiprueba\\reportePeriodo.pdf";
			AbstractJasperReport.createReport(dirtemplate);
			AbstractJasperReport.exportToPDF(dirdestino);
			m.addAttribute("mensaje1","* Reporte pdf de PERIODOS generado con exito en '"+dirdestino+"'.");
		} catch (Exception e) {
			m.addAttribute("mensaje1","!!!!!! ERROR: El reporte PERIODOS no pudo ser generado por no existir registro alguno,"
					+ " o porque no se encontro el template del reporte en '"+dirtemplate+"'.");
		}
		return "reportes";
	}
	
	@RequestMapping(value="/reportesempresa")
	public String reportesempresa(Model m) throws SQLException
	{
		try {
			dirtemplate="D:\\plantillasreportes\\rep_empresa.jasper";
			dirdestino="D:\\plantillasreportes\\aquiprueba\\reporteEmpresa.pdf";
			AbstractJasperReport.createReport(dirtemplate);
			AbstractJasperReport.exportToPDF(dirdestino);
			m.addAttribute("mensaje1","* Reporte pdf de EMPRESAS generado con exito en '"+dirdestino+"'.");
		} catch (Exception e) {
			m.addAttribute("mensaje1","!!!!!! ERROR: El reporte EMPRESAS no pudo ser generado por no existir registro alguno,"
					+ " o porque no se encontro el template del reporte en '"+dirtemplate+"'.");
		}
		return "reportes";
	}
	
}
