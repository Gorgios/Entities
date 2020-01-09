package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.domain.Address;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.Shop;
import pl.edu.ug.tent.springmvcdemo.repository.AddressRepository;
import pl.edu.ug.tent.springmvcdemo.repository.ShopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private ShopRepository sr;
    private AddressRepository ar;

    @Autowired
    public ShopServiceImpl(ShopRepository sr, AddressRepository ar) {
        this.sr = sr;
        this.ar = ar;
    }


    @Override
    public List<Shop> findAll() {
        return (List<Shop>) sr.findAll();
    }

    @Override
    public Shop findById(Long id) {
        return sr.findById(id).orElse(null);
    }

    @Override
    public Shop add(Shop shop) {
        Shop s = new Shop();
        s.setName(shop.getName());
        return sr.save(s);
    }

    @Override
    public String update(Shop shop, Long id) {
        Shop s = findById(id);
        if (s != null) {
            s.setAddress(shop.getAddress());
            s.setName(shop.getName());
            s.setProducts(shop.getProducts());
            sr.save(s);
            return "Successfully updated shop";
        }
        return "Shop with that Id not exist";
    }

    @Override
    public void save(Shop shop) {
        sr.save(shop);
    }

    @Override
    public String delete(Long id) {
        if (findById(id) != null) {
            sr.deleteById(id);
            return "Successfully deleted shop c";
        }
        return "Shop  with this Id not exists";
    }

    @Override
    public List<Product> findAllProducts(Long id) {
        Shop shop = findById(id);
        return shop.getProducts();
    }


    @Override
    public Shop findByAddress(Long id) {
        Address address = ar.findById(id).orElse(null);
        if (address!= null)
            return sr.findByAddress(address);
        return null;
    }
}
