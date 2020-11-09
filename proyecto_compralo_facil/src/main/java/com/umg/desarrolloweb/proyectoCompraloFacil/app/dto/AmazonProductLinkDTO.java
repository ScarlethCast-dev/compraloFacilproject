package com.umg.desarrolloweb.proyectoCompraloFacil.app.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class AmazonProductLinkDTO {
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getProductRating() {
		return productRating;
	}
	public void setProductRating(String productRating) {
		this.productRating = productRating;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getWarehouseAvailability() {
		return warehouseAvailability;
	}
	public void setWarehouseAvailability(String warehouseAvailability) {
		this.warehouseAvailability = warehouseAvailability;
	}
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getShippingPrice() {
		return shippingPrice;
	}
	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	public String getPriceShippingInformation() {
		return priceShippingInformation;
	}
	public void setPriceShippingInformation(String priceShippingInformation) {
		this.priceShippingInformation = priceShippingInformation;
	}
	public List<String> getFeatures() {
		return features;
	}
	public void setFeatures(List<String> features) {
		this.features = features;
	}
	public List<String> getImageUrlList() {
		return imageUrlList;
	}
	public void setImageUrlList(List<String> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public List<ProductDetailsDTO> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductDetailsDTO> productDetails) {
		this.productDetails = productDetails;
	}
	public String getMinimalQuantity() {
		return minimalQuantity;
	}
	public void setMinimalQuantity(String minimalQuantity) {
		this.minimalQuantity = minimalQuantity;
	}
	public BigDecimal getDealPrice() {
		return dealPrice;
	}
	public void setDealPrice(BigDecimal dealPrice) {
		this.dealPrice = dealPrice;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public MainImageDTO getMainImage() {
		return mainImage;
	}
	public void setMainImage(MainImageDTO mainImage) {
		this.mainImage = mainImage;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	
	private BigDecimal precioQuetzales;
	  public BigDecimal getPrecioQuetzales() {
	 return precioQuetzales;
	}
	public void setPrecioQuetzales(BigDecimal precioQuetzales) {
	 this.precioQuetzales = precioQuetzales;
	}
	private String link;
	  public String getLink() {
	 return link;
	}
	public void setLink(String link) {
	 this.link = link;
	}
	private String responseStatus; 
	private String productRating; 
	private String productTitle;
	private String asin; 
	private String warehouseAvailability; 
	private BigDecimal retailPrice; 
	private BigDecimal price;
	private BigDecimal shippingPrice;
	private String priceShippingInformation; 
	private List<String> features; 
	private List<String> imageUrlList; 
	private String productDescription;
	private List<ProductDetailsDTO> productDetails;
	private String minimalQuantity; 
	private BigDecimal dealPrice; 
	private BigDecimal salePrice;
	private MainImageDTO mainImage;
	private List<String> categories; 
	
	
}
