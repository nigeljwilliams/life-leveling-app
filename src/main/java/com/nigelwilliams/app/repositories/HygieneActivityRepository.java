package com.nigelwilliams.app.repositories;

import com.nigelwilliams.app.models.HygieneActivity;
import com.nigelwilliams.app.models.enums.HygieneActivityType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HygieneActivityRepository extends MongoRepository<HygieneActivity, String> {
    List<HygieneActivity> findByType(HygieneActivityType type);
}
