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

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDirecciones;

@Component("direcciones/detalle-direccion-form.xlsx")
public class DireccionesExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			response.setHeader("Content-Disposition", "attachment; filename=\"reporte-direccion.xlsx\"");
			TDirecciones direccion = (TDirecciones) model.get("direcciones");
			Sheet sheet = workbook.createSheet("Direccion");
			
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
			cell.setCellValue("ID: ");
			cell = row.createCell(1);
			cell.setCellValue(direccion.getId());
			
			
			row = sheet.createRow(2);
			cell = row.createCell(0);
			cell.setCellValue("DIRECCION: ");
			cell = row.createCell(1);
			cell.setCellValue(direccion.getDescDireccion());
			
			row = sheet.createRow(3);
			cell = row.createCell(0);
			cell.setCellValue("CODIGO POSTAL: ");
			cell = row.createCell(1);
			cell.setCellValue(direccion.getCodigoPostal());
			
			row = sheet.createRow(4);
			cell = row.createCell(0);
			cell.setCellValue("ID CLIENTE: ");
			cell = row.createCell(1);
			cell.setCellValue(direccion.gettCliente().getId());
			
			row = sheet.createRow(5);
			cell = row.createCell(0);
			cell.setCellValue("NOMBRE CLIENTE: ");
			cell = row.createCell(1);
			cell.setCellValue(direccion.gettCliente().getNombre());
			
			row = sheet.createRow(6);
			cell = row.createCell(0);
			cell.setCellValue("APELLIDO CLIENTE: ");
			cell = row.createCell(1);
			cell.setCellValue(direccion.gettCliente().getApellido());
			
			row = sheet.createRow(7);
			cell = row.createCell(0);
			cell.setCellValue("MUNICIPIO: ");
			cell = row.createCell(1);
			cell.setCellValue(direccion.gettMunicipio().getNombreMunicipio());
			
			row = sheet.createRow(8);
			cell = row.createCell(0);
			cell.setCellValue("DEPARTAMENTO: ");
			cell = row.createCell(1);
			cell.setCellValue(direccion.gettDepartamento().getNombreDepartamento());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
