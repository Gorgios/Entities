package pl.edu.ug.tent.springmvcdemo.service;

import pl.edu.ug.tent.springmvcdemo.domain.Product;

import java.util.List;

public interface ProductService {
    Product findById(Integer id);
    List<Product> findAllProducts();
    List<Product> findByPrice(Double price);
    void addProduct(Product product);
    void removeProduct(Integer id);
    void updateProduct(Product product);
    Double getStorehouseWorth();
    void removeExpiredItems();
    void buyProduct(Product product);
    boolean checkQuant(Product p);
}
