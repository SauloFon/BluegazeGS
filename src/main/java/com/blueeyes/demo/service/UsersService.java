package com.blueeyes.demo.service;

import com.blueeyes.demo.domain.Users;
import com.blueeyes.demo.dtos.UsersDTO;
import com.blueeyes.demo.exceptions.UsersNotFoundException;
import com.blueeyes.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsersService {

    private final UsersRepository usersRepository;

    public Users save(UsersDTO dto) {
        Users users = Users.builder()
                .username(dto.username())
                .email(dto.email())
                .address(dto.address())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
        return usersRepository.save(users);
    }

    public Users findById(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new UsersNotFoundException("Not Found User with id: " + id));
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public void delete(Long id) {
        Users users = usersRepository.findById(id).orElseThrow(() -> new UsersNotFoundException("Not Found User with id: " + id));
        usersRepository.delete(users);
    }
}
