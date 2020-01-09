package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Address;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.Shop;
import pl.edu.ug.tent.springmvcdemo.service.AddressService;
import pl.edu.ug.tent.springmvcdemo.service.ProductService;
import pl.edu.ug.tent.springmvcdemo.service.ShopService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ShopController {

    private ShopService ss;
    private ProductService ps;
    private AddressService as;

    @Autowired
    public ShopController(ShopService ss, ProductService ps, AddressService as) {
        this.ss = ss;
        this.ps = ps;
        this.as = as;
    }


    @GetMapping("/api/shop")
    public List<Shop> getAllShops() {
        return ss.findAll();
    }

    @GetMapping("/api/shop/{id}")
    public Shop getShopById(@PathVariable Long id) {
        return ss.findById(id);
    }
    @GetMapping("/api/shop/{id}/product")
    public List<Product> findAllProducts(@PathVariable Long id){
        return ss.findAllProducts(id);
    }
    @GetMapping("/api/shop/address/{id}")
    public Shop findByAddress(@PathVariable Long id){
        return ss.findByAddress(id);
    }
    @PostMapping("/api/shop")
    public Shop addShop(@Valid @RequestBody Shop shop) {
        return ss.add(shop);
    }
    @PostMapping("/api/shop/{id}/address")
    public String addAddressToShop(@Valid @RequestBody Address address, @PathVariable Long id){
        Address a = as.add(address);
        Shop s = ss.findById(id);
        if (s == null)
            return "Shop with that Id not exists";
        s.setAddress(a);
        return ss.update(s,id);
    }
    @PostMapping("/api/shop/{id}/existingaddress")
    public String addAddressToShop(@RequestParam Long address_id, @PathVariable Long id){
        Address a = as.findById(address_id);
        if (a== null)
            return "Address with that Id not exists";
        Shop s = ss.findById(id);
        if (s == null)
            return "Shop with that Id not exists";
        s.setAddress(a);
        return ss.update(s,id);
    }
    @PostMapping("/api/shop/{id}/product")
    public String addProductToShop(@Valid @RequestBody Product product, @PathVariable Long id){
        Product p = ps.add(product);
        Shop s = ss.findById(id);
        if (s == null)
            return "Shop with that Id not exists";
        s.getProducts().add(p);
        return ss.update(s,id);
    }
    @PostMapping("/api/shop/{id}/existingproduct")
    public String addExistingProductToShop(@RequestParam Long product_id, @PathVariable Long id){
        Product p = ps.findById(product_id);
        if (p== null)
            return "Product with that id not exist";
        Shop s = ss.findById(id);
        if (s == null)
            return "Shop with that Id not exists";
        s.getProducts().add(p);
        return ss.update(s,id);
    }

    @PutMapping("/api/shop/{id}")
    public String updateShop(@Valid @RequestBody Shop shop,
                                @PathVariable Long id) {
        return ss.update(shop, id);
    }

    @DeleteMapping("/api/shop/{id}")
    public String delteShop(@PathVariable Long id) {
        return ss.delete(id);
    }
}
