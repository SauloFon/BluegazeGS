package com.blueeyes.demo.domain;

import com.blueeyes.demo.controller.UsersController;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
public class ReportType extends EntityModel<ReportType> {
    @Id
    private Long id;
    @NotBlank
    private String name;

    public EntityModel<ReportType> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(UsersController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(UsersController.class).findAll()).withSelfRel()
        );
    }

}
