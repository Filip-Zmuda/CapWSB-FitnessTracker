package pl.wsb.fitnesstracker.user.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;

import java.time.LocalDate;


/**
 * Data Transfer Object representing user details exchanged through the API.
 * <p>
 * This DTO is used as both request and response body for user-related endpoints.
 * It contains full user information intended for external communication and
 * should not be confused with the {@link User} entity, which represents
 * the persisted database state.
 */
public record UserDto(
        /**
         * Unique identifier of the user.
         * <p>
         * This value is {@code null} when a new user is being created and is
         * generated automatically by the database upon persistence.
         */
        @Nullable Long id,

        /**
         * First name of the user.
         */
        String firstName,

        /**
         * Last name of the user.
         */
        String lastName,

        /**
         * Birth date of the user.
         * <p>
         * The date is serialized and deserialized using the {@code yyyy-MM-dd} format.
         */
        @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,

        /**
         * Email address of the user.
         * <p>
         * The email is expected to be unique and can be used to identify the user.
         */
        String email

) {}
