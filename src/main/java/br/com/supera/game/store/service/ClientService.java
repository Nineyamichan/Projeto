package br.com.supera.game.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supera.game.store.modelo.Client;
import br.com.supera.game.store.repository.IClientRepository;

@Service
public class ClientService implements IClientService {
	
	public ClientService() {
	}
	
	@Autowired(required=true)
	private IClientRepository clientRepository;
	
	@Override
	public List<Client> list(){
		return clientRepository.findAll();
	}

	@Override
	public Client save(Client entity) {
		return clientRepository.save(entity);
	}
}
