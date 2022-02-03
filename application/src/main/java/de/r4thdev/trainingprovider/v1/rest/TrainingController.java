package de.r4thdev.trainingprovider.v1.rest;

import de.r4thdev.trainingprovider.services.TrainingService;
import de.r4thdev.trainingprovider.v1.api.TrainingApi;
import de.r4thdev.trainingprovider.v1.api.dto.TrainingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class TrainingController implements TrainingApi {

    @Autowired
    TrainingService trainingService;

    @Override
    public List<TrainingDto> getTrainings() {
        return trainingService.getTrainingDtos();
    }

    @Override
    public TrainingDto getTraining(UUID id) {
        return trainingService.getTrainingDto(id);
    }

    @Override
    public TrainingDto addTraining(TrainingDto trainingDto) {
        return trainingService.createTraining(trainingDto);
    }

    @Override
    public TrainingDto editTraining(TrainingDto trainingDto) {
        if (trainingDto.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the id must not be null");
        return trainingService.editTraining(trainingDto);
    }

    @Override
    public void deleteTraining(UUID id) {
        trainingService.deleteTraining(id);
    }
}
