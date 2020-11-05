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

import com.umg.desarrolloweb.proyectoCompraloFacil.app.entities.TDirecciones;


@Component("direcciones/direcciones.xlsx")
public class ListaDireccionesExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.setHeader("Content-Disposition", "attachment; filename=\"listado-direcciones.xlsx\"");
		Sheet hoja = workbook.createSheet("direcciones");
		
		Row filaTitulo = hoja.createRow(0);
		Cell celda =filaTitulo.createCell(0);
		celda.setCellValue("LISTADO GENERAL DE DIRECCIONES");
		
		Row filaData = hoja.createRow(2);
		String[] columnas = {"ID","DIRECCIONES","CODIGO POSTAL","ID CLIENTE","NOMBRE CLIENTE",
				"APELLIDO CLIENTE","MUNICIPIO","DEPARTAMENTO"};
		
		for (int i = 0; i < columnas.length; i++) {
			celda = filaData.createCell(i);
			celda.setCellValue(columnas[i]);
		}
		
		@SuppressWarnings("unchecked")
		Page<TDirecciones> listaD2 = (Page<TDirecciones>)model.get("direcciones");
		List<TDirecciones> listaD = listaD2.getContent();
		
		int numFila = 3;
		for(TDirecciones direccion : listaD) {
			filaData = hoja.createRow(numFila);
			
			filaData.createCell(0).setCellValue(direccion.getId());
			filaData.createCell(1).setCellValue(direccion.getDescDireccion());
			filaData.createCell(2).setCellValue(direccion.getCodigoPostal());
			filaData.createCell(3).setCellValue(direccion.gettCliente().getId());
			filaData.createCell(4).setCellValue(direccion.gettCliente().getNombre());
			filaData.createCell(5).setCellValue(direccion.gettCliente().getApellido());
			filaData.createCell(6).setCellValue(direccion.gettMunicipio().getNombreMunicipio());
			filaData.createCell(6).setCellValue(direccion.gettDepartamento().getNombreDepartamento());
			 
			numFila ++;
			
		}
		
	}

}
