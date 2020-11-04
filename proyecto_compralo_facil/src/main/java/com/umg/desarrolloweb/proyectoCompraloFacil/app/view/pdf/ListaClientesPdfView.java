package com.umg.desarrolloweb.proyectoCompraloFacil.app.view.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;


import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;


@Component("empleados")
public class ListaClientesPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,  com.lowagie.text.Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		Page<TCliente> list2 = (Page<TCliente>) model.get("clientes");
		List<TCliente> list = list2.getContent();
		PdfPTable tabla = new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		tabla.addCell(" ----- CLIENTES ----- ");
		
		for(int i = 0; i <list.size();i++) {
			tabla.addCell("---- CLIENTES ----");
			tabla.addCell("NOMBRES: "+list.get(i).getNombre());
			tabla.addCell("APELLIDOS: "+list.get(i).getApellido());
			tabla.addCell("DPI: "+list.get(i).getDpi());
			tabla.addCell("FECHA NACIMIENTO: "+list.get(i).getFechaNacimiento());
			tabla.addCell("TELEFONO: "+list.get(i).getTelefono());
			tabla.addCell("NIT: "+list.get(i).getNit());
			tabla.addCell("CORREO: "+list.get(i).getCorreo());
			
			
		}
	
		document.add(tabla);
		
	}

}
