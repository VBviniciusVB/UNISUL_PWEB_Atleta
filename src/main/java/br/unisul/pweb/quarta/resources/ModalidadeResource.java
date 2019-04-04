package br.unisul.pweb.quarta.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.pweb.quarta.domain.Modalidade;
import br.unisul.pweb.quarta.dtos.ModalidadeDTO;
import br.unisul.pweb.quarta.services.AtletaService;
import br.unisul.pweb.quarta.services.ModalidadeService;

@RestController
@RequestMapping(value="/ModalidadeDomain")
public class ModalidadeResource {
	
	@Autowired
	private ModalidadeService service;
	
	@Autowired
	private AtletaService atletaService;
	
	//BUSCAR POR ID
	@RequestMapping(value="/{id}",method=RequestMethod.GET) 
	public ResponseEntity<Modalidade> find(@PathVariable Integer id){
		Modalidade obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//LISTAR TODAS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ModalidadeDTO>> findAll() {
		List<Modalidade> lista = service.findAll();
		//ou for para percorrer a lista
		//List<CategoriaDTO> listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		List<ModalidadeDTO> listaDTO = new ArrayList<ModalidadeDTO>();
		for (Modalidade c : lista) {
			listaDTO.add(new ModalidadeDTO(c));
		}
		return ResponseEntity.ok().body(listaDTO);
	}
}
