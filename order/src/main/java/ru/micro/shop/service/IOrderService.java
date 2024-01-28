package ru.micro.shop.service;

import ru.micro.shop.dto.OrderDto;

public interface IOrderService {
    void createOrder(OrderDto orderDto);
}
