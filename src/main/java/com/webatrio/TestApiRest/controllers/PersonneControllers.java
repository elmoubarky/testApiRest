package com.webatrio.TestApiRest.controllers;

import com.webatrio.TestApiRest.dto.PersonneDto;
import com.webatrio.TestApiRest.entities.Personnes;
import com.webatrio.TestApiRest.services.PersonneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/personnes")
public class PersonneControllers {
    @Autowired
    private PersonneServices personneServices;


    @PostMapping(value = "/create")
    public PersonneDto createPersonne(@RequestBody Personnes personnes) {

        PersonneDto personneDto = new PersonneDto();

            int pAge = calculPersonneAge(personnes.getDateNaissance());

            //seul les personnes de moins de 150 ans peuvent etre enregistées
            if(150>pAge) throw new RuntimeException("Personne Age > 150");
            personnes = personneServices.createPersonne(personnes);
            personneDto.setNomPersonne(personnes.getNomPersonne());
            personneDto.setId(personnes.getId());
            personneDto.setPrenomPersonne(personnes.getPrenomPersonne());
            personneDto.setAge(pAge);


        return personneDto;
    }

    @GetMapping("/allbyOrderByName")
    public List<PersonneDto> getAllPersonnesOrder() {

        List<PersonneDto> personneDtos = new ArrayList<>();
        List<Personnes> getAllPersonnes = personneServices.findAllByOrderByNomPersonne();

        if(getAllPersonnes!=null && getAllPersonnes.size()>0){
            //ajouter l'age aux personnes
            for (int i=0; i<getAllPersonnes.size(); i++){
                PersonneDto personneDto = new PersonneDto();
                personneDto.setAge(calculPersonneAge(getAllPersonnes.get(i).getDateNaissance()));
                personneDto.setId(getAllPersonnes.get(i).getId());
                personneDto.setNomPersonne(getAllPersonnes.get(i).getNomPersonne());
                personneDto.setPrenomPersonne(getAllPersonnes.get(i).getPrenomPersonne());
                personneDto.setDateNaissance(getAllPersonnes.get(i).getDateNaissance());

                personneDtos.add(personneDto);
            }
        }

        return personneDtos;

    }

    public int calculPersonneAge(String pDate){
        int personneAge = 0;

        SimpleDateFormat sdf2  = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        try {
            Date dateNaissance = sdf2.parse(pDate);
            Date dateJour = new Date();
            personneAge = (int) (dateJour.getTime() - dateNaissance.getTime());

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return personneAge;

    }


}
