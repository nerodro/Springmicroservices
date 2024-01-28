package com.inv.inventory.service;

import com.inv.inventory.repository.IInvetoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryService implements IInventoryService {
    private final IInvetoryRepository _repoInv;
    @Override
    @Transactional
    public boolean isInStock(String code) {
        return _repoInv.findByCode().isPresent();
    }
}
