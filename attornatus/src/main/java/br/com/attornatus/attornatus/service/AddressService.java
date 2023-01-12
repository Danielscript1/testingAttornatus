package br.com.attornatus.attornatus.service;


import br.com.attornatus.attornatus.model.Address;
import br.com.attornatus.attornatus.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }
}
