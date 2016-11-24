package com.upc.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

@Service
public abstract class AbstractJasperReport {

	private static JasperReport report;
	private static JasperPrint reportFilled;
	private static JasperViewer viewer;
	private static final String url = "jdbc:mysql://localhost:3306/dbtrabajofinal";
    private static final String user = "root";
    private static final String passwd = "admin";
    private static Connection con;
	//AbstractJasperReports.createReport(cn,"C:\\Users\\CCM\\Desktop\\templates\\report.jasper");
	
	public static void createReport(String path){
		try{
			if (con == null) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	                con = DriverManager.getConnection(url, user, passwd);
	            } catch (SQLException | ClassNotFoundException e) {
	            }
	        }
			Connection cn = con;
			report = (JasperReport) JRLoader.loadObjectFromFile(path);
			reportFilled=JasperFillManager.fillReport(report, null, cn);
		}
		catch(JRException ex){
			ex.printStackTrace();
		}
	}
	
	public static void showViewer(){
		viewer = new JasperViewer(reportFilled,false);//false para que no se cierre
		viewer.setVisible(true);
	}
	
	public static void exportToPDF(String destination){
		try{
			JasperExportManager.exportReportToPdfFile(reportFilled,destination);
			//AbstractJasperReport.showViewer();
			//AbstractJasperReport.exportToPDF("C:\\Users\\CCM\\Desktop\\nuevope\\report.pdf");
		}
		catch(JRException ex){
			ex.printStackTrace();
		}
	}
	
}
