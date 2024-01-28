package com.inv.inventory.controller;

import com.inv.inventory.service.IInventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@AllArgsConstructor
public class InventoryController {
    private  final IInventoryService _serviceInv;
    @GetMapping("/getInv/{code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("code") String code){
        return _serviceInv.isInStock(code);
    }
}
