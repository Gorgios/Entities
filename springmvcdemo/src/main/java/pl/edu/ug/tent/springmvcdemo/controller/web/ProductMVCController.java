package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.ProductCategory;
import pl.edu.ug.tent.springmvcdemo.service.ProductCategoryService;
import pl.edu.ug.tent.springmvcdemo.service.ProductService;
import pl.edu.ug.tent.springmvcdemo.service.ShopService;

@Controller
public class ProductMVCController {
    private ProductService productService;
    private ProductCategoryService productCategoryService;
    private ShopService shopService;

    @Autowired
    public ProductMVCController(ProductService productService, ProductCategoryService productCategoryService, ShopService shopService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.shopService = shopService;
    }
    @GetMapping("/products")
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }
    @GetMapping("/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        model.addAttribute("categories",productCategoryService.findAll());
        return "add-product";
    }
    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        model.addAttribute("categories",productCategoryService.findAll());
        return "add-product";
    }
    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product product){
        productService.save(product);
        return  "redirect:/products";
    }
    @GetMapping("/product/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        productService.delete(id);
        return "redirect:/products";
    }

}
