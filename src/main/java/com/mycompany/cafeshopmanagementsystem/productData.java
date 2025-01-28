/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cafeshopmanagementsystem;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class productData {

    private Integer id;
    private String productId;
    private String productName;
    private String type;
    private Integer stock;
    private Integer price;
    private String status;
    private String image;
    private Date date;
    private Integer quantity;

    public productData(Integer id, String productId, String productName, String type, Integer stock, Integer price, String status,String image, Date date) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.stock = stock;
        this.price = price;
        this.status = status;
        this.image = image;
        this.date = date;
    }
    
    public productData(Integer id, String productId, String productName, String type,
             Integer quantity, Integer price, String image, Date date){
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        
        this.price = price;
        this.image = image;
        this.date = date;
        this.quantity = quantity;
    }
    public void setQuantity(int Quantity){
        this.quantity=Quantity;
    }
     
    public Integer getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
    
    public String getType(){
        return type;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public Date getDate() {
        return date;
    }
    
    public Integer getQuantity(){
        return quantity;
    }
}
