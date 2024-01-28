package ru.micro.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineDto {
    private Long id;
    private String skuCode;
    private int price;
    private int quantity;
}
