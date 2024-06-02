package com.blueeyes.demo.repository;

import com.blueeyes.demo.domain.Address;
import com.blueeyes.demo.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
