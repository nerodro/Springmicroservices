package ru.micro.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.micro.shop.dto.ProductDto;
import ru.micro.shop.model.Product;
import ru.micro.shop.repository.IProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository _productRepo;
    @Override
    public List<ProductDto> AllProdcut() {
        List<Product> products = _productRepo.findAll();
        return products.stream().map(this::mapProducts).toList();
    }

    private ProductDto mapProducts(Product product) {
        return ProductDto.builder().id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    @Override
    public Product createProduct(ProductDto product) {
        Product product1 = new Product();
        {
            product1.setName(product.getName());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());

        }
        return _productRepo.save(product1);
    }

    @Override
    public Product getProduct(int id) {
        return _productRepo.findById(id);
    }

    @Override
    public Product updateProduct(ProductDto product) {

        return _productRepo.save(Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build());
    }

    @Override
    public void deleteProduct(int id) {
        Product product = _productRepo.findById(id);
        _productRepo.delete(product);
    }
}
