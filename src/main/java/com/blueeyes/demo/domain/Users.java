package com.blueeyes.demo.domain;


import com.blueeyes.demo.controller.UsersController;
import com.blueeyes.demo.dtos.UsersDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.hateoas.EntityModel;

import java.time.Instant;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@Builder
public class Users  extends EntityModel<Users> {
    @Id
    private Long id;
    @NotBlank
    private String username;
    @Email @Column(unique = true)
    private String email;
    @ManyToOne
    private Address address;
    @FutureOrPresent
    private Instant createdAt;
    @FutureOrPresent
    private Instant updatedAt;


    public EntityModel<Users> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(UsersController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(UsersController.class).delete(id)).withRel("delete")
        );
    }
}
