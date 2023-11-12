package learn.vk.microservices.openfeign.userservice.controller;

import learn.vk.microservices.openfeign.userservice.dto.Message;
import learn.vk.microservices.openfeign.userservice.dto.UserDto;
import learn.vk.microservices.openfeign.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Message createUser(@RequestBody UserDto userDto) {
        return userService.createuser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
