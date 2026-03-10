package com.nigelwilliams.app.services;

import com.nigelwilliams.app.models.BaseActivity;
import com.nigelwilliams.app.models.FoodPrepActivity;
import com.nigelwilliams.app.repositories.FoodPrepActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodPrepActivityService extends BaseActivityService {
    private final FoodPrepActivityRepository foodPrepActivityRepository;


    @Override
    public List<FoodPrepActivity> getAllActivities() {
        return foodPrepActivityRepository.findAll();
    }

    @Override
    public FoodPrepActivity addActivity(BaseActivity activity) {
        try {
            return foodPrepActivityRepository.insert((FoodPrepActivity)activity);
        } catch (Exception e) {
            System.err.println("Failed to add Food Prep Activity: " + e.getMessage());
        }

        return null;
    }

    @Override
    public FoodPrepActivity updateActivity(BaseActivity activity) {
        try {
            return foodPrepActivityRepository.save((FoodPrepActivity)activity);
        } catch (Exception e) {
            System.err.println("Failed to update Food Prep Activity: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean deleteActivity(String id) {
        try {
            foodPrepActivityRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Failed to delete Food Prep Activity: " + e.getMessage());

            return false;
        }

        return true;
    }
}
