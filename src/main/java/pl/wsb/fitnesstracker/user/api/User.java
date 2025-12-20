package pl.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
/**
 * Represents a user of the FitnessTracker system.
 * <p>
 * This class is a JPA entity mapped to the {@code users} database table.
 * It contains basic personal data required to identify and manage a user
 * within the system.
 * <p>
 * Instances of this class are persisted in the database and should not be
 * exposed directly through the API. For API communication, {@link UserDto}
 * or other DTO classes should be used.
 */
public class User {

    /**
     * Unique identifier of the user.
     * <p>
     * This value is generated automatically by the database.
     * It is {@code null} for new users before they are persisted.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    /**
     * of the user
     */
    @Column
    private String firstName;

    /**
     * last name of the user
     */
    @Column
    private String lastName;


    /**
     * Birth date of the user.
     * <p>
     * This field is mandatory and cannot be {@code null}.
     */
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    /**
     * Email address of the user.
     * <p>
     * The email must be unique across all users and is required.
     * It can be used to identify and search for a user.
     */
    @Column(nullable = false, unique = true)
    private String email;


    /**
     * Creates a new {@link User} instance.
     * <p>
     * This constructor should be used when creating a new user
     * before persisting it in the database.
     * The {@code id} is not provided here, as it is generated automatically.
     *
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param birthdate birth date of the user
     * @param email unique email address of the user
     */

    public User(
            final String firstName,
            final String lastName,
            final LocalDate birthdate,
            final String email) {

        this.birthdate = birthdate;
        this.email = email;
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

