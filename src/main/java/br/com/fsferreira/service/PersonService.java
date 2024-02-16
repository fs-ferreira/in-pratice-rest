package br.com.fsferreira.service;

import java.util.List;

import br.com.fsferreira.dto.PersonDTO;
import br.com.fsferreira.utils.mapper.PersonMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fsferreira.utils.exception.ResourceNotFoundException;
import br.com.fsferreira.model.Person;
import br.com.fsferreira.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;

	@Autowired
	PersonMapper mapper;

	public List<PersonDTO> findAll() {
		return mapper.personsToPersonDtos(repository.findAll());
	}

	public PersonDTO findById(Long id) {
		return mapper.personToPersonDto(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found!")));
	}

	public PersonDTO create(PersonDTO person) {
		var entity = mapper.personDtoToPerson(person);
		return mapper.personToPersonDto(repository.save(entity));
	}

	public PersonDTO update(PersonDTO person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return mapper.personToPersonDto(repository.save(entity));
	}

	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found!"));
		repository.delete(entity);
	}

}
