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
        if (isFirstNameInvalid(admin.getFirstName())) {
            throw new ValidationException("First name is invalid");
        } else if (isLastNameInvalid(admin.getLastName())) {
            throw new ValidationException("Last name is invalid");
        } else if (isInvalidEmail(admin.getEmail())) {
            throw new ValidationException("E-mail is invalid");
        } else if (isEmailAlreadyInUse(admin.getEmail(), admins)) {
            throw new ValidationException("E-mail is already in use");
        } else if (isLastPasswordInvalid(admin.getPassword())) {
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
        if (!getEmails(admins).contains(email)) {
            throw new NotFoundException("Admin not found");
        }
    }

    private static boolean isFirstNameInvalid(String firstName) {
        return firstName == null
            || firstName.isBlank();
    }

    private static boolean isLastNameInvalid(String lastName) {
        return lastName == null
            || lastName.isBlank();
    }

    private boolean isInvalidEmail(String email) {
        return email == null
            || email.isBlank()
            || email.startsWith("@")
            || !email.endsWith("@carsharing.com");
    }

    private boolean isEmailAlreadyInUse(String email, List<Admin> admins) {
        return getEmails(admins).contains(email);
    }

    private static boolean isPasswordInvalid(char[] password) {
        return password == null
            || password.length == 0;
    }

    private static List<String> getEmails(List<Admin> admins) {
        List<String> emails = new ArrayList<>();

        for (Admin admin : admins) {
            emails.add(admin.getEmail());
        }

        return emails;
    }
}
