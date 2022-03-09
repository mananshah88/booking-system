package com.mybooking.demo.repository.cache;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mybooking.demo.model.cache.FirstCache;

@Repository
public interface FirstCacheRepository extends CrudRepository<FirstCache, String> {

}
