package ru.micro.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.micro.shop.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findById(int id);
}
