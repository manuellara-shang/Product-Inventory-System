package com.pis.productinventorysystem.service;

import com.pis.productinventorysystem.domain.entity.Product;
import com.pis.productinventorysystem.domain.entity.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        Product product1 = new Product();
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setType(product.getType());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        product1.setRequirements(product.getRequirements());
        return productRepository.saveAndFlush(product);
    }

    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    }
}
