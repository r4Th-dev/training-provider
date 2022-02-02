package de.r4thdev.trainingprovider.v1.api;

import de.r4thdev.trainingprovider.v1.api.dto.TrainerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(path = "/api/v1/trainers", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public interface TrainerApi {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<TrainerDto> getTrainers();

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    TrainerDto addTrainer(
            @RequestBody @Valid TrainerDto trainerDto);
}
