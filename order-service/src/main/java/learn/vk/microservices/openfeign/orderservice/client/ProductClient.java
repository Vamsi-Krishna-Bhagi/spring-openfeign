package learn.vk.microservices.openfeign.orderservice.client;

import learn.vk.microservices.openfeign.orderservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "product-service", url = "${url.product-service}")
public interface ProductClient {

    @GetMapping
    List<ProductDto> getProducts();

    @GetMapping("/{id}")
    ProductDto getProduct(@PathVariable Long id);
}
