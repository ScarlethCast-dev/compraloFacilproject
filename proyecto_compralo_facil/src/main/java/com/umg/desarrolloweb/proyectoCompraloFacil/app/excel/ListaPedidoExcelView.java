package com.umg.desarrolloweb.proyectoCompraloFacil.app.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TPedido;

@Component("pedidos/pedido.xlsx")
public class ListaPedidoExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.setHeader("Content-Disposition", "attachment; filename=\"listado-pedidos.xlsx\"");
		Sheet hoja = workbook.createSheet("pedido");
		
		Row filaTitulo = hoja.createRow(0);
		Cell celda =filaTitulo.createCell(0);
		celda.setCellValue("LISTADO GENERAL DE PEDIDOS");
		
		Row filaData = hoja.createRow(2);
		String[] columnas = {"ID","FECHA PEDIDO","ESTADO PEDIDO","NOMBRE CLIENTE","ID CLIENTE",
				"APELLIDO CLIENTE","METODO ENVIO",};
		
		for (int i = 0; i < columnas.length; i++) {
			celda = filaData.createCell(i);
			celda.setCellValue(columnas[i]);
		}
		
		@SuppressWarnings("unchecked")
		Page<TPedido> listaP2 = (Page<TPedido>)model.get("pedido");
		List<TPedido> listaP = listaP2.getContent();
		
		int numFila = 3;
		for(TPedido pedido : listaP) {
			filaData = hoja.createRow(numFila);
			
			filaData.createCell(0).setCellValue(pedido.getId());
			filaData.createCell(1).setCellValue(pedido.getFechaPedido());
			filaData.createCell(2).setCellValue(pedido.gettEstadoPedido().getDescripcion());
			filaData.createCell(3).setCellValue(pedido.gettCliente().getId());
			filaData.createCell(4).setCellValue(pedido.gettCliente().getNombre());
			filaData.createCell(5).setCellValue(pedido.gettCliente().getApellido());
			filaData.createCell(6).setCellValue(pedido.gettMetodoEnvio().getDescripcion());
			 
			numFila ++;
			
		}
		
	}

}
