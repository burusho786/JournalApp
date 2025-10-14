package net.journalapp.journalapp.service;

import net.journalapp.journalapp.entity.User;
import net.journalapp.journalapp.entity.journalentry;
import net.journalapp.journalapp.repository.journalrepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Component
public class journalentryservice {

    //crud appilaction service by mongodb

    @Autowired
  private  journalrepo journalrepo;//since here we are using an interface ehich is not a bean but when used its instaces are used at runtime and its services are used

  @Autowired
  private Userservice userservice;

  @Transactional //atomoicity and isolation
    public void saveentry(journalentry journalentry,String username){
        User user = userservice.findByusername(username);//user name is saved
        journalentry saved = journalrepo.save(journalentry);
        user.getJournalentries().add(saved);
       //user.setUsername(null);
      // since we have set the user name to null but in ouver username us set to be unique so we will use the transactional anotation for atomicity
      userservice.saveentry(user);
    }
    public void saveentry(journalentry journalentry){
        journalrepo.save(journalentry);

    }

    public List<journalentry> getall() {
        return journalrepo.findAll();
    }

    public Optional<journalentry> findbyid(ObjectId id){//optional is a data type that there ma be data present or may be not
        return journalrepo.findById(id);
    }

    public void deletebyid(String id, String usernmae){
        User user = userservice.findByusername(usernmae);
        user.getJournalentries().removeIf(x -> x.getId().equals(id));//to remove the entries in the run time so that we have consistency in over code but on the next save the mongodb will save the changes
        userservice.saveentry(user);
        journalrepo.deleteById(id);
    };


}

//controller => service =>repository extended inbuilt crud interface
