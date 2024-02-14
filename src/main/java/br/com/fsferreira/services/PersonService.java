package br.com.fsferreira.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.fsferreira.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.getAndIncrement());
		person.setFirstName("Felipe " + i);
		person.setLastName("Ferreira " + i);
		person.setAddress("Campinas - SP " + i);
		person.setGender("Masculino");
		return person;
	}

	public Person findById(String id) {
		logger.info("Finding one person...");
		return mockPerson(0);
	}

	public Person create(Person person) {
		logger.info("Creating one person...");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one person...");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person...");
	}

}
