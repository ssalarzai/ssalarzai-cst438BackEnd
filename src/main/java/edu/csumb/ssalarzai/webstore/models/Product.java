package edu.csumb.ssalarzai.webstore.models;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

public class Product{

    String name;
    @ApiModelProperty(required = false, hidden = true)
    @Id
    String id;
    String description;
    String imageURL;
    Double price;
    Integer stock;

    public Product(){

    }

    public Product(String name, String id, String description, String imageURL, Double price, Integer stock) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


    public void updateStock(Integer stock){
     this.stock +=stock;
    }


} 
