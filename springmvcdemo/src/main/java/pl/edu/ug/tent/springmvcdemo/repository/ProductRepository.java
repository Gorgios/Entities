package pl.edu.ug.tent.springmvcdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
