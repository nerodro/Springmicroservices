package ru.micro.order.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.micro.order.dto.OrderDto;
import ru.micro.order.dto.OrderLineDto;
import ru.micro.order.model.Order;
import ru.micro.order.model.OrderLineItems;
import ru.micro.order.repository.IOrderRepository;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
@Transactional
public class OrderService implements  IOrderService{
    private final IOrderRepository _orderRepo;
    @Override
    public void createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
       List<OrderLineItems> orderLineItems = orderDto.getOrderLineDtoItems().stream().map(this::mapToDto).toList();
        order.setOrderLineItems(orderLineItems);
        _orderRepo.save(order);

    }

    private OrderLineItems mapToDto(OrderLineDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setCode(orderLineItemsDto.getCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        return  orderLineItems;
    }
}
