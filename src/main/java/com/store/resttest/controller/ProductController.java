package com.store.resttest.controller;

import com.store.resttest.ApiRequest;
import com.store.resttest.model.Root;
import com.store.resttest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    ApiRequest apiRequest;

    public ProductController(ProductRepository productRepository, ApiRequest apiRequest) {
        this.productRepository = productRepository;
        this.apiRequest = apiRequest;
    }

    //Hämta alla
    @GetMapping("/fetch/all")
    public ResponseEntity<List<Root>> fetchProducts() throws Exception {
        apiRequest.fetchAndSaveProducts();
        return ResponseEntity.ok().body(productRepository.findAll());
    }

    //TODO: För att hämta en produkt, uppdatera en produkt, skapa ny produkt, ta bort produkt ha service-klass och endpoints
}