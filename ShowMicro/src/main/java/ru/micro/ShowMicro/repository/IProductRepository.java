package ru.micro.ShowMicro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.micro.ShowMicro.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findById(int id);
}
