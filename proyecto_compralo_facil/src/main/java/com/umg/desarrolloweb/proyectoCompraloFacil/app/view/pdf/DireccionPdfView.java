package com.umg.desarrolloweb.proyectoCompraloFacil.app.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDirecciones;

@Component("direcciones/detalle-direccion-form")
public class DireccionPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TDirecciones direccion = (TDirecciones) model.get("direcciones");
		PdfPTable tabla =new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		tabla.addCell("DIRECCION: "+direccion.getDescDireccion());
		tabla.addCell("CODIGO POSTAL: "+direccion.getCodigoPostal());
		tabla.addCell("CLIENTE: "+direccion.gettCliente().getNombre());
		tabla.addCell("MUNICIPIO: "+direccion.gettMunicipio().getNombreMunicipio());
		tabla.addCell("DEPARTAMENTO: "+direccion.gettDepartamento().getNombreDepartamento());
		
		
		
		document.add(tabla);
		
	
	}

}
