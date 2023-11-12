package learn.vk.microservices.openfeign.productservice.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private double price;
}
