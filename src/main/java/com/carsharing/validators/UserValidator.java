package com.carsharing.validators;

import com.carsharing.exceptions.NotFoundException;
import com.carsharing.exceptions.ValidationException;
import com.carsharing.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {
    public void validate(User user, List<User> users) {
        if (isFirstNameInvalid(user)) {
            throw new ValidationException("First name is invalid");
        } else if (isLastNameInvalid(user)) {
            throw new ValidationException("Last name is invalid");
        } else if (isInValidEmail(user.getEmail())) {
            throw new ValidationException("E-mail is invalid");
        } else if (isEmailAlreadyInUse(user.getEmail(), users)) {
            throw new ValidationException("E-mail is already in use");
        } else if (isIdRoleInvalid(user)) {
            throw new ValidationException("Role is invalid");
        }
    }

    public void validate(Long id, List<User> users) {
        List<Long> ids = new ArrayList<>();

        for (User user : users) {
            ids.add(user.getId());
        }

        if (!ids.contains(id)) {
            throw new NotFoundException("User not found");
        }
    }

    private static boolean isFirstNameInvalid(User user) {
        return user.getFirstName() == null
                || user.getFirstName().isBlank();
    }

    private static boolean isLastNameInvalid(User user) {
        return user.getLastName() == null
                || user.getLastName().isBlank();
    }

    private boolean isInValidEmail(String email) {
        return email == null
                || email.isBlank()
                || email.startsWith("@")
                || !email.contains("@")
                || !email.endsWith(".com")
                || email.endsWith("@.com");
    }

    private boolean isEmailAlreadyInUse(String email, List<User> users) {
        List<String> emails = new ArrayList<>();

        for (User user : users) {
            emails.add(user.getEmail());
        }

        return emails.contains(email);
    }

    private static boolean isIdRoleInvalid(User user) {
        return user.getIdRole() == null
                || (user.getIdRole() != 1
                && user.getIdRole() != 2);
    }
}
