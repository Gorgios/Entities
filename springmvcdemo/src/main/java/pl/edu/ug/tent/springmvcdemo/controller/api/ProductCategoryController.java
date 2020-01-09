package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.ProductCategory;
import pl.edu.ug.tent.springmvcdemo.service.ProductCategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductCategoryController {
    private ProductCategoryService pcs;

    @Autowired
    public ProductCategoryController(ProductCategoryService pcs) {
        this.pcs = pcs;
    }

    @GetMapping("/api/category")
    public List<ProductCategory> getAllCategories() {
        return pcs.findAll();
    }

    @GetMapping("/api/category/{id}")
    public ProductCategory getCategoryById(@PathVariable Long id) {
        return pcs.findById(id);
    }

    @GetMapping("/api/category/product/{id}")
    public List<Product> findAllByCategory(@PathVariable Long id){
        return pcs.findAllProducts(id);
    }

    @PostMapping("/api/category")
    public ProductCategory addProductCategory(@Valid @RequestBody ProductCategory productCategory) {
        return pcs.add(productCategory);
    }

    @PutMapping("/api/category/{id}")
    public String updateProductCategory(@Valid @RequestBody ProductCategory productCategory,
                                        @PathVariable Long id) {
        return pcs.update(productCategory, id);
    }

    @DeleteMapping("/api/category/{id}")
    public String delteProductCategory(@PathVariable Long id) {
        return pcs.delete(id);
    }

}
