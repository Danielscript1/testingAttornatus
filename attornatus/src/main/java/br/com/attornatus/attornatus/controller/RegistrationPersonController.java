package br.com.attornatus.attornatus.controller;


import br.com.attornatus.attornatus.dto.PersonNewDto;
import br.com.attornatus.attornatus.model.Person;
import br.com.attornatus.attornatus.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value="/pessoa")
public class RegistrationPersonController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping
    public ResponseEntity<Person> insert(@RequestBody PersonNewDto dados){
        Person obj = peopleService.fromDto(dados);
        obj = peopleService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value= "/{id}")
    public ResponseEntity<Person> update(@PathVariable long id, @RequestBody Person obj){
        Person updateUser = peopleService.update(id, obj);
        return ResponseEntity.ok().body(updateUser);
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity<Person> findById(@PathVariable long id){
        Person obj = peopleService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> list = peopleService.findAll();
        return ResponseEntity.ok().body(list);
    }


}
