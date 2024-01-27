package ru.micro.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.micro.order.dto.OrderDto;
import ru.micro.order.service.IOrderService;

@RestController
@RequestMapping("api/v1/order")
@AllArgsConstructor
public class OrderController {
    private final IOrderService _orderService;
    @PostMapping("/createOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderDto orderDto){
        _orderService.createOrder(orderDto);
        return "Заказ успешно создан";
    }
}
