package br.com.supera.game.store.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_re_request")
@NamedQuery(name="RERequest.findAll", query="SELECT r FROM RERequest r")
public class RERequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//bi-directional many-to-one association to RERequest
	@ManyToOne
	private Request tbRequest;

	@ManyToOne
	@JoinColumn(name="tb_product_id")
	private Product tbProduct;
	
	@Column(name="unitary_value")
	private BigDecimal unitaryValue;
	
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Request getTbRequest() {
		return tbRequest;
	}

	public void setTbRequest(Request tbRequest) {
		this.tbRequest = tbRequest;
	}

	public Product getTbProduct() {
		return tbProduct;
	}

	public void setTbProduct(Product tbProduct) {
		this.tbProduct = tbProduct;
	}

	public BigDecimal getUnitaryValue() {
		return unitaryValue;
	}

	public void setUnitaryValue(BigDecimal unitaryValue) {
		this.unitaryValue = unitaryValue;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
