package ru.micro.shop.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.micro.shop.dto.InventoryResponse;
import ru.micro.shop.dto.OrderDto;
import ru.micro.shop.dto.OrderLineDto;
import ru.micro.shop.model.Order;
import ru.micro.shop.model.OrderLineItems;
import ru.micro.shop.repository.IOrderRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
@Transactional
public class OrderService implements  IOrderService{
    private final IOrderRepository _orderRepo;
    private final WebClient _webClient;
    @Override
    public void createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
       List<OrderLineItems> orderLineItems = orderDto.getOrderLineDtoItems().stream().map(this::mapToDto).toList();
        order.setOrderLineItems(orderLineItems);

        List<String> codes = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();
        InventoryResponse[] result = _webClient.get()
                .uri("http://localhost:8082/api/v1/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", codes).build())
                .retrieve().bodyToMono(InventoryResponse[].class).block();

        boolean allResult = Arrays.stream(result).allMatch(InventoryResponse::isInStock);
        if(allResult == true){
            _orderRepo.save(order);
        }
        else {
            throw new IllegalArgumentException("product not found");
        }
    }

    private OrderLineItems mapToDto(OrderLineDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        return  orderLineItems;
    }
}
