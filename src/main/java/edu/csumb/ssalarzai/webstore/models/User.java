package edu.csumb.ssalarzai.webstore.models;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Vector;


public class User {


    @Id
    String email; // username
    String password;

    @ApiModelProperty(required = false, hidden = true)
    HashMap<String, Integer> cart = new HashMap<>();


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public User(){

    }

    public User(String email, String password)
    {
     this.email = email;
     this.password = password;
    }

    public HashMap<String, Integer> getCart()
    {
        return cart;
    }

    public void setCart(HashMap<String, Integer> cart)
    {
        this.cart = cart;
    }

    public void addItem(String itemId, Integer quantity) {
        if (quantity == 0) {
            return;
        }
        else {
            this.cart.put(itemId, quantity);
        }
    }

    public void authUsername(String email, String password)
    {
        if (this.email.equals(email) && this.password.equals(password))
        {
            System.out.println("Login Successful");
        }
        else{
            System.out.println("Bad Credentials");
        }
    }
    public void updateCart(String itemId, Integer quantity)
    {
        int quant = this.cart.get(itemId);

        if(quantity + quant <= 0)
        {
            this.cart.remove(itemId);
        }
        else
            {
            this.cart.put(itemId, quant+quantity);
        }
    }



    public HashMap<String, Integer> checkout()
    {
        HashMap<String, Integer> cartcopy = cart;
        cart = new HashMap<String, Integer>();
        return cartcopy;
    }


}
