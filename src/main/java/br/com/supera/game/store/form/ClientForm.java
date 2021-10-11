package br.com.supera.game.store.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.hql.internal.CollectionSubqueryFactory;
import org.springframework.util.CollectionUtils;

import br.com.supera.game.store.modelo.Client;
import br.com.supera.game.store.modelo.Request;
import br.com.supera.game.store.modelo.RequestPK;

public class ClientForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String adress;
	private String name;
	private String telephone;
	private List<RequestForm> tbRequests;
	
	public ClientForm() {
	}
	
	public static Client clientFormToClient(ClientForm form) {
		Client entity = new Client(); 
		entity.setAdress(form.getAdress());
		entity.setName(form.getName());
		entity.setTelephone(form.getTelephone());
		
		entity.setTbRequests(new ArrayList<>());
		
		if (!CollectionUtils.isEmpty(form.getTbRequests())){
			form.getTbRequests().forEach(a -> {
				
				Request request = new Request();
				request.setId(new RequestPK(a.getIdProduct()));
				request.setDiscount(a.getDiscount());
				request.setQuantity(a.getQuantity());
				request.setRequestValue(a.getRequestValue());
				
				entity.getTbRequests().add(request);
			});
		}
		
		return entity;
	}
	
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<RequestForm> getTbRequests() {
		return tbRequests;
	}
	public void setTbRequests(List<RequestForm> tbRequests) {
		this.tbRequests = tbRequests;
	}
}
