package ru.micro.ShowMicro.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.micro.ShowMicro.dto.ProductDto;
import ru.micro.ShowMicro.model.Product;
import ru.micro.ShowMicro.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProdcutController {
    private final IProductService _productService;
    @PostMapping("/createProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDto productDto){
        _productService.createProduct(productDto);
    }
    @GetMapping("/getAllProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getAllProduct(){
        return _productService.AllProdcut();
    }
    @PutMapping("/updateProduct")
    @ResponseStatus(HttpStatus.OK)
    public void UpdateProduct(@RequestBody ProductDto productDto){
        _productService.updateProduct(productDto);
    }
    @GetMapping("/getOne/{id}")
    public Product getSingle(int id){
        return _productService.getProduct(id);
    }
    @DeleteMapping("deleteProduct/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(int id){
        _productService.deleteProduct(id);
    }

}
