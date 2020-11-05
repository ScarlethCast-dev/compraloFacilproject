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

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;

@Component("clientes/detalle-cliente-form.xlsx")
public class ClienteExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		try {
		response.setHeader("Content-Disposition", "attachment; filename=\"reporte-cliente.xlsx\"");
		TCliente cliente = (TCliente) model.get("cliente");
		Sheet sheet = workbook.createSheet("Cliente");
		
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
		cell.setCellValue("ID CLIENTE: ");
		cell = row.createCell(1);
		cell.setCellValue(cliente.getId());
		
		
		row = sheet.createRow(2);
		cell = row.createCell(0);
		cell.setCellValue("NOMBRE: ");
		cell = row.createCell(1);
		cell.setCellValue(cliente.getNombre());
		
		row = sheet.createRow(3);
		cell = row.createCell(0);
		cell.setCellValue("APELLIDO: ");
		cell = row.createCell(1);
		cell.setCellValue(cliente.getApellido());
		
		row = sheet.createRow(4);
		cell = row.createCell(0);
		cell.setCellValue("DPI: ");
		cell = row.createCell(1);
		cell.setCellValue(cliente.getDpi());
		
		row = sheet.createRow(5);
		cell = row.createCell(0);
		cell.setCellValue("FECHA NACIMIENTO: ");
		cell = row.createCell(1);
		cell.setCellValue(cliente.getFechaNacimiento());
		
		row = sheet.createRow(6);
		cell = row.createCell(0);
		cell.setCellValue("TELEFONO: ");
		cell = row.createCell(1);
		cell.setCellValue(cliente.getTelefono());
		
		row = sheet.createRow(7);
		cell = row.createCell(0);
		cell.setCellValue("NIT: ");
		cell = row.createCell(1);
		cell.setCellValue(cliente.getNit());
		
		row = sheet.createRow(8);
		cell = row.createCell(0);
		cell.setCellValue("CORREO: ");
		cell = row.createCell(1);
		cell.setCellValue(cliente.getCorreo());
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
