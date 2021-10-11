package br.com.supera.game.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supera.game.store.modelo.Request;
import br.com.supera.game.store.repository.IRequestRepository;

@Service
public class RequestService implements IRequestService {
	
	public RequestService() {
	}
	
	@Autowired(required=true)
	private IRequestRepository requestRepository;
	
	@Override
	public List<Request> list(){
		return requestRepository.findAll();
	}

	@Override
	public Request save (Request entity) {
		return requestRepository.save(entity);
	}
}
