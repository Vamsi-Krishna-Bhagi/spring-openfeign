package learn.vk.microservices.openfeign.userservice.service;

import learn.vk.microservices.openfeign.userservice.dto.Message;
import learn.vk.microservices.openfeign.userservice.dto.UserDto;
import learn.vk.microservices.openfeign.userservice.exception.NotFoundException;
import learn.vk.microservices.openfeign.userservice.model.Users;
import learn.vk.microservices.openfeign.userservice.respository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Message createuser(UserDto userDto) {
        Users users = new Users();
        BeanUtils.copyProperties(userDto, users);
        userRepository.save(users);
        return new Message("Users created successfully", Message.Status.SUCCESS);
    }

    public UserDto getUser(Long id) {
        Users users = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Users not found"));
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(users, userDto);
        return userDto;
    }
}
