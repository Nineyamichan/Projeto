package br.com.supera.game.store.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.dto.RequestDTO;
import br.com.supera.game.store.service.IRequestService;

@RestController
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private IRequestService service;

	@GetMapping
	public List<RequestDTO> list() {
		
		List<RequestDTO> retorno = new ArrayList<>(); 
		service.list().forEach(a -> {
			RequestDTO dto = RequestDTO.requestToRequestDTO(a); 
			retorno.add(dto); 
		});
		return retorno;
	}

}
