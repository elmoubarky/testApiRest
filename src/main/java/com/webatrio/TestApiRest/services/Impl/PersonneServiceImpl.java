package com.webatrio.TestApiRest.services.Impl;

import com.webatrio.TestApiRest.entities.Personnes;
import com.webatrio.TestApiRest.repository.PersonneRepository;
import com.webatrio.TestApiRest.services.PersonneServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonneServiceImpl implements PersonneServices {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public List<Personnes> findAllByOrderByNomPersonne() {
        return personneRepository.findAllByOrderByNomPersonne();
    }

    @Override
    public Personnes createPersonne(Personnes personnes) {
        return personneRepository.save(personnes);
    }

    @Override
    public Personnes getPersonneById(int idPersonne) {
        return personneRepository.getById(idPersonne);
    }

    @Override
    public List<Personnes> getPersonneByName(String nomPersonne) {
        return personneRepository.findPersonnesByNomPersonne(nomPersonne);
    }
}
