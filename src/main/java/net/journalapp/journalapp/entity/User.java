package net.journalapp.journalapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document(collection = "user_entries")
@Data
public class User {


    @Id
    private ObjectId id;
    @Indexed(unique = true)//we have to set this property
    @NonNull
    private String username;
    @NonNull
    private String password;
    @DBRef
    private List<journalentry> journalentries=new ArrayList<>();
    //we made a link b/w the user and the journal entries entity so a reference to the jouranentries is saved here using dbref






}

//every user will have his own journal entries