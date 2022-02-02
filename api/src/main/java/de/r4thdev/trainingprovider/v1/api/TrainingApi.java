package de.r4thdev.trainingprovider.v1.api;

import de.r4thdev.trainingprovider.v1.api.dto.TrainingDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(path = "/api/v1/trainings", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public interface TrainingApi {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<TrainingDto> getTrainings();

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    TrainingDto addTraining(
            @RequestBody @Valid TrainingDto trainingDto);

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    TrainingDto editTraining(
            @RequestBody @Valid TrainingDto trainingDto);
}
