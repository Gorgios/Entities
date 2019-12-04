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
    @PutMapping("/api/product/")
    public Product updateProduct( @RequestBody  Product product){

        ps.updateProduct(product);
        return product;
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
    public String buyProductCustomer( @RequestBody Product product){
        if (!ps.checkQuant(product))
            return "Too many items you want to buy";
        if (!cs.checkWallet(product))
            return "You have not money for that purchase";
        ps.buyProduct(product);
        cs.addProduct(product);
        return "Succesfully bought product" ;
    }
    @GetMapping("/api/customer/{id}")
    public Product getCustomerProductById(@PathVariable Integer id){
        return cs.findById(id);
    }
    @GetMapping("/api/customer/getWallet")
    public String getWallet(){
        String wallet = Double.toString(cs.getWallet());
        return wallet;
    }

}
