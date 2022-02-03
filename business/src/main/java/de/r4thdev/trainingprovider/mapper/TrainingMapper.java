package de.r4thdev.trainingprovider.mapper;

import de.r4thdev.trainingprovider.entities.Training;
import de.r4thdev.trainingprovider.v1.api.dto.TrainingDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrainingMapper {
    TrainingMapper INSTANCE = Mappers.getMapper(TrainingMapper.class);

    TrainingDto trainingToTrainingDto(Training training);

    Training trainingDtoToTraining(TrainingDto training);
}
