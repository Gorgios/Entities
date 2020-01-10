package pl.edu.ug.tent.springmvcdemo.service;

import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> findAll();
    ProductCategory findById(Long id);
    ProductCategory add (ProductCategory productCategory);
    void save(ProductCategory productCategory);
    String update(ProductCategory productCategory, Long id);
    String delete(Long id);
    List<Product> findAllProducts(Long productCategoryId);
}
