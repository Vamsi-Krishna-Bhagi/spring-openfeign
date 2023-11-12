package learn.vk.microservices.openfeign.orderservice.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private Long productId;
    private Long userId;
    private int quantity;
}
