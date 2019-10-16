package edu.csumb.ssalarzai.webstore.services;

import edu.csumb.ssalarzai.webstore.models.Product;
import edu.csumb.ssalarzai.webstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ProductService{
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getAllProducts()
    {
        return(productRepository.findAll());
    }

    public Optional<Product> getProduct(String id){
        return (productRepository.findById(id));
    }

    public void addProduct(Product product){
        productRepository.insert(product);
    }


}