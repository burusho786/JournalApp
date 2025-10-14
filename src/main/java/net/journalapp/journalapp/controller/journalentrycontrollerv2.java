package net.journalapp.journalapp.controller;


import net.journalapp.journalapp.entity.User;
import net.journalapp.journalapp.service.Userservice;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import net.journalapp.journalapp.entity.journalentry;
import net.journalapp.journalapp.service.journalentryservice;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class journalentrycontrollerv2 {




    @Autowired
    private  journalentryservice journalentryservice ;

    @Autowired
    private Userservice userservice;



    @GetMapping("{username}")
    public List<journalentry> getentriesofuser(@PathVariable String username){
        User user = userservice.findByusername(username);

        return user.getJournalentries();//getting the journal entries of the user
    };

    @PostMapping("{username}")
    public journalentry createentry(@RequestBody journalentry myentry,@PathVariable String username){
        //myentry is an instance of the journalentry class
        myentry.setDate(LocalDateTime.now());
        journalentryservice.saveentry(myentry,username);
        return myentry;
    }


    @GetMapping("id/{id}")
    public journalentry getjournalentrybyid(@PathVariable ObjectId id){
        return journalentryservice.findbyid( id).orElse(null);
    }

    @DeleteMapping("/id/{username}/{id}")
    public journalentry deletedata( @PathVariable String usernamae,@PathVariable String id){

         journalentryservice.deletebyid(id,usernamae);
         return null;
    }

    @PutMapping("/id/{username}/{myid}")
    public journalentry update(@PathVariable ObjectId myid,@RequestBody journalentry entry,@PathVariable String username){
        journalentry old =journalentryservice.findbyid(myid).orElse(null);
        if(old!=null){
            old.setTitle(entry.getTitle() !=null && !entry.getTitle().equals("")?entry.getTitle(): old.getTitle());
            old.setContent(entry.getTitle()!=null && !entry.getContent().equals("")?entry.getContent():old.getContent());
            journalentryservice.saveentry(old);

        }
       // journalentryservice.saveentry(old);

        return null;
    }








}
