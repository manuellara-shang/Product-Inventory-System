package com.pis.productinventorysystem.controller;

import com.pis.productinventorysystem.domain.entity.Product;
import com.pis.productinventorysystem.domain.entity.ProductRepository;
import com.pis.productinventorysystem.exception.ProductNotFoundException;
import com.pis.productinventorysystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('SCOPE_saveproduct')")
    public ResponseEntity<?> addProduct(@RequestBody Product product) throws Exception {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('SCOPE_updateproduct')")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws Exception {
        if(productService.findProductById(product.getId()).isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }
        return ResponseEntity.ok(productService.updateProduct(product));
    }
}
