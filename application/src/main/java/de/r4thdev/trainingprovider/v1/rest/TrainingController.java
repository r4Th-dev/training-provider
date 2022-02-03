package de.r4thdev.trainingprovider.v1.rest;

import de.r4thdev.trainingprovider.services.TrainingService;
import de.r4thdev.trainingprovider.v1.api.TrainingApi;
import de.r4thdev.trainingprovider.v1.api.dto.TrainingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingController implements TrainingApi {

    @Autowired
    TrainingService trainingService;

    @Override
    public List<TrainingDto> getTrainings() {
        return trainingService.getTrainings();
    }

    @Override
    public TrainingDto addTraining(TrainingDto trainingDto) {
        return trainingService.createTraining(trainingDto);
    }

    @Override
    public TrainingDto editTraining(TrainingDto trainingDto) {
        return null;
    }
}
