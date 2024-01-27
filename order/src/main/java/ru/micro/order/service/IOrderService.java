package ru.micro.order.service;

import ru.micro.order.dto.OrderDto;
import ru.micro.order.model.Order;

public interface IOrderService {
    void createOrder(OrderDto orderDto);
}
