package com.webatrio.TestApiRest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personnes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nomPersonne;
    private String prenomPersonne;
    private String dateNaissance;
}
