package com.nigelwilliams.app.services;

import com.nigelwilliams.app.models.BaseActivity;
import com.nigelwilliams.app.models.ExerciseActivity;
import com.nigelwilliams.app.repositories.ExerciseActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseActivityService extends BaseActivityService {
    private final ExerciseActivityRepository exerciseActivityRepository;

    @Override
    public List<ExerciseActivity> getAllActivities() {
        return exerciseActivityRepository.findAll();
    }

    @Override
    public List<ExerciseActivity> getAllByUserId(String userId) {
        return exerciseActivityRepository.findAllByUserId(userId);
    }

    @Override
    public ExerciseActivity addActivity(BaseActivity activity) {
        try {
            return exerciseActivityRepository.insert((ExerciseActivity)activity);
        } catch (Exception e) {
            System.err.println("Failed to add Exercise Activity: " + e.getMessage());
        }

        return null;
    }

    @Override
    public ExerciseActivity updateActivity(BaseActivity activity) {
        try {
            return exerciseActivityRepository.save((ExerciseActivity)activity);
        } catch (Exception e) {
            System.err.println("Failed to update Exercise Activity: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean deleteAll() {
        try {
            exerciseActivityRepository.deleteAll();
        } catch (Exception e) {
            System.err.println("Failed to delete all Exercise Activities");

            return false;
        }

        return true;
    }

    @Override
    public boolean deleteActivity(String id) {
        try {
            exerciseActivityRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Failed to delete Exercise Activity: " + e.getMessage());

            return false;
        }

        return true;
    }

    @Override
    public long deleteAllByUserId(String userId) {
        try {
            return exerciseActivityRepository.deleteAllByUserId(userId);
        } catch (Exception e) {
            System.err.println("Failed to delete all Exercise Activities by User Id: " + e.getMessage());
        }

        return 0;
    }
}
