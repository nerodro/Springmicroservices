package com.inv.inventory.repository;

import com.inv.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IInvetoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByCode();
}
