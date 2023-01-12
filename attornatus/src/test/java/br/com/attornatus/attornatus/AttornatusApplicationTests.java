package br.com.attornatus.attornatus;

import br.com.attornatus.attornatus.model.Address;
import br.com.attornatus.attornatus.model.Person;
import br.com.attornatus.attornatus.repository.AddressRepository;
import br.com.attornatus.attornatus.repository.PeopleRepository;
import br.com.attornatus.attornatus.service.PeopleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AttornatusApplicationTests {

	@Autowired
	PeopleRepository peopleRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	PeopleService peopleService;

	@Test
	@Order(1)
	public void shouldPersistirBancoTest() {

		Person savedPerson = peopleRepository.save(new Person(1l,"daniel","2023-01-12"));
		Assertions.assertThat(savedPerson.getId()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	public void getPersonTest(){

		Person person = peopleRepository.findById(1L).get();

		Assertions.assertThat(person.getId()).isEqualTo(1L);

	}

	@Test
	@Order(3)
	public void getListOfPersonTest(){

		List<Person> person = peopleRepository.findAll();
		Assertions.assertThat(person.size()).isEqualTo(0);

	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updatePersonTest(){

		Person person = peopleRepository.findById(1L).get();

		person.setName("daniel");

		Person people =  peopleRepository.save(person);

		Assertions.assertThat(people.getName()).isEqualTo("daniel");

	}

	@Test
	@Order(5)
	public void getListOfAddressTest(){

		List<Address> address = addressRepository.findAll();
		Assertions.assertThat(address.size()).isEqualTo(0);

	}




}
