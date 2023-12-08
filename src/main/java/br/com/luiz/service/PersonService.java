package br.com.luiz.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import br.com.luiz.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<Person> findAll () {
		List<Person> persons = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}

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
	
	public Person create(Person person) {
		logger.info("Creating a new person.");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating a new person.");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting a new person.");
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("first name" + i);
		person.setLastName("last name" + i);
		person.setAdress("adress" + i);
		person.setGender("male");
		
		return person;
	}
}
