package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.entities.Training;
import de.r4thdev.trainingprovider.exceptions.TrainingNotFoundException;
import de.r4thdev.trainingprovider.mapper.TrainingMapper;
import de.r4thdev.trainingprovider.repositories.TrainingRepository;
import de.r4thdev.trainingprovider.v1.api.dto.TrainingDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TrainingService {
    TrainingMapper trainingMapper = TrainingMapper.INSTANCE;

    @Autowired
    TrainingRepository trainingRepository;

    public List<TrainingDto> getTrainingDtos() {
        return this.getTrainings()
                .stream()
                .map(trainingMapper::trainingToTrainingDto)
                .collect(Collectors.toList());
    }

    protected List<Training> getTrainings() {
        return trainingRepository.findAll();
    }

    public TrainingDto getTrainingDto(UUID trainingId) {
        return trainingMapper.trainingToTrainingDto(this.getTraining(trainingId));
    }

    @SneakyThrows
    protected Training getTraining(UUID trainingId) {
        return trainingRepository.findById(trainingId).orElseThrow(TrainingNotFoundException::new);
    }

    public TrainingDto createTraining(TrainingDto trainingDto) {
        return trainingMapper.trainingToTrainingDto(
                this.createTraining(trainingMapper.trainingDtoToTraining(trainingDto)));
    }

    protected Training createTraining(Training training) {
        return trainingRepository.save(training);
    }


    public TrainingDto editTraining(TrainingDto trainingDto) {
        Training training = this.getTraining(trainingDto.getId());

        if (trainingDto.getName() != null) training.setName(trainingDto.getName());
        if (trainingDto.getDescription() != null) training.setName(trainingDto.getDescription());
        if (trainingDto.getCurrency() != null) training.setCurrency(trainingDto.getCurrency());
        if (trainingDto.getPrice() != null) training.setPrice(trainingDto.getPrice());

        return trainingMapper.trainingToTrainingDto(this.createTraining(training));
    }

    public void deleteTraining(UUID trainingId) {
        trainingRepository.deleteById(trainingId);
    }

    public void checkIfTrainingExist(UUID id) throws TrainingNotFoundException {
        trainingRepository.findById(id).orElseThrow(TrainingNotFoundException::new);
    }
}

