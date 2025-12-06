package pl.wsb.fitnesstracker.user.api;

import pl.wsb.fitnesstracker.exception.api.NotFoundException;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Exception indicating that the {@link User} was not found.
 */
@SuppressWarnings("squid:S110")
public class UserNotFoundException extends NotFoundException {

    private UserNotFoundException(Long message) {
        super(message);
    }
    private id

    public UserNotFoundException(Long id) {
        this("User with ID=%s was not found".formatted(id));
    }

    public UserNotFoundException(String email) {
        this("User with email=%s was not found".formatted(email));
    }

    public UserNotFoundException(String firstName, String lastName) {
        this("User with name %s %s was not found".formatted(firstName, lastName));
    }

}
