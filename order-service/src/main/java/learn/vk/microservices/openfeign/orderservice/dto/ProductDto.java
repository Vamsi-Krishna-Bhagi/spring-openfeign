package learn.vk.microservices.openfeign.orderservice.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private double price;
}
