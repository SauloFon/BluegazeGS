package com.blueeyes.demo.service;

import com.blueeyes.demo.domain.UserBlue;
import com.blueeyes.demo.dtos.UsersDTO;
import com.blueeyes.demo.exceptions.UsersNotFoundException;
import com.blueeyes.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsersService {

    private final UsersRepository usersRepository;

    public UserBlue save(UsersDTO dto) {
        UserBlue userBlue = UserBlue.builder()
                .username(dto.username())
                .email(dto.email())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
        return usersRepository.save(userBlue);
    }

    public UserBlue findById(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new UsersNotFoundException("Not Found User with id: " + id));
    }

    public Page<UserBlue> findAll(Pageable pageable) {
        return usersRepository.findAll(pageable);
    }

    public void delete(Long id) {
        UserBlue userBlue = usersRepository.findById(id).orElseThrow(() -> new UsersNotFoundException("Not Found User with id: " + id));
        usersRepository.delete(userBlue);
    }
}
