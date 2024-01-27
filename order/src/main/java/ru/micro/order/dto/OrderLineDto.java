package ru.micro.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDto {
    private Long id;
    private String code;
    private int price;
    private int quantity;
}
