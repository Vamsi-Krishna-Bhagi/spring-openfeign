package learn.vk.microservices.openfeign.productservice.repository;

import learn.vk.microservices.openfeign.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
