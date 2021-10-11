package br.com.supera.game.store.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tb_product database table.
 * 
 */
@Entity
@Table(name="tb_product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String image;

	private String name;

	private BigDecimal price;

	private short score;

	//bi-directional many-to-one association to RERequest
	@OneToMany(mappedBy="tbProduct", fetch=FetchType.EAGER)
	private List<RERequest> tbReRequests;

	public Product() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public short getScore() {
		return this.score;
	}

	public void setScore(short score) {
		this.score = score;
	}

	public List<RERequest> getTbReRequests() {
		return this.tbReRequests;
	}

	public void setTbReRequests(List<RERequest> tbReRequests) {
		this.tbReRequests = tbReRequests;
	}

	public RERequest addTbReRequest(RERequest tbReRequest) {
		getTbReRequests().add(tbReRequest);
		tbReRequest.setTbProduct(this);

		return tbReRequest;
	}

	public RERequest removeTbReRequest(RERequest tbReRequest) {
		getTbReRequests().remove(tbReRequest);
		tbReRequest.setTbProduct(null);

		return tbReRequest;
	}

}