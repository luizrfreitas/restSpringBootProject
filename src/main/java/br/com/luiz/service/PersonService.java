package br.com.luiz.service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import br.com.luiz.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person findById (String id) {
		logger.info("Finding person by id.");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Luiz");
		person.setLastName("Freitas");
		person.setAdress("Curitiba");
		person.setGender("Male");
		
		return person;
	}
}
