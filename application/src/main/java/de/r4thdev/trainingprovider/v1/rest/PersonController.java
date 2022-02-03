package de.r4thdev.trainingprovider.v1.rest;

import de.r4thdev.trainingprovider.services.PersonService;
import de.r4thdev.trainingprovider.v1.api.PersonApi;
import de.r4thdev.trainingprovider.v1.api.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class PersonController implements PersonApi {

    @Autowired
    PersonService personService;

    @Override
    public List<PersonDto> getPersons() {
        return personService.getPersonDtos();
    }

    @Override
    public PersonDto getPerson(UUID id) {
        return personService.getPersonDto(id);
    }

    @Override
    public PersonDto addPerson(PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @Override
    public PersonDto editPerson(PersonDto personDto) {
        if (personDto.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the id must not be null");
        return personService.editPerson(personDto);
    }

    @Override
    public void deletePerson(UUID id) {
        personService.deletePerson(id);
    }
}
