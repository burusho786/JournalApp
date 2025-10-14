package net.journalapp.journalapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Getter
@Data
@Document
@NoArgsConstructor
public class journalentry {


    @Id
    private ObjectId id;
    private String content;
    private String title;
    private LocalDateTime date;




}
