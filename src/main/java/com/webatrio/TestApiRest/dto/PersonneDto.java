package com.webatrio.TestApiRest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonneDto {

    private int id;
    private String nomPersonne;
    private String prenomPersonne;
    private String dateNaissance;

    private int age;

}
