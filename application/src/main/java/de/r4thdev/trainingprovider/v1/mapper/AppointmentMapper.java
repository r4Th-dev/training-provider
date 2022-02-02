package de.r4thdev.trainingprovider.v1.mapper;

import de.r4thdev.trainingprovider.repositories.Appointment;
import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    AppointmentDto appointmentToAppointmentDto(Appointment appointment);

    Appointment appointmentDtoToAppointment(AppointmentDto appointmentDto);
}
