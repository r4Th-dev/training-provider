package de.r4thdev.trainingprovider.v1.rest;

import de.r4thdev.trainingprovider.services.TrainerService;
import de.r4thdev.trainingprovider.v1.api.TrainerApi;
import de.r4thdev.trainingprovider.v1.api.dto.TrainerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainerController implements TrainerApi {

    @Autowired
    TrainerService trainerService;

    @Override
    public List<TrainerDto> getTrainers() {
        return trainerService.getTrainers();
    }

    @Override
    public TrainerDto addTrainer(TrainerDto trainerDto) {
        return trainerService.createTrainer(trainerDto);
    }
}
