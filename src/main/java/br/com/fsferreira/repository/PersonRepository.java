package br.com.fsferreira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fsferreira.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
