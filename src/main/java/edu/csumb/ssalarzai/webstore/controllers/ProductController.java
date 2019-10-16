package edu.csumb.ssalarzai.webstore.controllers;
import edu.csumb.ssalarzai.webstore.services.ProductService;
import edu.csumb.ssalarzai.webstore.models.Product;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductController{
    @Autowired
    ProductService productService;
    @RequestMapping(method = RequestMethod.GET, value = "/products/getAll")
    @ApiOperation(value = "Gets all products")
    public Iterable<Product> getAll()
    {
        return productService.getAllProducts();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/products/get/{id}")
    @ApiOperation(value = "Gets product by id")
    public Optional<Product> getProduct(String id){
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products/add")
    @ApiOperation(value = "add product")
    public void addProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
    }

}