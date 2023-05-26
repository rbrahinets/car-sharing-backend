package com.carsharing.validators;

import com.carsharing.exceptions.NotFoundException;
import com.carsharing.exceptions.ValidationException;
import com.carsharing.models.Status;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatusValidator {
    public void validate(Status status, List<Status> statuses) {
        if (isNameInvalid(status.getName())) {
            throw new ValidationException("Name is invalid");
        } else if (isNameAlreadyExist(status.getName(), statuses)) {
            throw new ValidationException("Name already exist");
        }
    }

    public void validate(long id, List<Status> statuses) {
        List<Long> ids = new ArrayList<>();

        for (Status status : statuses) {
            ids.add(status.getId());
        }

        if (!ids.contains(id)) {
            throw new NotFoundException("Status not found");
        }
    }

    public void validate(String name, List<Status> statuses) {
        if (!getNames(statuses).contains(name)) {
            throw new NotFoundException("Status not found");
        }
    }

    private static boolean isNameInvalid(String name) {
        return name == null
            || name.isBlank();
    }

    private boolean isNameAlreadyExist(String name, List<Status> statuses) {
        return getNames(statuses).contains(name);
    }

    private static List<String> getNames(List<Status> statuses) {
        List<String> names = new ArrayList<>();

        for (Status status : statuses) {
            names.add(status.getName());
        }
        return names;
    }
}
