package pl.edu.ug.tent.springmvcdemo.domain;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private Double price;
    private Double weight;
    private String expiry_date;
    private Integer quantity;

    public Product() {
    }

    public Product(String name, Double price, Double weight, String expiry_date,Integer quantity) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.expiry_date = expiry_date;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", expiry_date='" + expiry_date + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
