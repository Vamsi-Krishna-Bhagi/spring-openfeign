package learn.vk.microservices.openfeign.productservice.controller;

import learn.vk.microservices.openfeign.productservice.dto.Message;
import learn.vk.microservices.openfeign.productservice.dto.ProductDto;
import learn.vk.microservices.openfeign.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Message createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }
}
