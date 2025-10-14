package net.journalapp.journalapp.repository;

import net.journalapp.journalapp.entity.journalentry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalrepo extends MongoRepository<journalentry,Object> {





}
