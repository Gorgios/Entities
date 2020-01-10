package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.Shop;
import pl.edu.ug.tent.springmvcdemo.service.ProductCategoryService;
import pl.edu.ug.tent.springmvcdemo.service.ProductService;
import pl.edu.ug.tent.springmvcdemo.service.ShopService;

import java.util.List;

@Controller
public class ShopMVCController {
    private ProductService productService;
    private ProductCategoryService productCategoryService;
    private ShopService shopService;

    @Autowired
    public ShopMVCController(ProductService productService, ProductCategoryService productCategoryService, ShopService shopService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.shopService = shopService;
    }

    @GetMapping("/shop/{id}/goToProducts")
    public String showAllProductsOfShop(@PathVariable("id") Long id, Model model){
        model.addAttribute("products",shopService.findAllProducts(id));
        return "shop-products";
    }

}
