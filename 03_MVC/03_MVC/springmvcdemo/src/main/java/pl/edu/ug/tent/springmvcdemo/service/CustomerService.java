package pl.edu.ug.tent.springmvcdemo.service;

import pl.edu.ug.tent.springmvcdemo.domain.Product;

import java.util.List;

public interface CustomerService {
    Product findById(Integer id);
    List<Product> findAllProducts();
    public void addProduct(Product product);
    Double getWallet();
    boolean checkWallet(Product p);

}
