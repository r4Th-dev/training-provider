package de.r4thdev.trainingprovider.services;

import de.r4thdev.trainingprovider.repositories.Training;
import de.r4thdev.trainingprovider.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }

}

