package com.blueeyes.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    private Long id;
    @ManyToOne
    private Address address;
    @ManyToOne
    private ReportType type;
    @NotBlank
    @Size(min = 3, max = 255)
    private String description;
}