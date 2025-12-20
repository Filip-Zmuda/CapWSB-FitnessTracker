package pl.wsb.fitnesstracker.user.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserProvider {

    /**
     * Retrieves a user based on their ID.
     * If the user with given ID is not found, then {@link Optional#empty()} will be returned.
     *
     * @param userId id of the user to be searched
     * @return An {@link Optional} containing the located user, or {@link Optional#empty()} if not found
     */
    Optional<User> getUser(Long userId);

    /**
     * Retrieves a user based on their email.
     * If the user with given email is not found, then {@link Optional#empty()} will be returned.
     *
     * @param email The email of the user to be searched
     * @return An {@link Optional} containing the located user, or {@link Optional#empty()} if not found
     */
    Optional<User> getUserByEmail(String email);

    /**
     * Retrieves a user based on their id.
     * If the user with given id is not found, then {@link Optional#empty()} will be returned.
     *
     * @param id The id of the user to be searched
     * @return An {@link Optional} containing the located user, or {@link Optional#empty()} if not found
     */
    Optional<User> getUserById(int id);
    /**
     * Retrieves all users.
     *
     * @return An {@link Optional} containing the all users data.
     */
    List<User> findAllUsers();

    /**
     * Retrieves all users data simple.
     *
     * @return list of {@link User} objects
     */
    List<User> findAllUsersSimple();

    List<User> findUserOlderThan(LocalDate birthdate);


}
