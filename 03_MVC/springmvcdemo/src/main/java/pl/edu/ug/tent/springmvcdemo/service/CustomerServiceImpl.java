package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.domain.Customer;
import pl.edu.ug.tent.springmvcdemo.domain.Product;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static Customer customer;

    public CustomerServiceImpl(){
        customer = new Customer(100.0);
    }


    @Override
    public Product findById(Integer id) {
        for (Product p: customer.getCustomerProducts())
            if (p.getId() == id)
                return p;
        return null;
    }

    @Override
    public List<Product> findAllProducts() {
        return customer.getCustomerProducts();
    }

    @Override
    public void addProduct(Product product) {
        Double price = product.getQuantity()* product.getPrice();
        customer.setWallet(customer.getWallet()- price);

        int index;
        index = getIndex(product);
        if (index != -1){
            customer.getCustomerProducts().get(index).setQuantity(customer.getCustomerProducts().get(index).getQuantity() + product.getQuantity());
        }
        else{
            customer.getCustomerProducts().add(product);
        }
    }
    @Override
    public Double getWallet(){
        return customer.getWallet();
    }
    private int getIndex(Product p){
        for (int i=0; i<customer.getCustomerProducts().size();i++)
            if (p.getId() == customer.getCustomerProducts().get(i).getId())
                return  i;
        return -1;
    }
    @Override
    public boolean checkWallet(Product p){
        Double price = p.getQuantity()* p.getPrice();
        if (price > customer.getWallet())
            return false;
        return true;
    }
}
