package com.cigma.rest.service;
import com.cigma.rest.modes.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    private static List<Product> productRepo = new ArrayList<>();
    static {
        productRepo.add(new Product("Maroc " , 1L )) ;
        productRepo.add(new Product("Algérie " , 2L )) ;
        productRepo.add(new Product("Cameron", 3L )) ;
        productRepo.add(new Product("Egypt", 4L )) ;
        productRepo.add(new Product("Nigeria", 5L )) ;
        productRepo.add(new Product("Senegal", 6L )) ;
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepo;
    }
    @Override
    public Optional<Product> getProductById(Long id) {
      return   productRepo.stream().filter(product -> product.getId().equals(id)).findFirst();
    }
    @Override
    public void createProduct(Product product) {
        productRepo.add(product);
    }
    // Pour updateProduct : il faut trouver l'ancien produit par id + supprimer l'ancien + ajouter le nouveau Champs
    // Ajouter le nouveau a la liste du Products

    @Override
    public void updateProduct(Long id, Product product) {
       Optional<Product> oldproduct = getProductById(id) ;
       if(oldproduct.isPresent()) {
           productRepo.remove(oldproduct.get());
           product.setId(id);
           productRepo.add(product);
       }
    }
    @Override
    public void deleteProduct(Long id) {
        getProductById(id).ifPresent(productRepo::remove);
    }
}
