package br.com.luiz;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiz.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
