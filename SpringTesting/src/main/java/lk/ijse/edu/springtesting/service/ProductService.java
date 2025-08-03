package lk.ijse.edu.springtesting.service;

import lk.ijse.edu.springtesting.entity.Product;

import java.util.List;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 8/1/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
}
