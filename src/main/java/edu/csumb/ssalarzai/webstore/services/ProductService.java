package edu.csumb.ssalarzai.webstore.services;

import edu.csumb.ssalarzai.webstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.spi.NoAutoStart;

@Service

public class ProductService{
    @Autowired
    ProductRepository productRepository;
}