package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.service.ProductService;

import javax.validation.Valid;

@Controller("product")
public class ProductController {

    private ProductService ps;

    @Autowired
    public ProductController(ProductService ps){
        this.ps = ps;
    }

    @GetMapping("/product")
    public String home(Model model){
        model.addAttribute("products", ps.findAllProducts());
        return "product-all";
    }

    @GetMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model) {
        ps.removeProduct(id);
        model.addAttribute("products", ps.findAllProducts());
        return "product-all";
    }
    @GetMapping("/product/deleteExpired")
    public String deleteProduct( Model model) {
        ps.removeExpiredItems();
        model.addAttribute("products", ps.findAllProducts());
        return "product-all";
    }

    @PostMapping("/product/add")
    public String addProduct(@Valid Product product, Model model) {
        System.out.println(product);
        ps.addProduct(product);
        model.addAttribute("products", ps.findAllProducts());
        return "product-all";
    }
    @PostMapping("/product/update")
    public String updateConfirm(Product product, Model model){
        ps.updateProduct(product);
        model.addAttribute("products",ps.findAllProducts());
        return "product-all";
    }
    @GetMapping("/product/update/{id}")
    public String updateProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", ps.findById(id));
        return "product-update";
    }
    @GetMapping("/product/getWorth")
    public String getWorth(Model model){
        Double worth = ps.getStorehouseWorth();
        model.addAttribute("worth", worth);
        model.addAttribute("products",ps.findAllProducts());
        return "product-all";
    }

}