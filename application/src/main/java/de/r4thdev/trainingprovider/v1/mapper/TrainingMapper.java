package de.r4thdev.trainingprovider.v1.mapper;

import de.r4thdev.trainingprovider.repositories.Training;
import de.r4thdev.trainingprovider.v1.api.dto.TrainingDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrainingMapper {
    TrainingMapper INSTANCE = Mappers.getMapper(TrainingMapper.class);

    TrainingDto trainingToTrainingDto(Training training);

    Training trainingDtoToTraining(TrainingDto training);
}
