package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Shop;
import pl.edu.ug.tent.springmvcdemo.repository.ShopRepository;
import pl.edu.ug.tent.springmvcdemo.service.ProductCategoryService;
import pl.edu.ug.tent.springmvcdemo.service.ProductService;
import pl.edu.ug.tent.springmvcdemo.service.ShopService;

@Controller
public class HomeController {
  private ProductService productService;
  private ProductCategoryService productCategoryService;
  private ShopService shopService;

  @Autowired
  public HomeController(ProductService productService, ProductCategoryService productCategoryService, ShopService shopService) {
    this.productService = productService;
    this.productCategoryService = productCategoryService;
    this.shopService = shopService;
  }
  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("shops", shopService.findAll());
    return "home";
  }
  @GetMapping("/addShop")
  public String addShop(Model model){
    Shop shop = new Shop();
    model.addAttribute("products",productService.findAll());
    model.addAttribute("shop",shop);
    return "add-shop";
  }
  @GetMapping("/updateShop/{id}")
  public String updateShop(@PathVariable("id") Long id, Model model){
    Shop shop = shopService.findById(id);
    model.addAttribute("products",productService.findAll());
    model.addAttribute("shop",shop);
    return "add-shop";
  }
  @PostMapping("/save")
  public String save(@ModelAttribute ("shop") Shop shop){
    shopService.save(shop);
    return  "redirect:/";
  }
  @GetMapping("/delete/{id}")
  public String deleteShop(@PathVariable("id") Long id){
    shopService.delete(id);
    return "redirect:/";
  }

}
