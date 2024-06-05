package com.blueeyes.demo.domain;

import com.blueeyes.demo.controller.UsersController;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Report extends EntityModel<Report> {
    @Id
    private Long id;
    @ManyToOne
    private Address address;
    @ManyToOne
    private ReportType type;
    @NotBlank
    @Size(min = 3, max = 255)
    private String description;


    public EntityModel<Report> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(UsersController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(UsersController.class).findAll()).withSelfRel()
        );
    }
}