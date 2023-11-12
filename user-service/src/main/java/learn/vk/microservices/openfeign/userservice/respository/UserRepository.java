package learn.vk.microservices.openfeign.userservice.respository;

import learn.vk.microservices.openfeign.userservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
