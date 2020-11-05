package com.umg.desarrolloweb.proyectoCompraloFacil.app.excel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TPedido;

@Component("pedidos/detalle-pedido-form.xlsx")
public class PedidoExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			response.setHeader("Content-Disposition", "attachment; filename=\"reporte-pedido.xlsx\"");
			TPedido pedido = (TPedido) model.get("pedido");
			Sheet sheet = workbook.createSheet("Pedido");
			
			
			CellStyle header = workbook.createCellStyle();
			header.setBorderBottom(BorderStyle.MEDIUM);
			header.setBorderTop(BorderStyle.MEDIUM);
			header.setBorderRight(BorderStyle.MEDIUM);
			header.setBorderLeft(BorderStyle.MEDIUM);
			header.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
			header.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("DATOS EMPLEADO");
			cell.setCellStyle(header);
			
			row = sheet.createRow(1);
			cell = row.createCell(0);
			cell.setCellValue("ID PEDIDO: ");
			cell = row.createCell(1);
			cell.setCellValue(pedido.getId());
			
			
			row = sheet.createRow(2);
			cell = row.createCell(0);
			cell.setCellValue("FECHA PEDIDO: ");
			cell = row.createCell(1);
			cell.setCellValue(pedido.getFechaPedido());
			
			row = sheet.createRow(3);
			cell = row.createCell(0);
			cell.setCellValue("ESTADO PEDIDO: ");
			cell = row.createCell(1);
			cell.setCellValue(pedido.gettEstadoPedido().getDescripcion());
			
			row = sheet.createRow(4);
			cell = row.createCell(0);
			cell.setCellValue("ID CLIENTE: ");
			cell = row.createCell(1);
			cell.setCellValue(pedido.gettCliente().getId());
			
			row = sheet.createRow(5);
			cell = row.createCell(0);
			cell.setCellValue("NOMNBRE CLIENTE: ");
			cell = row.createCell(1);
			cell.setCellValue(pedido.gettCliente().getNombre());
			
			row = sheet.createRow(6);
			cell = row.createCell(0);
			cell.setCellValue("APELLIDO CLIENTE: ");
			cell = row.createCell(1);
			cell.setCellValue(pedido.gettCliente().getApellido());
			
			row = sheet.createRow(7);
			cell = row.createCell(0);
			cell.setCellValue("METODO ENVIO: ");
			cell = row.createCell(1);
			cell.setCellValue(pedido.gettMetodoEnvio().getDescripcion());
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
