package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.ug.tent.springmvcdemo.domain.ProductCategory;
import pl.edu.ug.tent.springmvcdemo.domain.Shop;
import pl.edu.ug.tent.springmvcdemo.service.ProductCategoryService;
import pl.edu.ug.tent.springmvcdemo.service.ProductService;
import pl.edu.ug.tent.springmvcdemo.service.ShopService;

@Controller
public class ProductCategoryMVCController {

    private ProductService productService;
    private ProductCategoryService productCategoryService;
    private ShopService shopService;

    @Autowired
    public ProductCategoryMVCController(ProductService productService, ProductCategoryService productCategoryService, ShopService shopService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.shopService = shopService;
    }
    @GetMapping("/categories")
    public String home(Model model) {
        model.addAttribute("categories", productCategoryService.findAll());
        return "categories";
    }
    @GetMapping("/addCategory")
    public String addCategory(Model model){
        ProductCategory pc = new ProductCategory();
        model.addAttribute("category",pc);
        return "add-category";
    }
    @GetMapping("/updateCategory/{id}")
    public String updateCategory(@PathVariable("id") Long id, Model model){
        ProductCategory pc = productCategoryService.findById(id);
        model.addAttribute("category",pc);
        return "add-category";
    }
    @PostMapping("/category/save")
    public String save(@ModelAttribute("category") ProductCategory pc){
        productCategoryService.save(pc);
        return  "redirect:/categories";
    }
    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        productCategoryService.delete(id);
        return "redirect:/categories";
    }


}
