package ru.micro.ShowMicro.service;

import ru.micro.ShowMicro.dto.ProductDto;
import ru.micro.ShowMicro.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> AllProdcut();
    Product createProduct(ProductDto product);
    Product getProduct(int id);
    Product updateProduct(ProductDto product);
    void deleteProduct(int id);
}
