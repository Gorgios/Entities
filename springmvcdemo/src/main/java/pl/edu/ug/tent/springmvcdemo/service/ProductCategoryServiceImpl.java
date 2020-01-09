package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.ProductCategory;
import pl.edu.ug.tent.springmvcdemo.repository.ProductCategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryRepository pcr;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository pcr) {
        this.pcr = pcr;
    }

    @Override
    public List<ProductCategory> findAll() {
        return (List<ProductCategory>) pcr.findAll();
    }

    @Override
    public ProductCategory findById(Long id) {
        return pcr.findById(id).orElse(null);
    }

    @Override
    public ProductCategory add(ProductCategory productCategory) {
        ProductCategory p = new ProductCategory();
        p.setName(productCategory.getName());
        p.setProductList(productCategory.getProductList());
        return pcr.save(p);
    }

    @Override
    public String update(ProductCategory productCategory, Long id) {
        ProductCategory p = pcr.findById(id).orElse(null);
            if (p!=null) {
                p.setName(productCategory.getName());
                p.setProductList(productCategory.getProductList());
                pcr.save(p);
                return "Successfully updated product category";
            }
        return "Product Category with this Id not exists";
    }

    @Override
    public String delete(Long id) {
        if (findById(id) != null) {
            pcr.deleteById(id);
            return "Successfully deleted category";
        }
        return "Product Category with this Id not exists";
    }
    @Override
    public List<Product> findAllProducts(Long id) {
        ProductCategory pc = findById(id);
        return pc.getProductList();
    }
}
