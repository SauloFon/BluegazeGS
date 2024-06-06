package com.blueeyes.demo.repository;

import com.blueeyes.demo.domain.UserBlue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserBlue, Long> {
}
