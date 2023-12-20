package br.com.luiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luiz.data.vo.v1.PersonVO;
import br.com.luiz.data.vo.v2.PersonVOV2;
import br.com.luiz.service.PersonService;

@RestController
@RequestMapping(value = "/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<PersonVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
		return service.findById(id);
	}
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public PersonVO create(@RequestBody PersonVO person) throws Exception {
		return service.create(person);
	}
	
	@PostMapping(value = "/v2",
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) throws Exception {
		return service.createV2(person);
	}
	
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public PersonVO update(@RequestBody PersonVO person) throws Exception {
		return service.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) throws Exception {
		service.delete(id);
	}
}
