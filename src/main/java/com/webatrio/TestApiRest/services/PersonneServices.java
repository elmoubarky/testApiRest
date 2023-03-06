package com.webatrio.TestApiRest.services;

import com.webatrio.TestApiRest.entities.Personnes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonneServices {

    public List<Personnes> findAllByOrderByNomPersonne();

    public Personnes createPersonne(Personnes personnes);

    public Personnes getPersonneById(int idPersonne);
    public List<Personnes> getPersonneByName(String nomPersonne);
}
