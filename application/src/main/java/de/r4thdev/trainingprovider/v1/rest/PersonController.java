package de.r4thdev.trainingprovider.v1.rest;

import de.r4thdev.trainingprovider.services.PersonService;
import de.r4thdev.trainingprovider.v1.api.PersonApi;
import de.r4thdev.trainingprovider.v1.api.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController implements PersonApi {

    @Autowired
    PersonService personService;

    @Override
    public List<PersonDto> getPersons() {
        return personService.getPersons(Optional.empty());
    }

    @Override
    public PersonDto addPerson(PersonDto personDto) {
        return personService.createPerson(personDto);
    }
}
