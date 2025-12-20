package pl.wsb.fitnesstracker.user.api;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface UserService {

    /**
     * Creates a new user.
     *
     * @param user The user to be created
     * @return The created user
     */
    User createUser(User user);

    /**
     * Creates a new user.
     *
     * @param id - id of a user which shall be deleted
     */
    void deleteUser(int id);

    /**
     * Updates user which given id with data provided in User object
     *
     * @param id - id of a user which shall be updated
     * @param user - updated user data
     */
    void updateUser(int id, User user);
}
