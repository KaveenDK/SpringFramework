package lk.ijse.edu.springtesting.repo;

import lk.ijse.edu.springtesting.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 8/1/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
