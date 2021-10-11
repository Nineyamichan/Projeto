package br.com.supera.game.store.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


/**
 * The persistent class for the tb_request database table.
 * 
 */
@Entity
@Table(name="tb_request")
@NamedQuery(name="Request.findAll", query="SELECT r FROM Request r")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RequestPK id;

	@Generated(GenerationTime.ALWAYS)
	@Temporal(TemporalType.DATE)
	@Column(name="date_emiss")
	private Date dateEmiss;

	private BigDecimal discount;

	private Integer quantity;

	@Column(name="request_value")
	private BigDecimal requestValue;

	//bi-directional many-to-one association to RERequest
	@OneToMany(mappedBy="tbRequest", fetch=FetchType.EAGER)
	private List<RERequest> tbReRequests;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="tb_client_id", insertable=false, updatable=false)
	private Client tbClient;

	public Request() {
	}

	public RequestPK getId() {
		return this.id;
	}

	public void setId(RequestPK id) {
		this.id = id;
	}

	public Date getDateEmiss() {
		return this.dateEmiss;
	}

	public void setDateEmiss(Date dateEmiss) {
		this.dateEmiss = dateEmiss;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getRequestValue() {
		return this.requestValue;
	}

	public void setRequestValue(BigDecimal requestValue) {
		this.requestValue = requestValue;
	}

	public List<RERequest> getTbReRequests() {
		return this.tbReRequests;
	}

	public void setTbReRequests(List<RERequest> tbReRequests) {
		this.tbReRequests = tbReRequests;
	}

	public RERequest addTbReRequest(RERequest tbReRequest) {
		getTbReRequests().add(tbReRequest);
		tbReRequest.setTbRequest(this);

		return tbReRequest;
	}

	public RERequest removeTbReRequest(RERequest tbReRequest) {
		getTbReRequests().remove(tbReRequest);
		tbReRequest.setTbRequest(null);

		return tbReRequest;
	}

	public Client getTbClient() {
		return this.tbClient;
	}

	public void setTbClient(Client tbClient) {
		this.tbClient = tbClient;
	}

}