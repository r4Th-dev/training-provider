package de.r4thdev.trainingprovider.mapper;

import de.r4thdev.trainingprovider.repositories.Trainer;
import de.r4thdev.trainingprovider.v1.api.dto.TrainerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrainerMapper {
    TrainerMapper INSTANCE = Mappers.getMapper(TrainerMapper.class);

    TrainerDto trainerToTrainerDto(Trainer trainer);

    Trainer trainerDtoToTrainer(TrainerDto trainerDto);
}
