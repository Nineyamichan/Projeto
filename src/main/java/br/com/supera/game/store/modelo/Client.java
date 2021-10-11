package br.com.supera.game.store.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_client database table.
 * 
 */
@Entity
@Table(name="tb_client")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String adress;

	private String name;

	private String telephone;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="tbClient", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Request> tbRequests;

	public Client() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Request> getTbRequests() {
		return this.tbRequests;
	}

	public void setTbRequests(List<Request> tbRequests) {
		this.tbRequests = tbRequests;
	}

	public Request addTbRequest(Request tbRequest) {
		getTbRequests().add(tbRequest);
		tbRequest.setTbClient(this);

		return tbRequest;
	}

	public Request removeTbRequest(Request tbRequest) {
		getTbRequests().remove(tbRequest);
		tbRequest.setTbClient(null);

		return tbRequest;
	}

}