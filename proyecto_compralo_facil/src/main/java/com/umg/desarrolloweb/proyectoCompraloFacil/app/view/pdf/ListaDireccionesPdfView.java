package com.umg.desarrolloweb.proyectoCompraloFacil.app.view.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
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
		List<TDirecciones> listaDirecciones = direcciones2.getContent();
		
		
		/*Fuentes, tamaños y colores para cada seccion*/
		Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.COURIER ,10,Color.BLACK);
		Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20, -20, 30, 20);
		document.open();
		PdfPCell celda = null;
		
		/*Tabla para el Titulo de PDF*/
		PdfPTable tablaTitulo = new PdfPTable(1);
		
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE DIRECCIONES", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(236,177,65));
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setPadding(30);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		/*Tabla para mostra listado de pedidos*/
		PdfPTable tablaDirecciones = new PdfPTable(8);
		tablaDirecciones.setWidths(new float[] {0.7f, 1.5f, 1.3f, 1.2f, 2f, 2.1f,2f, 2f});
		
		celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaDirecciones.addCell(celda);
		
		celda = new PdfPCell(new Phrase("DIRECCION", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaDirecciones.addCell(celda);
		
		celda = new PdfPCell(new Phrase("CODIGO POSTAL", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaDirecciones.addCell(celda);
		
		celda = new PdfPCell(new Phrase("ID CLIENTE", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaDirecciones.addCell(celda);
		
		celda = new PdfPCell(new Phrase("NOMBRE CLIENTE", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaDirecciones.addCell(celda);
		
		celda = new PdfPCell(new Phrase("APELLIDO CLIENTE", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaDirecciones.addCell(celda);
		
		celda = new PdfPCell(new Phrase("MUNICIPIO", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaDirecciones.addCell(celda);
		
		celda = new PdfPCell(new Phrase("DEPARTAMENTO", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaDirecciones.addCell(celda);
		
		/* Bucle For para mostrar todos los datos de los clientes*/
		for(TDirecciones direcciones : listaDirecciones) {
			celda = new PdfPCell(new Phrase(direcciones.getId().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaDirecciones.addCell(celda);
			
			celda = new PdfPCell(new Phrase(direcciones.getDescDireccion(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaDirecciones.addCell(celda);
			
			celda = new PdfPCell(new Phrase(direcciones.getCodigoPostal(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaDirecciones.addCell(celda);
			
			celda = new PdfPCell(new Phrase(direcciones.gettCliente().getId().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaDirecciones.addCell(celda);
			
			celda = new PdfPCell(new Phrase(direcciones.gettCliente().getNombre(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaDirecciones.addCell(celda);
			
			celda = new PdfPCell(new Phrase(direcciones.gettCliente().getApellido(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaDirecciones.addCell(celda);
			
			celda = new PdfPCell(new Phrase(direcciones.gettMunicipio().getNombreMunicipio(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaDirecciones.addCell(celda);
			
			celda = new PdfPCell(new Phrase(direcciones.gettDepartamento().getNombreDepartamento(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaDirecciones.addCell(celda);
			
		
		}
		
		document.add(tablaTitulo);
		document.add(tablaDirecciones);
	}

}
