package com.cigma.rest.controller;
import com.cigma.rest.modes.Product;
import com.cigma.rest.service.IProductService;
import com.cigma.rest.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
       return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return product;}

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return product;}

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Long id
            , @RequestBody Product product) {
        productService.updateProduct(id, product);}

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id ) {
        productService.deleteProduct(id);
    }



}