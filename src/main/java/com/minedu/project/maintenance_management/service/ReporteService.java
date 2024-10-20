package com.minedu.project.maintenance_management.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

@Service
public class ReporteService {
	
	@Autowired
    private ResourceLoader resourceLoader; 
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public byte[] exportarSolicitud(String reportFormat) throws JRException, IOException, SQLException {
	    JasperReport jasperReport = JasperCompileManager.compileReport(
	        resourceLoader.getResource("classpath:reports/reporte_solicitudes.jrxml").getInputStream()
	    );
	    
	    Connection connection = jdbcTemplate.getDataSource().getConnection();

	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);

	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	    switch (reportFormat.toLowerCase()) {
	    	case "doc":
	            JRDocxExporter docxExporter = new JRDocxExporter();
	            docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
	            docxExporter.exportReport();
	            break;
	    	case "pdf":
	            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	            break;
	        case "excel":
	            JRXlsxExporter excelExporter = new JRXlsxExporter();
	            excelExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            excelExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
	            excelExporter.exportReport();
	            break;
	        case "html":
	            HtmlExporter htmlExporter = new HtmlExporter();
	            htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(outputStream));
	            htmlExporter.exportReport();
	            break;
	        case "csv":
	            JRCsvExporter csvExporter = new JRCsvExporter();
	            csvExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            csvExporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
	            csvExporter.exportReport();
	            break;
	        default:
	            throw new IllegalArgumentException("Formato no soportado: " + reportFormat);
	    }

	    connection.close();

	    return outputStream.toByteArray();
	}
	
	public byte[] exportarRequerimiento(String reportFormat) throws JRException, IOException, SQLException {
	    JasperReport jasperReport = JasperCompileManager.compileReport(
	        resourceLoader.getResource("classpath:reports/reporte_requerimientos.jrxml").getInputStream()
	    );
	    
	    Connection connection = jdbcTemplate.getDataSource().getConnection();

	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);

	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	    switch (reportFormat.toLowerCase()) {
	    	case "doc":
	            JRDocxExporter docxExporter = new JRDocxExporter();
	            docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
	            docxExporter.exportReport();
	            break;
	    	case "pdf":
	            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	            break;
	        case "excel":
	            JRXlsxExporter excelExporter = new JRXlsxExporter();
	            excelExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            excelExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
	            excelExporter.exportReport();
	            break;
	        case "html":
	            HtmlExporter htmlExporter = new HtmlExporter();
	            htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(outputStream));
	            htmlExporter.exportReport();
	            break;
	        case "csv":
	            JRCsvExporter csvExporter = new JRCsvExporter();
	            csvExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            csvExporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
	            csvExporter.exportReport();
	            break;
	        default:
	            throw new IllegalArgumentException("Formato no soportado: " + reportFormat);
	    }

	    connection.close();

	    return outputStream.toByteArray();
	}
	
	public byte[] exportarSuministrador(String reportFormat) throws JRException, IOException, SQLException {
	    JasperReport jasperReport = JasperCompileManager.compileReport(
	        resourceLoader.getResource("classpath:reports/reporte_suministradores.jrxml").getInputStream()
	    );
	    
	    Connection connection = jdbcTemplate.getDataSource().getConnection();

	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);

	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	    switch (reportFormat.toLowerCase()) {
	    	case "doc":
	            JRDocxExporter docxExporter = new JRDocxExporter();
	            docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
	            docxExporter.exportReport();
	            break;
	    	case "pdf":
	            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	            break;
	        case "excel":
	            JRXlsxExporter excelExporter = new JRXlsxExporter();
	            excelExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            excelExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
	            excelExporter.exportReport();
	            break;
	        case "html":
	            HtmlExporter htmlExporter = new HtmlExporter();
	            htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(outputStream));
	            htmlExporter.exportReport();
	            break;
	        case "csv":
	            JRCsvExporter csvExporter = new JRCsvExporter();
	            csvExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            csvExporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
	            csvExporter.exportReport();
	            break;
	        default:
	            throw new IllegalArgumentException("Formato no soportado: " + reportFormat);
	    }

	    connection.close();

	    return outputStream.toByteArray();
	}
	
}
