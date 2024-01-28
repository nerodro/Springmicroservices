package ru.micro.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.micro.shop.model.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
