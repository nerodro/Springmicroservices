package ru.micro.shop.service;

import ru.micro.shop.dto.ProductDto;
import ru.micro.shop.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> AllProdcut();
    Product createProduct(ProductDto product);
    Product getProduct(int id);
    Product updateProduct(ProductDto product);
    void deleteProduct(int id);
}
