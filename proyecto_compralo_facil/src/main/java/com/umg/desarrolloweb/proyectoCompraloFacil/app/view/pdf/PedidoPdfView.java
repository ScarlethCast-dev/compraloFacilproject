package com.umg.desarrolloweb.proyectoCompraloFacil.app.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TPedido;

@Component("pedidos/detalle-pedido-form")
public class PedidoPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TPedido pedido = (TPedido) model.get("pedido");
		PdfPTable tabla =new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		tabla.addCell("                                     ---- PEDIDO ----                                     ");
		tabla.addCell("FEECHA ENVIO: "+pedido.getFechaPedido());
		tabla.addCell("DESCRIPCION: "+pedido.gettEstadoPedido().getDescripcion());
		tabla.addCell("NOMBRE CLINETE: "+pedido.gettCliente().getNombre());
		tabla.addCell("APELLIDO CLIENTE: "+pedido.gettCliente().getApellido());
		tabla.addCell("METODO ENVIO: "+pedido.gettMetodoEnvio().getDescripcion());
		
		document.add(tabla);
		
		
	}

}
