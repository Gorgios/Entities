package pl.edu.ug.tent.springmvcdemo.service;

import pl.edu.ug.tent.springmvcdemo.domain.Address;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> findAll();

    Shop findById(Long id);

    Shop add(Shop shop);

    String update(Shop shop, Long id);

    void save(Shop shop);

    String delete(Long id);

    List<Product> findAllProducts(Long id);

    Shop findByAddress(Long id);
}
