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

import br.unisul.pweb.quarta.domain.Atleta;
import br.unisul.pweb.quarta.dtos.AtletaDTO;
import br.unisul.pweb.quarta.services.AtletaService;
import br.unisul.pweb.quarta.services.ModalidadeService;

@RestController
@RequestMapping(value="/AtletaDomain")
public class AtletaResource {
	
	@Autowired
	private AtletaService service;
	
	@Autowired
	private ModalidadeService modalidadeService;
	
	//BUSCAR POR ID
	@RequestMapping(value="/{id}",method=RequestMethod.GET) 
	public ResponseEntity<Atleta> find(@PathVariable Integer id){
		Atleta obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//LISTAR TODAS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AtletaDTO>> findAll() {
		List<Atleta> lista = service.findAll();
		//ou for para percorrer a lista
		//List<CategoriaDTO> listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		List<AtletaDTO> listaDTO = new ArrayList<AtletaDTO>();
		for (Atleta c : lista) {
			listaDTO.add(new AtletaDTO(c));
		}
		return ResponseEntity.ok().body(listaDTO);
	}
}
