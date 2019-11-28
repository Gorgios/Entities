package pl.edu.ug.tent.springmvcdemo.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Double wallet;
    private List<Product> customerProducts;
    public Customer(Double wallet){
        this.wallet= wallet;
        customerProducts = new ArrayList<>();
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }

    public List<Product> getCustomerProducts() {
        return customerProducts;
    }

    public void setCustomerProducts(List<Product> customerProducts) {
        this.customerProducts = customerProducts;
    }
}
