package br.com.supera.game.store.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.supera.game.store.modelo.Client;

public class ClientDTO {

	private Long id;
	private String adress;
	private String name;
	private String telephone;
	private List<RequestDTO> requests = new ArrayList<>();

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

	public List<RequestDTO> getRequests() {
		return requests;
	}

	public void setRequests(List<RequestDTO> requests) {
		this.requests = requests;
	}

	public static ClientDTO clientToClientDTO(Client entidade) 
	{
		ClientDTO dto = new ClientDTO();
		dto.setAdress(entidade.getAdress());
		dto.setName(entidade.getName());
		dto.setTelephone(entidade.getTelephone());
		
		
		return dto;
	}

}
