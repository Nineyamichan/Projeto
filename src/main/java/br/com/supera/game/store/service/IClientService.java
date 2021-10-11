package br.com.supera.game.store.service;

import java.util.List;

import br.com.supera.game.store.modelo.Client;

public interface IClientService {
	
	List<Client> list();
	Client save(Client entity);

}
