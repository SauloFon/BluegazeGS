package com.blueeyes.demo.repository;

import com.blueeyes.demo.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
