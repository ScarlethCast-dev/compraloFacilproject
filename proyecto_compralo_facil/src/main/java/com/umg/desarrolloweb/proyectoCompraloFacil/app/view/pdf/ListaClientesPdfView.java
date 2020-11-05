package com.umg.desarrolloweb.proyectoCompraloFacil.app.view.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;



@Component("clientes/clientes")
public class ListaClientesPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		Page<TCliente> listaCliente2 = (Page<TCliente>) model.get("clientes");
		List<TCliente> listaCliente = listaCliente2.getContent();
		
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
		
		
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE CLIENTES", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(236,177,65));
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setPadding(30);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		/*Tabla para mostra listado de pedidos*/
		PdfPTable tablaClientes = new PdfPTable(8);
		tablaClientes.setWidths(new float[] {0.8f, 2f, 2f, 2f, 1.5f, 1.5f, 1.5f, 3.5f});
		
		celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("NOMBRES", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("APELLIDOS", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("DPI", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("FECHA NACIMIENTO", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("TELEFONO", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("NIT", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("CORREO", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		/* Bucle For para mostrar todos los datos de los clientes*/
		
		for(TCliente cliente : listaCliente) {
			celda = new PdfPCell(new Phrase(cliente.getId().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getNombre(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getApellido(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getDpi().toString(),fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getFechaNacimiento().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getTelefono(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);

			celda = new PdfPCell(new Phrase(cliente.getNit(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getCorreo(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			
		
		}
		
		
	
		document.add(tablaTitulo);
		document.add(tablaClientes);
		
	}

}
