package com.mybooking.demo.repository.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mybooking.demo.model.nosql.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

}
