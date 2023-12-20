package br.com.luiz.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luiz.PersonRepository;
import br.com.luiz.data.vo.v1.PersonVO;
import br.com.luiz.data.vo.v2.PersonVOV2;
import br.com.luiz.exceptions.ResourceNotFoundException;
import br.com.luiz.mapper.DozerMapper;
import br.com.luiz.mapper.custom.PersonMapper;
import br.com.luiz.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonMapper mapper;
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<PersonVO> findAll () {		
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById (Long id) {
		logger.info("Finding person by id.");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found!"));
		
		return DozerMapper.parseObject(entity, PersonVO.class); 
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating a new person.");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo = repository.save(entity);
		
		return DozerMapper.parseObject(vo, PersonVO.class);
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Creating a new person.");
		
		var entity = mapper.convertVoToEntity(person);	
		var vo = mapper.convertEntityToVo(repository.save(entity));
		
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating a person.");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		entity.setAddress(person.getAddress());
	
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deleting a new person.");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found!"));
		
		repository.delete(entity);
	}
}
