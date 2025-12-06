package pl.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;

public record UserEmailIdDto(@Nullable Long id, String email){}
