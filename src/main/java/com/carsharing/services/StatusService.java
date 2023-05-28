package com.carsharing.services;

import com.carsharing.models.Status;
import com.carsharing.repositories.StatusRepository;
import com.carsharing.validators.StatusValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statusRepository;
    private final StatusValidator statusValidator;

    public StatusService(
        StatusRepository statusRepository,
        StatusValidator statusValidator
    ) {
        this.statusRepository = statusRepository;
        this.statusValidator = statusValidator;
    }

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public Status findById(long id) {
        statusValidator.validate(id, statusRepository.findAll());
        return statusRepository.findById(id).orElseThrow();
    }

    public Status save(Status status) {
        statusValidator.validate(status, statusRepository.findAll());
        statusRepository.save(status);
        return status;
    }

    public Status update(long id, Status status) {
        statusValidator.validate(id, statusRepository.findAll());
        statusValidator.validate(status, statusRepository.findAll());
        statusRepository.update(id, status);
        return status;
    }

    public void delete(long id) {
        statusValidator.validate(id, statusRepository.findAll());
        statusRepository.delete(id);
    }

    public Status findByName(String name) {
        statusValidator.validate(name, statusRepository.findAll());
        return statusRepository.findByName(name).orElseThrow();
    }
}
