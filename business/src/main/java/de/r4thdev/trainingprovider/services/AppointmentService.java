package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.entities.Appointment;
import de.r4thdev.trainingprovider.entities.Person;
import de.r4thdev.trainingprovider.entities.Training;
import de.r4thdev.trainingprovider.exceptions.AppointmentNotFoundException;
import de.r4thdev.trainingprovider.mapper.AppointmentMapper;
import de.r4thdev.trainingprovider.repositories.AppointmentRepository;
import de.r4thdev.trainingprovider.v1.api.dto.AppointmentDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationDto;
import de.r4thdev.trainingprovider.v1.api.dto.RegistrationStatusDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    AppointmentMapper appointmentMapper = AppointmentMapper.INSTANCE;

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PersonService personService;
    @Autowired
    TrainingService trainingService;


    public List<AppointmentDto> getAppointmentDtos() {
        return this.getAppointments()
                .stream()
                .map(appointmentMapper::appointmentToAppointmentDto)
                .collect(Collectors.toList());
    }

    protected List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    public AppointmentDto getAppointmentDto(UUID id) {
        return appointmentMapper.appointmentToAppointmentDto(this.getAppointment(id));
    }

    @SneakyThrows
    protected Appointment getAppointment(UUID id) {
        return appointmentRepository.findById(id).orElseThrow(AppointmentNotFoundException::new);
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
        trainingService.checkIfTrainingExist(appointment.getTraining().getId());
        personService.checkIfPersonExist(appointment.getTrainer().getId());

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return appointmentRepository.getById(savedAppointment.getId());
    }

    public AppointmentDto editAppointment(AppointmentDto appointmentDto) {

        Appointment appointment = this.getAppointment(appointmentDto.getId());

        if (appointmentDto.getDate() != null) appointment.setDate(appointmentDto.getDate());
        if (appointmentDto.getTrainer() != null)
            appointment.setTrainer(Person.builder().id(appointmentDto.getTrainer().getId()).build());
        if (appointmentDto.getTraining() != null)
            appointment.setTraining(Training.builder().id(appointmentDto.getTraining().getId()).build());
        if (appointmentDto.getRegistrations() != null)
            appointmentDto.setRegistrations(appointmentDto.getRegistrations());

        Appointment appointment1 = this.createAppointment(appointment);
        return appointmentMapper.appointmentToAppointmentDto(appointment1);
    }

    @SneakyThrows
    public RegistrationStatusDto register(RegistrationDto registrationDto) {
        RegistrationStatusDto registrationStatusDto = RegistrationStatusDto.builder()
                .registered(false)
                .build();

        Optional<Appointment> appointmentOptional = appointmentRepository.findById(registrationDto.getAppointmentId());
        Appointment appointment = appointmentOptional.orElseThrow(AppointmentNotFoundException::new);
        Person person = personService.getPerson(registrationDto.getPersonId());

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

