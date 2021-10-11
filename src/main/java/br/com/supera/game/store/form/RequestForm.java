package br.com.supera.game.store.form;

import java.math.BigDecimal;

public class RequestForm {
	
	private Integer idProduct;
	
	private Integer quantity;
	private BigDecimal discount;
	private BigDecimal requestValue;
	
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getRequestValue() {
		return requestValue;
	}
	public void setRequestValue(BigDecimal requestValue) {
		this.requestValue = requestValue;
	}
}
