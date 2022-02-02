package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.mapper.TrainerMapper;
import de.r4thdev.trainingprovider.repositories.Trainer;
import de.r4thdev.trainingprovider.repositories.TrainerRepository;
import de.r4thdev.trainingprovider.v1.api.dto.TrainerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    TrainerMapper trainerMapper = TrainerMapper.INSTANCE;

    public List<TrainerDto> getTrainers(){
        return trainerRepository.findAll()
                .stream()
                .map(trainerMapper::trainerToTrainerDto)
                .collect(Collectors.toList());
    }

    public TrainerDto createTrainer(TrainerDto trainerDto){
        Trainer trainer = trainerMapper.trainerDtoToTrainer(trainerDto);
        return trainerMapper.trainerToTrainerDto(
                trainerRepository.save(trainer));
    }

    public void deleteTrainer(UUID trainerId){
        trainerRepository.deleteById(trainerId);
    }
}

