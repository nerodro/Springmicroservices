package ru.micro.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.micro.order.model.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
