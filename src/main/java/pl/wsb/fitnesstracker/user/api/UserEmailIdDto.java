package pl.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;

/**
 * Record consisting of user id and it's email
 */
public record UserEmailIdDto(@Nullable Long id, String email){}
