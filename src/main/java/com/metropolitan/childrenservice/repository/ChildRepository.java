package com.metropolitan.childrenservice.repository;

import com.metropolitan.childrenservice.models.Child;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChildRepository extends MongoRepository<Child,String> {
    List<Child> findByName(String name);
}
