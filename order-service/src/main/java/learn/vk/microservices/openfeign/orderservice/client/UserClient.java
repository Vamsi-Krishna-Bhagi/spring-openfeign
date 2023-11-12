package learn.vk.microservices.openfeign.orderservice.client;

import learn.vk.microservices.openfeign.orderservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${url.user-service}")
public interface UserClient {

    @GetMapping("/{id}")
    UserDto getUser(@PathVariable Long id);

}
