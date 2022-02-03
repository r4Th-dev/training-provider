package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.entities.Person;
import de.r4thdev.trainingprovider.mapper.PersonMapper;
import de.r4thdev.trainingprovider.repositories.PersonRepository;
import de.r4thdev.trainingprovider.v1.api.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    PersonMapper personMapper = PersonMapper.INSTANCE;

    public List<PersonDto> getPersons(Optional<UUID> personId) {
        Person person = Person.builder().build();
        personId.ifPresent(person::setId);
        Example<Person> personExample = Example.of(person);

        return personRepository.findAll(personExample)
                .stream()
                .map(personMapper::personToPersonDto)
                .collect(Collectors.toList());
    }

    public PersonDto createPerson(PersonDto personDto) {
        return personMapper.personToPersonDto(
                personRepository.save(personMapper.personDtoToPerson(personDto)));
    }

    public void deleteCustomer(UUID personId) {
        personRepository.deleteById(personId);
    }
}

