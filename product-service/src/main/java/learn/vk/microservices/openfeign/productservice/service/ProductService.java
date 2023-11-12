package learn.vk.microservices.openfeign.productservice.service;

import learn.vk.microservices.openfeign.productservice.dto.Message;
import learn.vk.microservices.openfeign.productservice.dto.ProductDto;
import learn.vk.microservices.openfeign.productservice.exception.NotFoundException;
import learn.vk.microservices.openfeign.productservice.model.Product;
import learn.vk.microservices.openfeign.productservice.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Message createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);

        return new Message("Product created successfully", Message.Status.SUCCESS);
    }

    public ProductDto getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(product -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            productDtos.add(productDto);
        });
        return productDtos;
    }
}
