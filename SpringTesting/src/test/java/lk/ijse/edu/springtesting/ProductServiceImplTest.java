package lk.ijse.edu.springtesting;

import lk.ijse.edu.springtesting.entity.Product;
import lk.ijse.edu.springtesting.repo.ProductRepository;
import lk.ijse.edu.springtesting.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 8/1/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        product = Product.builder().
                id(1L).
                name("Test Product").
                price(100.0).
                quantity(10).
                build();
    }

    @Test
    void shouldSaveProduct() {
        //arrange
        when(productRepository.save(any(Product.class))).thenReturn(product);

        //action
        Product saveProduct = productService.createProduct(product);

        //assert
        Assertions.assertNotNull(saveProduct);
        Assertions.assertEquals(product, saveProduct);
        Assertions.assertEquals(1L, saveProduct.getId());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void shouldUpdateProduct() {
        // Arrange
        Product updateProduct = Product.builder()
                .id(1L)
                .name("Updated Product")
                .price(150.0)
                .quantity(20)
                .build();
        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Action
        Product result = productService.updateProduct(updateProduct);

        // Assert
        Assertions.assertEquals("Updated Product", result.getName());
        Assertions.assertEquals(150.0, result.getPrice());
        Assertions.assertEquals(20, result.getQuantity());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void shouldDeleteProduct() {
        //Arrange
        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(product));

        //Action
        productService.deleteProduct(1L);

        //Assert
        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).delete(product);
    }
}
