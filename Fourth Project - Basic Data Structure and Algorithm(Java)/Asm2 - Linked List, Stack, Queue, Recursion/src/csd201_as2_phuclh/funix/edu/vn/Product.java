/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_phuclh.funix.edu.vn;

/**
 *
 * @author Le Hoang Phuc
 */
public class Product implements Comparable{
    
    //initialize attributes
    private String id;
    private String title;
    private int quantity;
    private double price;
    
    //getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    //default constructor
    public Product() {}
    
    //display a full information
    @Override
    public String toString() {
        return String.format("%-6s|%-15s|%-8s|%-10s", getId(), getTitle(), getQuantity(), getPrice());
    }
    
    //implements comparable to compare by ID
    public int compareTo(Object o) {
        return 0;
    }
}
