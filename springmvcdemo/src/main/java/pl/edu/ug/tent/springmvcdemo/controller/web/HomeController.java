package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Shop;
import pl.edu.ug.tent.springmvcdemo.repository.ShopRepository;
import pl.edu.ug.tent.springmvcdemo.service.ShopService;

@Controller
public class HomeController {
  private ShopRepository shopRepository;


  @Autowired
  public HomeController(ShopRepository shopRepository) {
    this.shopRepository = shopRepository;
  }

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("shops", shopRepository.findAll());
    return "home";
  }
  @GetMapping("/addShop")
  public String addShop(Model model){
    Shop shop = new Shop();
    model.addAttribute("shop",shop);
    return "add-shop";
  }
  @GetMapping("/updateShop/{id}")
  public String updateShop(@PathVariable("id") Long id, Model model){
    Shop shop = shopRepository.findById(id).orElse(null);
    model.addAttribute("shop",shop);
    return "add-shop";
  }
  @PostMapping("/save")
  public String save(@ModelAttribute ("shop") Shop shop){
    shopRepository.save(shop);
    return  "redirect:/";
  }
  @DeleteMapping("/delete/{id}")
  public String deleteShop(@PathVariable("id") Long id){
    shopRepository.deleteById(id);
    return "redirect:/";
  }

}
