package com.nigelwilliams.app.repositories;

import com.nigelwilliams.app.models.YardWorkActivity;
import com.nigelwilliams.app.models.enums.YardWorkActivityType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YardWorkActivityRepository extends MongoRepository<YardWorkActivity, String> {
    List<YardWorkActivity> findByType(YardWorkActivityType type);
}
