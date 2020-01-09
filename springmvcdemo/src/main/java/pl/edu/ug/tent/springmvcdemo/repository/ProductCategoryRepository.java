package pl.edu.ug.tent.springmvcdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory,Long> {
}
