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
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDirecciones;

@Component("direcciones/direcciones")
public class ListaDireccionesPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		
		Page<TDirecciones> direcciones2 = (Page<TDirecciones>) model.get("direcciones");
		List<TDirecciones> direcciones = direcciones2.getContent();
		PdfPTable tabla = new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		tabla.addCell("Direcciones");
		for(int i = 0; i < direcciones.size();i++) {
		tabla.addCell("DIRECCION: "+direcciones.get(i).getDescDireccion());
		tabla.addCell("CODIGO POSTAL: "+direcciones.get(i).getCodigoPostal());
		tabla.addCell("CLIENTE: "+direcciones.get(i).gettCliente().getNombre());
		tabla.addCell("MUNICIPIO: "+direcciones.get(i).gettMunicipio().getNombreMunicipio());
		tabla.addCell("DEPARTAMENTO: "+direcciones.get(i).gettDepartamento().getNombreDepartamento());
		
		}
		document.add(tabla);
	}

}
