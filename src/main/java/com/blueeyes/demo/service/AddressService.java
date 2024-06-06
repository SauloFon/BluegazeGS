package com.blueeyes.demo.service;

import com.blueeyes.demo.domain.Address;
import com.blueeyes.demo.exceptions.AddressNotFoundException;
import com.blueeyes.demo.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService {

    private final AddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Not Found Address with id: " + id));
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

}
