package de.r4thdev.trainingprovider.mapper;

import de.r4thdev.trainingprovider.entities.Appointment;
import de.r4thdev.trainingprovider.entities.Person;
import de.r4thdev.trainingprovider.entities.Training;
import de.r4thdev.trainingprovider.v1.api.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto personToPersonDto(Person person);

    Person personDtoToPerson(PersonDto personDto);

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
