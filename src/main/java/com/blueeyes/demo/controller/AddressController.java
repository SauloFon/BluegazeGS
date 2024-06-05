package com.blueeyes.demo.controller;

import com.blueeyes.demo.domain.Address;
import com.blueeyes.demo.service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> save(@Valid Address address){
        Address addressSave = addressService.save(address);
        return ResponseEntity.ok(addressSave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id){
        Address address = addressService.findById(id);
        return ResponseEntity.ok(address);
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll(){
        List<Address> addresses = addressService.findAll();
        return ResponseEntity.ok(addresses);
    }

}
