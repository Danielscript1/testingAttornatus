package br.com.attornatus.attornatus.controller;


import br.com.attornatus.attornatus.model.Address;
import br.com.attornatus.attornatus.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/endereco")
public class RegistrationAddressController {

    @Autowired
    private AddressService addressService;
    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        List<Address> list = addressService.findAll();
        return ResponseEntity.ok().body(list);
    }

}
