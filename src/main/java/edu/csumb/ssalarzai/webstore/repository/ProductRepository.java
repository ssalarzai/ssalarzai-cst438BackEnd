package edu.csumb.ssalarzai.webstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ssalarzai.csumb.edu.springProject.models.Product;

public interface ProductRepository extends MongoRepository<Product, String>
{

}