package br.com.supera.game.store.dto;

import java.math.BigDecimal;

import br.com.supera.game.store.modelo.Request;

public class RequestDTO {

	private int idClient; 
	
	private BigDecimal discount;
	private Integer quantity;
	private BigDecimal requestValue;
	
	public static RequestDTO requestToRequestDTO (Request entity){
		RequestDTO dto = new RequestDTO();
		
		dto.setDiscount(entity.getDiscount());
		dto.setQuantity(entity.getQuantity());
		dto.setRequestValue(entity.getRequestValue());
		
		dto.setIdClient(entity.getId().getTbClientId());

		return dto;
	}
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
