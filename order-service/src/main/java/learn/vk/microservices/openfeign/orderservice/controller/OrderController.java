package learn.vk.microservices.openfeign.orderservice.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import learn.vk.microservices.openfeign.orderservice.dto.Message;
import learn.vk.microservices.openfeign.orderservice.dto.OrderDto;
import learn.vk.microservices.openfeign.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@OpenAPIDefinition(info = @Info(title = "Order Api"))
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @Operation(summary = "Get all orders")
    public List<OrderDto> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by id")
    @Parameters(@Parameter(name = "id", description = "order id"))
    public OrderDto getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping
    public Message createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }
}
