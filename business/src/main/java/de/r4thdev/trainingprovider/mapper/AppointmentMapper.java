package de.r4thdev.trainingprovider.mapper;

import de.r4thdev.trainingprovider.entities.Appointment;
import de.r4thdev.trainingprovider.entities.Person;
import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Mapper
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);


    AppointmentDto appointmentToAppointmentDto(Appointment appointment);

    Appointment appointmentDtoToAppointment(AppointmentDto appointmentDto);

    default HashMap<UUID, String> convertCustomerListToRegistrationsHashmap(List<Person> appointments) {
        HashMap<UUID, String> hm = new HashMap<>();
        if (appointments != null) {
            appointments.forEach(person -> hm.put(person.getId(), person.getName()));
        }
        return hm;
    }

    default List<Person> convertRegistrationsHashmapToCustomerList(HashMap<UUID, String> appointments) {
        List<Person> people = new ArrayList<>();
        if (appointments != null) {
            appointments.forEach((uuid, s) -> people.add(
                    Person.builder()
                            .id(uuid)
                            .name(s)
                            .build()
            ));
        }
        return people;
    }
}
