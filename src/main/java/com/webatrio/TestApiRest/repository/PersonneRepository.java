package com.webatrio.TestApiRest.repository;


import com.webatrio.TestApiRest.entities.Personnes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Personnes, Integer> {

    //recuperer les personnes en ordre alphabetique
    List<Personnes>findAllByOrderByNomPersonne();

    List<Personnes> findPersonnesByNomPersonne(String nomPersonne);
}
