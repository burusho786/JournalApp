package net.journalapp.journalapp.service;

import net.journalapp.journalapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import net.journalapp.journalapp.repository.userrepo;

@Component
public class Userservice {

    //crud appilaction service by mongodb

    @Autowired
  private userrepo userrepo;//since here we are using an interface ehich is not a bean but when used its instaces are used at runtime and its services are used



    public void saveentry(User userentry){
        userrepo.save(userentry);
    }
    public void saveUser(User user) {
        userrepo.save(user);
    }

    public List<User> getall() {
        return userrepo.findAll();
    }

    public Optional<User> findbyid(ObjectId id){//optional is a data type that there ma be data present or may be not
        return userrepo.findById(id);
    }

    public void deletebyid(ObjectId id){
        userrepo.deleteById(id);
    };

    public User findByusername(String username){
        return userrepo.findByusername(username);
    }

}

//controller => service =>repository extended inbuilt crud interface
