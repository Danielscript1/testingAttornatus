package br.com.attornatus.attornatus.repository;


import br.com.attornatus.attornatus.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {

}
