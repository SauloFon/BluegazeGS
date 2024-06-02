package com.blueeyes.demo.repository;

import com.blueeyes.demo.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
