package com.umg.desarrolloweb.proyectoCompraloFacil.app.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;



import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;

@Component("ddetalle-cliente-form")
public class ClientePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TCliente cliente = (TCliente) model.get("cliente");
		PdfPTable tabla =new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		tabla.addCell("---- CLIENTES ----");
		tabla.addCell("NOMBRES: "+cliente.getNombre());
		tabla.addCell("APELLIDOS: "+cliente.getApellido());
		tabla.addCell("DPI: "+cliente.getDpi());
		tabla.addCell("FECHA NACIMIENTO: "+cliente.getFechaNacimiento());
		tabla.addCell("TELEFONO: "+cliente.getTelefono());
		tabla.addCell("NIT: "+cliente.getNit());
		tabla.addCell("CORREO: "+cliente.getCorreo());
		
		document.add(tabla);
		
	}

}
