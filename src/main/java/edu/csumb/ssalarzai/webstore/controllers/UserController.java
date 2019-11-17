package edu.csumb.ssalarzai.webstore.controllers;


import edu.csumb.ssalarzai.webstore.models.User;
import edu.csumb.ssalarzai.webstore.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.POST, value = "/user/addUser")
    @ResponseBody
    public Boolean addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/getAllUsers")
    @ResponseBody
    public Iterable<User>getUsers()
    {
        return userService.getAllUsers();
    }

    //Adding item to cart
    @RequestMapping(method = RequestMethod.POST, value = "user/addItemToCart")
    @ResponseBody
    public void addItem(@RequestParam String email, String product_id, Integer quantity)
    {
       userService.addItem(email, product_id, quantity);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/user/updateProduct")
    @ResponseBody
    public void updateProduct(@RequestParam String email, String product_id, Integer quantity)
    {
        userService.updateProduct(email, product_id, quantity);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/checkCredentials")
    @ResponseBody
    public void checkCredentials(@RequestParam String email, String password)
    {
        userService.checkCredentials(email, password);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/checkout")
    @ResponseBody
    public void checkout(@RequestParam String email){
        userService.checkout(email);
    }

}
