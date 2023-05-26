package com.carsharing.validators;

import com.carsharing.exceptions.NotFoundException;
import com.carsharing.exceptions.ValidationException;
import com.carsharing.models.Admin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminValidator {
    public void validate(Admin admin, List<Admin> admins) {
        if (isFirstNameInvalid(admin)) {
            throw new ValidationException("First name is invalid");
        } else if (isLastNameInvalid(admin)) {
            throw new ValidationException("Last name is invalid");
        } else if (isInvalidEmail(admin.getEmail())) {
            throw new ValidationException("E-mail is invalid");
        } else if (isEmailAlreadyInUse(admin.getEmail(), admins)) {
            throw new ValidationException("E-mail is already in use");
        } else if (isLastPasswordInvalid(admin)) {
            throw new ValidationException("Password is invalid");
        }
    }

    public void validate(long id, List<Admin> admins) {
        List<Long> ids = new ArrayList<>();

        for (Admin admin : admins) {
            ids.add(admin.getId());
        }

        if (!ids.contains(id)) {
            throw new NotFoundException("Admin not found");
        }
    }

    public void validate(String email, List<Admin> admins) {
        if (isInvalidEmail(email)) {
            throw new ValidationException("E-mail is invalid");
        } else if (isEmailAlreadyInUse(email, admins)) {
            throw new ValidationException("E-mail is already in use");
        }
    }

    private static boolean isFirstNameInvalid(Admin admin) {
        return admin.getFirstName() == null
            || admin.getFirstName().isBlank();
    }

    private static boolean isLastNameInvalid(Admin admin) {
        return admin.getLastName() == null
            || admin.getLastName().isBlank();
    }

    private boolean isInvalidEmail(String email) {
        return email == null
            || email.isBlank()
            || email.startsWith("@")
            || !email.endsWith("@carsharing.com");
    }

    private boolean isEmailAlreadyInUse(String email, List<Admin> admins) {
        List<String> emails = new ArrayList<>();

        for (Admin admin : admins) {
            emails.add(admin.getEmail());
        }

        return emails.contains(email);
    }

    private static boolean isLastPasswordInvalid(Admin admin) {
        return admin.getPassword() == null
            || admin.getPassword().length == 0;
    }
}
