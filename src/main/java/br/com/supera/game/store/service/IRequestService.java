package br.com.supera.game.store.service;

import java.util.List;

import br.com.supera.game.store.modelo.Request;

public interface IRequestService {
	
	List<Request> list();
	Request save(Request entity);

}
