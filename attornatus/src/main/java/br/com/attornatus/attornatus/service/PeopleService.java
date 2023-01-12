package br.com.attornatus.attornatus.service;


import br.com.attornatus.attornatus.dto.PersonNewDto;
import br.com.attornatus.attornatus.exceptions.ResourceNotFoundException;
import br.com.attornatus.attornatus.model.Address;
import br.com.attornatus.attornatus.model.Person;
import br.com.attornatus.attornatus.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;


    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findById(Long id){
        Optional<Person> obj = peopleRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Person insert(Person people) {
        people.setId(null);
        people = peopleRepository.save(people);
        return people;

    }

    public Person update(Long id, Person people) {
        try {
            Person entity = peopleRepository.getOne(id);
            UpdateData(entity,people);
            return peopleRepository.save(entity);
        }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    private void UpdateData(Person entity, Person obj) {
        entity.setName(obj.getName());
        entity.setBirthDate(obj.getBirthDate());

    }

    public Person fromDto(PersonNewDto objDto){
        Person person = new Person(null,objDto.getName(),objDto.getBirthDate());
        Address address = new Address(null,objDto.getCity(),objDto.getNumber(),objDto.getPublicPlace(),objDto.getZipCode(),objDto.getMainAddres(),person);
        person.getAddress().add(address);
        return  person;
    }


}
