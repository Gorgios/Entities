package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.ProductCategory;
import pl.edu.ug.tent.springmvcdemo.domain.Shop;
import pl.edu.ug.tent.springmvcdemo.service.ProductCategoryService;
import pl.edu.ug.tent.springmvcdemo.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    private ProductService ps;
    private ProductCategoryService pcs;

    @Autowired
    public ProductController(ProductService ps, ProductCategoryService pcs) {
        this.pcs = pcs;
        this.ps = ps;
    }

    @GetMapping("/api/product")
    public List<Product> getAllProducts() {
        return ps.findAll();
    }

    @GetMapping("/api/product/{id}")
    public Product getProductById(@PathVariable Long id) {
        return ps.findById(id);
    }
    @GetMapping("/api/product/{id}/shops")
    public List<Shop> findAllShops(@PathVariable Long id){
        return ps.findAllShops(id);
    }

    @PostMapping("/api/product")
    public Product addProduct(@Valid @RequestBody Product product,@RequestParam Long categoryId) {
        ProductCategory pc = pcs.findById(categoryId);
        product.setProductCategory(pc);
        return ps.add(product);
    }

    @PutMapping("/api/product/{id}")
    public String updateProduct(@Valid @RequestBody Product product,
                                        @PathVariable Long id) {
        return ps.update(product, id);
    }

    @DeleteMapping("/api/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return ps.delete(id);
    }
}
