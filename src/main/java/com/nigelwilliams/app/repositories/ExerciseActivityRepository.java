package com.nigelwilliams.app.repositories;

import com.nigelwilliams.app.models.ExerciseActivity;
import com.nigelwilliams.app.models.enums.ExerciseActivityType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseActivityRepository extends MongoRepository<ExerciseActivity, String> {
    List<ExerciseActivity> findByType(ExerciseActivityType type);
}
