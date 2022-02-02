package de.r4thdev.trainingprovider.v1.rest;

import de.r4thdev.trainingprovider.services.TrainingService;
import de.r4thdev.trainingprovider.v1.api.TrainingApi;
import de.r4thdev.trainingprovider.v1.api.dto.TrainingDto;
import de.r4thdev.trainingprovider.v1.mapper.TrainingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TrainingController implements TrainingApi {

    @Autowired
    TrainingService trainingService;

    TrainingMapper trainingMapper = TrainingMapper.INSTANCE;

    @Override
    public List<TrainingDto> getTrainings() {
        return trainingService.getTrainings()
                .stream()
                .map(trainingMapper::trainingToTrainingDto)
                .collect(Collectors.toList());
    }

    @Override
    public TrainingDto addTraining(TrainingDto trainingDto) {
        return null;
    }

    @Override
    public TrainingDto editTraining(TrainingDto trainingDto) {
        return null;
    }
}
