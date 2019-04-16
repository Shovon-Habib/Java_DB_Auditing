package com.example.demo;


import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DefaultController {
    
    @Autowired
    UserRepo repo;
    
    @GetMapping("/")
    public void save(){
        User user = new User();
        user.setName("user");
        user.setCity("city");
        repo.save(user);
    }
}
