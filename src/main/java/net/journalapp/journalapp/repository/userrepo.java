package net.journalapp.journalapp.repository;


import net.journalapp.journalapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;





public interface userrepo extends MongoRepository<User, ObjectId> {

    User findByusername(String username);





}
