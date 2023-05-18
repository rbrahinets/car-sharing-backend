package CarDav.validators;

import CarDav.exceptions.NotFoundException;
import CarDav.exceptions.ValidationException;
import CarDav.models.User;
import CarDav.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class UserValidatorTest {
    private UserValidator userValidator;

    @Mock
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        userValidator = new UserValidator();

        user = new User(
                1L,
                "John",
                "Smith",
                "test@email.com",
                1L
        );
    }

    @Test
    @DisplayName("User validated without exceptions")
    void user_validated_without_exceptions() {
        assertDoesNotThrow(
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because first name of user is null")
    void throw_validation_exception_because_first_name_of_user_is_null() {
        user.setFirstName(null);

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because first name of user is empty")
    void throw_validation_exception_because_first_name_of_user_is_empty() {
        user.setFirstName("");

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because last name of user is null")
    void throw_validation_exception_because_last_name_of_user_is_null() {
        user.setLastName(null);

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because last name of user is empty")
    void throw_validation_exception_because_last_name_of_user_is_empty() {
        user.setLastName("");

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }


    @Test
    @DisplayName("Throw ValidationException because email of user is null")
    void throw_validation_exception_because_email_of_user_is_null() {
        user.setEmail(null);

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because email of user is empty")
    void throw_validation_exception_because_email_of_user_is_empty() {
        user.setEmail("");

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because email of user starts with char '@'")
    void throw_validation_exception_because_email_of_user_starts_with_char_at() {
        user.setEmail("@email.com");

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because email of user not contains char '@'")
    void throw_validation_exception_because_email_of_user_not_contains_char_at() {
        user.setEmail("test.email.com");

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because email of user not ends '.com'")
    void throw_validation_exception_because_email_of_user_not_ends_dot_com() {
        user.setEmail("test@email");

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because email of user ends '@.com'")
    void throw_validation_exception_because_email_of_user_ends_char_at_and_dot_com() {
        user.setEmail("test@.com");

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because email of user already in use")
    void throw_validation_exception_because_email_of_user_already_in_use() {
        List<User> users = List.of(user);

        when(userRepository.findAll()).thenReturn(users);

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        users
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because id of role is null")
    void throw_validation_exception_because_first_id_of_role_is_empty() {
        user.setIdRole(null);

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Throw ValidationException because id of role is invalid")
    void throw_validation_exception_because_first_id_of_role_is_invalid() {
        user.setIdRole(0L);

        assertThrows(
                ValidationException.class,
                () -> userValidator.validate(
                        user,
                        List.of()
                )
        );
    }

    @Test
    @DisplayName("Id of user validated without exceptions")
    void id_of_user_validated_without_exceptions() {
        List<User> users = List.of(user);

        when(userRepository.findAll()).thenReturn(users);

        assertDoesNotThrow(() -> userValidator.validate(user.getId(), users));
    }

    @Test
    @DisplayName("Throw NotFoundException because id of user not found")
    void throw_not_found_exception_because_id_of_user_not_found() {
        assertThrows(
                NotFoundException.class,
                () -> userValidator.validate(0L, List.of())
        );
    }
}
