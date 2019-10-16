package edu.csumb.ssalarzai.webstore.repository;

import edu.csumb.ssalarzai.webstore.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>
{

}