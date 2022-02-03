package de.r4thdev.trainingprovider.v1.api;

import de.r4thdev.trainingprovider.v1.api.dto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RequestMapping(path = "/api/v1/persons", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public interface PersonApi {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<PersonDto> getPersons();

    @GetMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    PersonDto getPerson(
            @PathVariable UUID personId
    );

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    PersonDto addPerson(
            @RequestBody @Valid PersonDto personDto);

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    PersonDto editPerson(
            @RequestBody @Valid PersonDto personDto);

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    void deletePerson(
            @PathVariable UUID personId
    );
}
