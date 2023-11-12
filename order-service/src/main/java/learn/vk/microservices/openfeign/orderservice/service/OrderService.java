package learn.vk.microservices.openfeign.orderservice.service;

import learn.vk.microservices.openfeign.orderservice.client.ProductClient;
import learn.vk.microservices.openfeign.orderservice.client.UserClient;
import learn.vk.microservices.openfeign.orderservice.dto.Message;
import learn.vk.microservices.openfeign.orderservice.dto.OrderDto;
import learn.vk.microservices.openfeign.orderservice.dto.ProductDto;
import learn.vk.microservices.openfeign.orderservice.dto.UserDto;
import learn.vk.microservices.openfeign.orderservice.exception.NotFoundException;
import learn.vk.microservices.openfeign.orderservice.model.Orders;
import learn.vk.microservices.openfeign.orderservice.repository.OrderRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final ProductClient productClient;

    public OrderService(OrderRepository orderRepository, UserClient userClient, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
        this.productClient = productClient;
    }

    public Message createOrder(OrderDto orderDto) {
        UserDto userDto = userClient.getUser(orderDto.getUserId());
        log.info("UserDto: " + userDto);

        ProductDto productDto = productClient.getProduct(orderDto.getProductId());
        log.info("ProductDto: " + productDto);

        Orders orders = new Orders();
        BeanUtils.copyProperties(orderDto, orders);
        orders.setUserId(orders.getUserId());
        orders.setProductId(orders.getProductId());
        orderRepository.save(orders);
        return new Message("Order created successfully", Message.Status.SUCCESS);
    }

    public OrderDto getOrder(Long id) {
        Orders orders = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found"));
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orders, orderDto);

        return orderDto;
    }

    public List<OrderDto> getOrders() {
        List<Orders> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        orders.forEach(order -> {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(order, orderDto);
            orderDtos.add(orderDto);
        });
        return orderDtos;
    }
}
