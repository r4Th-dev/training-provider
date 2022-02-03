package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.entities.Appointment;
import de.r4thdev.trainingprovider.entities.Person;
import de.r4thdev.trainingprovider.mapper.AppointmentMapper;
import de.r4thdev.trainingprovider.repositories.AppointmentRepository;
import de.r4thdev.trainingprovider.repositories.PersonRepository;
import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PersonRepository personRepository;

    AppointmentMapper appointmentMapper = AppointmentMapper.INSTANCE;


    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = appointmentRepository.save(
                appointmentMapper.appointmentDtoToAppointment(appointmentDto)
        );
        return appointmentMapper.appointmentToAppointmentDto(appointmentRepository.getById(appointment.getId()));
    }

    public RegistrationStatusDto register(UUID appointmentId, UUID personId) {
        RegistrationStatusDto registrationStatusDto = RegistrationStatusDto.builder()
                .registered(false)
                .build();
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        Optional<Person> personOptional = personRepository.findById(personId);

        if (appointmentOptional.isPresent() && personOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            Person person = personOptional.get();

            appointment.getRegistrations()
                    .add(person);
            AppointmentDto appointmentDto = appointmentMapper.appointmentToAppointmentDto(appointmentRepository.save(appointment));
            registrationStatusDto.setAppointmentDto(appointmentDto);
            registrationStatusDto.setRegistered(true);
        }

        return registrationStatusDto;
    }
}

