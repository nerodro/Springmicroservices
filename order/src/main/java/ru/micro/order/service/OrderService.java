package ru.micro.order.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.micro.order.dto.OrderDto;
import ru.micro.order.dto.OrderLineDto;
import ru.micro.order.model.Order;
import ru.micro.order.model.OrderLineItems;
import ru.micro.order.repository.IOrderRepository;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor

public class OrderService implements  IOrderService{
    private final IOrderRepository _orderRepo;
    @Override
    public void createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
       List<OrderLineItems> orderLineItems = orderDto.getOrderLineItems().stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto)).toList();
        order.setOrderLineItems(orderLineItems);
        _orderRepo.save(order);

    }

    private OrderLineItems mapToDto(OrderLineDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setCode(orderLineItems.getCode());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setPrice(orderLineItems.getPrice());
        return  orderLineItems;
    }
}
