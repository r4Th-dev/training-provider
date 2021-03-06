package de.r4thdev.trainingprovider.v1.api;

import de.r4thdev.trainingprovider.v1.api.dto.TrainingDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping(path = "/api/v1/trainings", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public interface TrainingApi {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<TrainingDto> getTrainings();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TrainingDto getTraining(
            @PathVariable UUID id
    );

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    TrainingDto addTraining(
            @RequestBody TrainingDto trainingDto);

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    TrainingDto editTraining(
            @RequestBody TrainingDto trainingDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteTraining(
            @PathVariable UUID id
    );
}
