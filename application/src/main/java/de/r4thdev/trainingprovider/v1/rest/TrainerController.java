package de.r4thdev.trainingprovider.v1.rest;

import de.r4thdev.trainingprovider.v1.api.TrainerApi;
import de.r4thdev.trainingprovider.v1.api.dto.TrainerDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainerController implements TrainerApi {

    @Override
    public List<TrainerDto> getTrainers() {
        return null;
    }

    @Override
    public TrainerDto addTrainer(TrainerDto trainerDto) {
        return null;
    }
}
