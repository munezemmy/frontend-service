package com.microservice.shopingproductservice.controller;

import com.microservice.shopingproductservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import com.microservice.shopingproductservice.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private Environment environment;


    @GetMapping("/products/{id}")
    public Product getOneProduct(@PathVariable("id") long id) {
        Product product=productService.getProductById(id);
        product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return product ;
    }


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("products")
    public Product saveProduct(@RequestBody Product product) {

            return productService.saveProduct(product);
    }

    @GetMapping("/test")
    public String test(){
        return "hello this a test";
    }
}
