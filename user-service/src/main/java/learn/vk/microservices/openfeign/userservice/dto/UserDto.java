package learn.vk.microservices.openfeign.userservice.dto;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;
}
