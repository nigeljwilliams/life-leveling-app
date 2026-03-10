package com.nigelwilliams.app.repositories;

import com.nigelwilliams.app.models.FoodPrepActivity;
import com.nigelwilliams.app.models.enums.FoodPrepActivityType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodPrepActivityRepository extends MongoRepository<FoodPrepActivity, String> {
    List<FoodPrepActivity> findByType(FoodPrepActivityType type);
}
