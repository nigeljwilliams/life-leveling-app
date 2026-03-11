package com.nigelwilliams.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseActivityRepository<T, ID> extends MongoRepository<T, ID> {
    List<T> findAllByUserId(ID userId);
    long deleteAllByUserId(ID userId);
}
