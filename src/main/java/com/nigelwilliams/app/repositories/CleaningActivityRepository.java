package com.nigelwilliams.app.repositories;

import com.nigelwilliams.app.models.CleaningActivity;
import com.nigelwilliams.app.models.enums.CleaningActivityType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CleaningActivityRepository extends MongoRepository<CleaningActivity, String> {
    List<CleaningActivity> findByType(CleaningActivityType type);
}
