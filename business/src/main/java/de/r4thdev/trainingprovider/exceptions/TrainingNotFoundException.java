package de.r4thdev.trainingprovider.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Training not found")
public class TrainingNotFoundException extends Exception {
}
