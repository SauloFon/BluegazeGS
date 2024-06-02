package com.blueeyes.demo.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    private Long id;
    @NotBlank
    private String username;
    @Email @Column(unique = true)
    private String email;
    @OneToMany
    private Address address;
}
