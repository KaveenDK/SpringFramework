package lk.ijse.edu.springtesting.service.impl;

import lk.ijse.edu.springtesting.entity.Product;
import lk.ijse.edu.springtesting.repo.ProductRepository;
import lk.ijse.edu.springtesting.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product excpProduct = getProductById(product.getId());
        excpProduct.setName(product.getName());
        excpProduct.setPrice(product.getPrice());
        excpProduct.setQuantity(product.getQuantity());
        return productRepository.save(excpProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
