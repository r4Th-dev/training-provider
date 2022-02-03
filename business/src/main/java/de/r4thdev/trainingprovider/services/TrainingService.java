package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.mapper.TrainingMapper;
import de.r4thdev.trainingprovider.repositories.TrainingRepository;
import de.r4thdev.trainingprovider.v1.api.dto.TrainingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    TrainingMapper trainingMapper = TrainingMapper.INSTANCE;

    public List<TrainingDto> getTrainings() {
        return trainingRepository.findAll()
                .stream()
                .map(trainingMapper::trainingToTrainingDto)
                .collect(Collectors.toList());
    }

    public TrainingDto createTraining(TrainingDto trainingDto) {
        return trainingMapper.trainingToTrainingDto(
                trainingRepository.save(trainingMapper.trainingDtoToTraining(trainingDto)));
    }

    public void deleteTraining(UUID trainingId) {
        trainingRepository.deleteById(trainingId);
    }

}

