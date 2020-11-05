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
import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TPedido;

@Component("pedidos/pedido")
public class ListaPedidosPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		
		
		Page<TPedido> listaPedidos2 = (Page<TPedido>) model.get("pedido");
		List<TPedido> listaPedidos = listaPedidos2.getContent();
		
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
		
		
		
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE PEDIDOS", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(236,177,65));
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setPadding(30);
		
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);

		/*Tabla para mostra listado de pedidos*/
		PdfPTable tablaPedidos = new PdfPTable(6);
		tablaPedidos.setWidths(new float[] {0.8f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f});
		
		celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaPedidos.addCell(celda);
		
		celda = new PdfPCell(new Phrase("FECHA PEDIDO", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaPedidos.addCell(celda);
		
		celda = new PdfPCell(new Phrase("ESTADO PEDIDO", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaPedidos.addCell(celda);
		
		celda = new PdfPCell(new Phrase("NOMBRE CLIENTE", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaPedidos.addCell(celda);
		
		celda = new PdfPCell(new Phrase("APELLIDO CLIENTE", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaPedidos.addCell(celda);
		
		celda = new PdfPCell(new Phrase("METODO ENVIO", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaPedidos.addCell(celda);
		
		
		/* Bucle For para mostrar todos los datos de los clientes*/
		for(TPedido pedido : listaPedidos) {
			celda = new PdfPCell(new Phrase(pedido.getId().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaPedidos.addCell(celda);
			
			celda = new PdfPCell(new Phrase(pedido.getFechaPedido().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaPedidos.addCell(celda);
			
			
			celda = new PdfPCell(new Phrase(pedido.gettEstadoPedido().getDescripcion(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaPedidos.addCell(celda);
			
			
			celda = new PdfPCell(new Phrase(pedido.gettCliente().getNombre(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaPedidos.addCell(celda);
			
			
			celda = new PdfPCell(new Phrase(pedido.gettCliente().getApellido(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaPedidos.addCell(celda);
			
			
			celda = new PdfPCell(new Phrase(pedido.gettMetodoEnvio().getDescripcion(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaPedidos.addCell(celda);

		
		}
		/*
		listaPedidos.forEach(pedido ->{
			tablaPedidos.addCell(pedido.getId().toString());
			tablaPedidos.addCell(pedido.getFechaPedido().toString());
			tablaPedidos.addCell(pedido.gettEstadoPedido().getDescripcion());
			tablaPedidos.addCell(pedido.gettCliente().getNombre());
			tablaPedidos.addCell(pedido.gettCliente().getApellido());
			tablaPedidos.addCell(pedido.gettMetodoEnvio().getDescripcion());
			
			
		});
		*/
		
		document.add(tablaTitulo);
		document.add(tablaPedidos);
	}

}
