package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.fitnesstracker.user.api.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.wsb.fitnesstracker.user.api.UserDto;



import java.util.List;

/**
 * UserController is responsible for handling HTTP requests related to user operations.
 * It provides endpoints for retrieving and creating users.
 */
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserServiceImpl userService;

    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/simple")
    public List<UserSimpleDto> getAllUsersSimple() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toSimpleDto)
                .toList();
    }

    @GetMapping("/details")
    public UserDto getUserDetails(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        // 1. Szukanie po ID
        if (id != null) {
            return userService.getUser(id)
                    .map(userMapper::toDto)
                    .orElseThrow(() -> new UserNotFoundException(id));
        }

        // 2. Szukanie po e-mailu
        if (email != null) {
            return userService.getUserByEmail(email)
                    .map(userMapper::toDto)
                    .orElseThrow(() -> new UserNotFoundException(email));
        }

        // 3. Szukanie po imieniu i nazwisku
        if (firstName != null && lastName != null) {
            return userService.findAllUsers().stream()
                    .filter(user -> firstName.equals(user.getFirstName())
                            && lastName.equals(user.getLastName()))
                    .findFirst()
                    .map(userMapper::toDto)
                    .orElseThrow(() -> new UserNotFoundException(firstName, lastName));
        }

        // 4. Nic nie podano
        throw new IllegalArgumentException(
                "You must provide at least one search parameter: id, email, or firstName & lastName");
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto userDto) {
        // 1. DTO (JSON z requesta) → encja User
        User userToCreate = userMapper.toEntity(userDto);

        // 2. Zapis do bazy
        User createdUser = userService.createUser(userToCreate);

        // 3. Encja z bazy → DTO do odpowiedzi
        return userMapper.toDto(createdUser);
    }
}

