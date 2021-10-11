package br.com.supera.game.store.controler;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.supera.game.store.dto.ClientDTO;
import br.com.supera.game.store.form.ClientForm;
import br.com.supera.game.store.modelo.Client;
import br.com.supera.game.store.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private IClientService service;
	
	@RequestMapping("/helloworld")
	public String hello () {
		return "helloWorld";
	}

	@GetMapping
	public List<ClientDTO> list () {
		List<ClientDTO> retorno = new ArrayList<>(); 
		service.list().forEach(a -> {
			ClientDTO dto = ClientDTO.clientToClientDTO(a); 
			retorno.add(dto); 
		});
		return retorno;
	}

	@PostMapping
	public ResponseEntity<ClientDTO> cadastrar (@RequestBody ClientForm form, UriComponentsBuilder uriBuilder) {
		Client entity = ClientForm.clientFormToClient(form); 
		service.save(entity);
		
		URI uri = uriBuilder.path("/client/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(ClientDTO.clientToClientDTO(entity));
	}

}
