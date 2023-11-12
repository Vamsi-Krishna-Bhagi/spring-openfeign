package learn.vk.microservices.openfeign.orderservice.repository;

import learn.vk.microservices.openfeign.orderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
