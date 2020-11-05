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

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TCliente;

@Component("clientes/clientes.xlsx")
public class ListaClientesExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.setHeader("Content-Disposition", "attachment; filename=\"listado-clientes.xlsx\"");
		Sheet hoja = workbook.createSheet("clientes");
		
		
		
		Row filaTitulo = hoja.createRow(0);
		Cell celda =filaTitulo.createCell(0);
		celda.setCellValue("LISTADO GENERAL DE CLIENTES");
		
		Row filaData = hoja.createRow(2);
		String[] columnas = {"ID","NOMBRES","APELLIDOS","DPI",
				"FECHA NACIMIENTO","TELEFONO","NIT","CORREO ELECTRONICO"};
		
		for (int i = 0; i < columnas.length; i++) {
			celda = filaData.createCell(i);
			celda.setCellValue(columnas[i]);
		}
		
		
		@SuppressWarnings("unchecked")
		Page<TCliente> listaC2 = (Page<TCliente>)model.get("clientes");
		List<TCliente> listaC = listaC2.getContent();
		
		int numFila = 3;
		for(TCliente cliente : listaC) {
			filaData = hoja.createRow(numFila);
			
			filaData.createCell(0).setCellValue(cliente.getId());
			filaData.createCell(1).setCellValue(cliente.getNombre());
			filaData.createCell(2).setCellValue(cliente.getApellido());
			filaData.createCell(3).setCellValue(cliente.getDpi());
			filaData.createCell(4).setCellValue(cliente.getFechaNacimiento());
			filaData.createCell(5).setCellValue(cliente.getTelefono());
			filaData.createCell(6).setCellValue(cliente.getNit());
			filaData.createCell(7).setCellValue(cliente.getCorreo());
			 
			numFila ++;
			
		}

	}

}
