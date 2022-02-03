package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.entities.Appointment;
import de.r4thdev.trainingprovider.entities.Person;
import de.r4thdev.trainingprovider.exceptions.AppointmentNotFoundException;
import de.r4thdev.trainingprovider.mapper.AppointmentMapper;
import de.r4thdev.trainingprovider.repositories.AppointmentRepository;
import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationStatusDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {
    AppointmentMapper appointmentMapper = AppointmentMapper.INSTANCE;

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PersonService personService;
    @Autowired
    TrainingService trainingService;


    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }


    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        return appointmentMapper.appointmentToAppointmentDto(
                this.createAppointment(
                        appointmentMapper.appointmentDtoToAppointment(appointmentDto)
                )
        );
    }

    @SneakyThrows
    protected Appointment createAppointment(Appointment appointment) {
        trainingService.checkIfTrainingExist(appointment.getTrainer().getId());
        personService.checkIfPersonExist(appointment.getTrainer().getId());

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return appointmentRepository.getById(savedAppointment.getId());
    }

    @SneakyThrows
    public RegistrationStatusDto register(UUID appointmentId, UUID personId) {
        RegistrationStatusDto registrationStatusDto = RegistrationStatusDto.builder()
                .registered(false)
                .build();

        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        Appointment appointment = appointmentOptional.orElseThrow(AppointmentNotFoundException::new);
        Person person = personService.getPerson(personId);

        if (appointment.getRegistrations().size() >= 10) {
            registrationStatusDto.setMessage("Appointment is fully booked.");
        } else {
            appointment.getRegistrations()
                    .add(person);
            AppointmentDto appointmentDto = appointmentMapper.appointmentToAppointmentDto(appointmentRepository.save(appointment));
            registrationStatusDto.setAppointmentDto(appointmentDto);
            registrationStatusDto.setRegistered(true);
            registrationStatusDto.setMessage("Booking was successful!");
        }

        return registrationStatusDto;
    }
}

