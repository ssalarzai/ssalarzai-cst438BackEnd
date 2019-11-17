package edu.csumb.ssalarzai.webstore.services;

import edu.csumb.ssalarzai.webstore.models.User;
import edu.csumb.ssalarzai.webstore.repository.UserRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Optional;

@Service
public class UserService {
@Autowired
ProductService productService;
@Autowired
UserRepository userRepository;

public Boolean addUser(User user)
    {
    return userRepository.insertIfExist(user);

    }
    public Iterable<User> getAllUsers()

    {
        return(userRepository.findAll());
    }

    public void addItem(String email, String product_id, Integer quantity){
        User user = userRepository.findById(email).get();
        user.addItem(product_id, quantity);
        userRepository.save(user);
    }

    public void updateProduct(String email, String product_id, Integer quantity){
        User user = userRepository.findById(email).get();
        user.updateCart(product_id, quantity);
        userRepository.save(user);
    }

    public void checkCredentials(String email, String password){
        User user = userRepository.findById(email).get();
        user.authUsername(email, password);
//        userRepository.save(user);
    }

    public Boolean checkout(String email){
        User tempU = userRepository.findById(email).get();
        HashMap<String, Integer> map = tempU.checkout();

        for(String id : map.keySet()){
            productService.updateProduct(id, map.get(id) * -1);
        }
        userRepository.deleteById(email);
        userRepository.insert(tempU);
                return true;
    }

}

