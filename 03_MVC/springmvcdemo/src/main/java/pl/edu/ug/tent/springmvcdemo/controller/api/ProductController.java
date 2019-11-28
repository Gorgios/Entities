package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.service.CustomerService;
import pl.edu.ug.tent.springmvcdemo.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService ps;
    @Autowired
    private CustomerService cs;

    @GetMapping("/api/product")
    public List<Product> getProducts(){
        return ps.findAllProducts();
    }
    @PostMapping("/api/product")
    public Product addProduct(@RequestBody Product product){
         ps.addProduct(product);
         return product;
    }
    @GetMapping("/api/product/{id}")
    public Product getProductById(@PathVariable Integer id){
        return ps.findById(id);
    }
    @DeleteMapping("/api/product/{id}")
    void deletePerson(@PathVariable Integer id) {
        ps.removeProduct(id);
    }
    @DeleteMapping("/api/product/deleteExpired")
    void deletePerson() {
        ps.removeExpiredItems();
    }
    @PutMapping("/api/prduct/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody  Product product){
        ps.updateProduct(product);
        return ps.findById(id);
    }
    @GetMapping("/api/productsWorth")
    public Double worthOfProducts(){
        return ps.getStorehouseWorth();
    }
    @GetMapping("/api/customer")
    public List<Product> getCustomerProducts(){
        return cs.findAllProducts();
    }
    @PostMapping("/api/customer")
    public Product buyProductCustomer(@RequestBody Product product){
        ps.buyProduct(product);
        cs.addProduct(product);
        return product;
    }
    @GetMapping("/api/customer/{id}")
    public Product getCustomerProductById(@PathVariable Integer id){
        return cs.findById(id);
    }

}
