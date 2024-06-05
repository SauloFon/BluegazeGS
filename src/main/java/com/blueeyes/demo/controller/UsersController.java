package com.blueeyes.demo.controller;

import com.blueeyes.demo.domain.Users;
import com.blueeyes.demo.dtos.UsersDTO;
import com.blueeyes.demo.service.UsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<EntityModel<Users>> save(@Valid UsersDTO usersDTO){
        Users users = usersService.save(usersDTO);
        return ResponseEntity.created(users.toEntityModel().getRequiredLink("self").toUri())
                .body(users.toEntityModel());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<EntityModel<Users>> findById(@PathVariable Long id){
        Users users = usersService.findById(id);
        return ResponseEntity.ok(users.toEntityModel());
    }

    @GetMapping
    public ResponseEntity<List<Users>> findAll(){
        List<Users> users = usersService.findAll();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        usersService.delete(id);
        return ResponseEntity.ok().build();
    }


}
