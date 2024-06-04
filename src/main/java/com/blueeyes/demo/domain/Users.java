package com.blueeyes.demo.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@Builder
public class Users {
    @Id
    private Long id;
    @NotBlank
    private String username;
    @Email @Column(unique = true)
    private String email;
    @OneToMany
    private Address address;
    @FutureOrPresent
    private Instant createdAt;
    @FutureOrPresent
    private Instant updatedAt;
}
