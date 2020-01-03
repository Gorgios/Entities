package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.domain.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductServiceImpl implements ProductService{

    private static List<Product> products = new ArrayList<>();
    private static AtomicInteger idCounter = new AtomicInteger(0);

    public ProductServiceImpl(){
        Product cheese = new Product("Cheese",20.99,1.0,"2020-10-15",5);
        Product cola = new Product("Cola",2.99,0.5,"2021-12-15",10);
        Product beer = new Product("Zubr",3.2,0.5,"2020-10-15",20);
        addProduct(cheese);
        addProduct(cola);
        addProduct(beer);

    }

    @Override
    public void addProduct(Product product) {
        product.setId(idCounter.incrementAndGet());
        products.add(product);
    }

    @Override
    public Product findById(Integer id) {
        for (Product p: products)
            if (p.getId() == id)
                return p;
        return null;
    }

    @Override
    public List<Product> findAllProducts() {
        return products;
    }

    @Override
    public List<Product> findByPrice(Double price) {
        List<Product> productsWithPrize = new ArrayList<>();
        for (Product p: products)
            if (p.getPrice() == price)
                productsWithPrize.add(p);
        return productsWithPrize;
    }

    @Override
    public void removeProduct(Integer id) {
        products.remove(findById(id));
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println(product.getId());
        int id = getIndex(product);
        products.get(id).setName(product.getName());
        products.get(id).setPrice(product.getPrice());
        products.get(id).setWeight(product.getWeight());
        products.get(id).setExpiry_date(product.getExpiry_date());
        products.get(id).setQuantity(product.getQuantity());
    }

    @Override
    public Double getStorehouseWorth() {
        double worth=0.0;
        for (Product p: products)
            worth+=p.getPrice()*p.getQuantity();
        return worth;
    }

    @Override
    public void removeExpiredItems() {
        LocalDate date = LocalDate.now();
        products.removeIf(next -> date.compareTo(LocalDate.parse(next.getExpiry_date())) > 0);
    }

    @Override
    public void buyProduct(Product p) {
        Integer q1 = products.get(getIndex(p)).getQuantity();
        Integer q2 = p.getQuantity();
         products.get(getIndex(p)).setQuantity(q1-q2);

    }
    @Override
    public boolean checkQuant(Product p){
        Integer q1 = products.get(getIndex(p)).getQuantity();
        Integer q2 = p.getQuantity();
        if (q1<q2)
            return false;
        return  true;
    }
    private int getIndex(Product p){
        for (int i=0; i<products.size();i++)
            if (p.getId() == products.get(i).getId())
                return  i;
        return -1;
    }
}
