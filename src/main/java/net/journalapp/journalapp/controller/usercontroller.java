package net.journalapp.journalapp.controller;


import net.journalapp.journalapp.entity.User;
import net.journalapp.journalapp.service.Userservice;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journaluser")
@Component
public class usercontroller {

@Autowired
private Userservice userservice;

@GetMapping
    public List<User> getallnames(){
    return userservice.getall();
}
@PostMapping
public void createuser(@RequestBody User username){
    userservice.saveentry(username);
}

@GetMapping("/name/name")
    public void getusername(@PathVariable ObjectId id){
    userservice.findbyid(id);
}

@PutMapping("/{username}")
    public User updateuser(@RequestBody User user,@PathVariable String username){
    User userindb = userservice.findByusername(username);
if(userindb!=null){
    userindb.setUsername(user.getUsername());
    userindb.setPassword(user.getPassword());
    userservice.saveentry(userindb);
}
return null;
}








}
