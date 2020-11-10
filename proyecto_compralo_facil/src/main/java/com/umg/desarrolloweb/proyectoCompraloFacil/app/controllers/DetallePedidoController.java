package com.umg.desarrolloweb.proyectoCompraloFacil.app.controllers;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.umg.desarrolloweb.proyectoCompraloFacil.app.dto.AmazonProductLinkDTO;
import com.umg.desarrolloweb.proyectoCompraloFacil.app.repositories.DetallePedidoRepository;


@Controller
@SessionAttributes("productoAmazon")
public class DetallePedidoController {
	
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;

	@RequestMapping(value = "/producto-amazon", method = RequestMethod.POST) 
	 public String productoAmazon( @ModelAttribute(value= "producto") AmazonProductLinkDTO producto,Model model) { 
	  AmazonProductLinkDTO productoAmazon = consultarApi(producto.getLink()); 
	  costoQuetzales(productoAmazon);
	  productoAmazon.setLink(producto.getLink());
	  model.addAttribute("productoAmazon", productoAmazon); 
	  return "producto-amazon"; 
	 }  
	  
	  
	 private HttpHeaders createHttpHeaders(String key, String value) { 
	     HttpHeaders headers = new HttpHeaders(); 
	     headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON })); 
	     headers.setContentType(MediaType.APPLICATION_JSON); 
	     headers.set(key, value); 
	     return headers; 
	   } 
	 
	   private AmazonProductLinkDTO consultarApi(String urlProduct) { 
	 
	     RestTemplate restTemplate = new RestTemplate(); 
	     String host = "http://api-prd.axesso.de/amz/amazon-lookup-product?url="; 
	     AmazonProductLinkDTO producto = new AmazonProductLinkDTO(); 
	     try { 
	 
	       HttpHeaders headers = createHttpHeaders("axesso-api-key", "19d3c470-db2f-4c5d-9d51-81ccb9d1774a"); 
	       HttpEntity<String> entity = new HttpEntity<String>("parameters", headers); 
	       ResponseEntity<AmazonProductLinkDTO> response = restTemplate.exchange(host + urlProduct, HttpMethod.GET, entity, 
	           AmazonProductLinkDTO.class); 
	       producto = response.getBody(); 
	     } catch (Exception e) { 
	       System.out.println(e); 
	     } 
	     return producto; 
	   } 
	    
	   private void costoQuetzales(AmazonProductLinkDTO producto) { 
	    producto.setPrecioQuetzales(producto.getPrice().multiply(new BigDecimal(8).add( 
	      producto.getPrice().multiply(new BigDecimal(0.40)))).abs()); 
	     
	     
	   }
	
}
