package com.mybooking.demo.repository.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mybooking.demo.model.nosql.FirstCollection;

@Repository
public interface FirstCollectionRepository extends MongoRepository<FirstCollection, String> {

}
