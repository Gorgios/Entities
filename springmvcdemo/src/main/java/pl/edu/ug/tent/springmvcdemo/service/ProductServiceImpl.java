package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.domain.Address;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.ProductCategory;
import pl.edu.ug.tent.springmvcdemo.domain.Shop;
import pl.edu.ug.tent.springmvcdemo.repository.ProductRepository;
import pl.edu.ug.tent.springmvcdemo.repository.ShopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository pr;
    private ShopRepository sr;

    @Autowired
    public ProductServiceImpl(ProductRepository pr, ShopRepository sr) {
        this.sr =sr;
        this.pr = pr;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) pr.findAll();
    }

    @Override
    public Product findById(Long id) {
        return pr.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        pr.save(product);
    }


    @Override
    public Product add(Product product) {
        Product p = new Product();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setProductCategory(product.getProductCategory());
        return pr.save(p);
    }

    @Override
    public String update(Product product, Long id) {
        Product p = findById(id);
        if (p != null) {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setProductCategory(product.getProductCategory());
            pr.save(p);
            return "Successfully updated product";
        }
        return "Product with selected Id not exists";
    }

    @Override
    public String delete(Long id) {

        Product p = pr.findById(id).orElse(null);
        for (Shop s: sr.findAll()){
            s.getProducts().removeIf(p2 -> p2.equals(p));
            sr.save(s);
        }
        p.setShopList(null);
        pr.save(p);
        if (findById(id) != null) {
            pr.deleteById(id);
            return "Successfully deleted product";
        }
        return "Product  with this Id not exists";
    }


    @Override
    public List<Shop> findAllShops(Long id) {
        Product product = findById(id);
        return product.getShopList();
    }
}
