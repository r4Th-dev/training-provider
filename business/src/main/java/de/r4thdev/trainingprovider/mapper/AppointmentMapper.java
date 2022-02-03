package de.r4thdev.trainingprovider.mapper;

import de.r4thdev.trainingprovider.entities.Appointment;
import de.r4thdev.trainingprovider.entities.Person;
import de.r4thdev.trainingprovider.entities.Training;
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

    default HashMap<UUID, String> convertCustomerListToRegistrationsHashmap(List<Person> personList) {
        HashMap<UUID, String> hm = new HashMap<>();
        if (personList != null) {
            personList.forEach(person -> hm.put(person.getId(), person.getName()));
        }
        return hm;
    }

    default List<Person> convertRegistrationsHashmapToCustomerList(HashMap<UUID, String> registrations) {
        List<Person> people = new ArrayList<>();
        if (registrations != null) {
            registrations.forEach((uuid, s) -> people.add(
                    Person.builder()
                            .id(uuid)
                            .name(s)
                            .build()
            ));
        }
        return people;
    }

    default HashMap<UUID, String> convertAppointmentListToHashmap(List<Appointment> appointments) {
        HashMap<UUID, String> hm = new HashMap<>();
        if (appointments != null) {
            appointments.forEach(appointment -> hm.put(appointment.getId(), appointment.getTraining().getName()));
        }
        return hm;
    }

    default List<Appointment> convertHashmapToAppointmentList(HashMap<UUID, String> appointments) {
        List<Appointment> appointmentList = new ArrayList<>();
        if (appointments != null) {
            appointments.forEach((uuid, s) -> appointmentList.add(
                    Appointment.builder()
                            .id(uuid)
                            .training(Training.builder()
                                    .name(s)
                                    .build())
                            .build()
            ));
        }
        return appointmentList;
    }
}
