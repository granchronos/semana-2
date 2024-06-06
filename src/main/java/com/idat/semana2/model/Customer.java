package com.idat.semana2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthday;

}
