package com.lucas.auth.controller;

import com.lucas.auth.domain.product.Product;
import com.lucas.auth.domain.product.ProductRequestDTO;
import com.lucas.auth.domain.product.ProductResponseDTO;
import com.lucas.auth.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<ProductResponseDTO> getAll() {
        List<ProductResponseDTO> productList = productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
        return productList;
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ProductResponseDTO saveProduct(@RequestBody @Valid ProductRequestDTO product) {
        Product productData = new Product(product);
        productRepository.save(productData);
        return new ProductResponseDTO(productData);
    }
}
