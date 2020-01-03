package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.ug.tent.springmvcdemo.domain.Customer;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.service.CustomerService;
import pl.edu.ug.tent.springmvcdemo.service.ProductService;

@Controller("customer")
public class CustomerController {
    private ProductService ps;
    private CustomerService cs;

    @Autowired
    public CustomerController(ProductService ps, CustomerService cs){
        this.cs =cs;
        this.ps = ps;
    }

    @GetMapping("/customer")
    public String home(Model model){
        model.addAttribute("products", ps.findAllProducts());
        model.addAttribute("wallet",cs.getWallet());
        return "product-all-customer";
    }
    @GetMapping("/customer/buy/{id}")
    public String buy(Model model, @PathVariable Integer id) {
        model.addAttribute("product", ps.findById(id));
        return "product-buy";
    }

    @PostMapping("/customer/new")
    public String newProduct(Product product, Model model){
        String quantError = "We don't have that many items";
        String moneyError = "You don't have enough money";
        if(!ps.checkQuant(product)){
            model.addAttribute("products", ps.findAllProducts());
            model.addAttribute("wallet",cs.getWallet());
            model.addAttribute("quantError", quantError);
            return "product-all-customer";
        }
        if(!cs.checkWallet(product)) {
            model.addAttribute("products", ps.findAllProducts());
            model.addAttribute("wallet", cs.getWallet());
            model.addAttribute("moneyError", moneyError);
            return "product-all-customer";
        }
        ps.buyProduct(product);
        cs.addProduct(product);
        model.addAttribute("products", ps.findAllProducts());
        model.addAttribute("wallet",cs.getWallet());
        return "product-all-customer";
    }
    @GetMapping("/customer/products")
    public String customerProducts(Model model){
        model.addAttribute("products", cs.findAllProducts());
        model.addAttribute("wallet",cs.getWallet());
        return "customer-products";
    }

}
