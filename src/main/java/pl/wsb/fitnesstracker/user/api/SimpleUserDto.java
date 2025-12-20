package pl.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;

/*
 * Simple Data Transfer Object consisting of id, name and surname
 * */
public record SimpleUserDto(@Nullable Long id, String firstName, String lastName) {
}
