package com.blueeyes.demo.domain;


import com.blueeyes.demo.controller.UsersController;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import java.time.Instant;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBlue extends EntityModel<UserBlue> {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private Instant createdAt;
    private Instant updatedAt;


    public EntityModel<UserBlue> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(UsersController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(UsersController.class).delete(id)).withRel("delete"),
                linkTo(methodOn(UsersController.class).findAll(Pageable.unpaged())).withSelfRel()
        );
    }
}
