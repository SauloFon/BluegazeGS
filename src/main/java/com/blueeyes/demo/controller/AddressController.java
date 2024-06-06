package com.blueeyes.demo.controller;

import com.blueeyes.demo.domain.Address;
import com.blueeyes.demo.domain.Report;
import com.blueeyes.demo.service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<EntityModel<Address>> save(@Valid @RequestBody Address address){
        Address savedAddress = addressService.save(address);
        return ResponseEntity.ok(savedAddress.toEntityModel());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<EntityModel<Address>> findById(@PathVariable Long id){
        Address address = addressService.findById(id);
        return ResponseEntity.ok(address.toEntityModel());
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll(){
        List<Address> addresses = addressService.findAll();
        return ResponseEntity.ok(addresses);
    }

}
