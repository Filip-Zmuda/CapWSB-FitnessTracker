package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserEmailIdDto;

import java.util.List;

import static java.time.LocalDate.now;

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

    @GetMapping("/email")
    public List<UserEmailIdDto> getUsersByEmail(String email){
        return userService.getUserByEmail(email)
                .stream()
                .map(userMapper::toUserEmailIdDto)
                .toList();
    }

    @GetMapping("older/{time}")
    public List<UserDto> getUsersOlderThan(int age){
        return userService.findUserOlderThan(now().minusYears(age))
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}

