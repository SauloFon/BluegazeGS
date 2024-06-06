package com.blueeyes.demo.controller;

import com.blueeyes.demo.domain.UserBlue;
import com.blueeyes.demo.dtos.UsersDTO;
import com.blueeyes.demo.service.UsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<EntityModel<UserBlue>> save(@RequestBody @Valid UsersDTO usersDTO){
        UserBlue userBlue = usersService.save(usersDTO);
        return ResponseEntity.ok(userBlue.toEntityModel());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<EntityModel<UserBlue>> findById(@PathVariable Long id){
        UserBlue userBlue = usersService.findById(id);
        return ResponseEntity.ok(userBlue.toEntityModel());
    }

    @GetMapping
    public ResponseEntity<Page<UserBlue>> findAll(Pageable pageable){
        Page<UserBlue> users = usersService.findAll(pageable);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        usersService.delete(id);
        return ResponseEntity.ok().build();
    }


}
