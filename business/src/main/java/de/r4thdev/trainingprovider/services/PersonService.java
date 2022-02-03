package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.entities.Person;
import de.r4thdev.trainingprovider.exceptions.PersonNotFoundException;
import de.r4thdev.trainingprovider.mapper.PersonMapper;
import de.r4thdev.trainingprovider.repositories.PersonRepository;
import de.r4thdev.trainingprovider.v1.api.dto.PersonDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {
    PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    PersonRepository personRepository;


    public List<PersonDto> getPersonDtos() {
        return this.getPersons()
                .stream()
                .map(personMapper::personToPersonDto)
                .collect(Collectors.toList());
    }

    protected List<Person> getPersons() {
        return personRepository.findAll();
    }

    public PersonDto getPersonDto(UUID personId) {
        return personMapper.personToPersonDto(this.getPerson(personId));
    }

    @SneakyThrows
    protected Person getPerson(UUID personId) {
        return personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
    }

    public PersonDto createPerson(PersonDto personDto) {
        return personMapper.personToPersonDto(
                this.createPerson(
                        personMapper.personDtoToPerson(personDto)
                )
        );
    }

    protected Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public PersonDto editPerson(PersonDto personDto) {
        Person person = this.getPerson(personDto.getId());

        if (personDto.getName() != null) person.setName(personDto.getName());
        if (personDto.getDescription() != null) person.setName(personDto.getDescription());

        return personMapper.personToPersonDto(this.createPerson(person));
    }


    public void deletePerson(UUID personId) {
        personRepository.deleteById(personId);
    }

    public void checkIfPersonExist(UUID id) throws PersonNotFoundException {
        personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }
}

