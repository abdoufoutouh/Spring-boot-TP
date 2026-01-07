package com.cigma.rest.service;
import com.cigma.rest.modes.Product;

import java.awt.*;
import java.util.List;
import java.util.Optional;


public interface IProductService {


    List<Product>getAllProducts();
    Optional<Product> getProductById(Long id);
    void createProduct(Product product);
    void updateProduct(Long id , Product product );
    void deleteProduct(Long id);



}
