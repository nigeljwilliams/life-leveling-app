package com.nigelwilliams.app.services;

import com.nigelwilliams.app.models.BaseActivity;
import com.nigelwilliams.app.models.CleaningActivity;
import com.nigelwilliams.app.repositories.CleaningActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CleaningActivityService extends BaseActivityService {
    private final CleaningActivityRepository cleaningActivityRepository;

    @Override
    public List<CleaningActivity> getAllActivities() {
        return cleaningActivityRepository.findAll();
    }

    @Override
    public List<CleaningActivity> getAllByUserId(String userId) {
        return cleaningActivityRepository.findAllByUserId(userId);
    }

    public CleaningActivity getCleaningActivity(String id) {
        return cleaningActivityRepository.findById(id).orElse(null);
    }

    @Override
    public CleaningActivity addActivity(BaseActivity activity) {
        try {
            return cleaningActivityRepository.insert((CleaningActivity)activity);
        } catch (Exception e) {
            System.err.println("Failed to add Cleaning Activity: " + e.getMessage());
        }

        return null;
    }

    @Override
    public CleaningActivity updateActivity(BaseActivity activity) {
        try {
            return cleaningActivityRepository.save((CleaningActivity)activity);
        } catch (Exception e) {
            System.err.println("Failed to update Cleaning Activity: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean deleteAll() {
        try {
            cleaningActivityRepository.deleteAll();
        } catch (Exception e) {
            System.err.println("Failed to delete all Cleaning Activities");

            return false;
        }

        return true;
    }

    @Override
    public boolean deleteActivity(String id) {
        try {
            cleaningActivityRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Failed to delete Cleaning Activity: " + e.getMessage());

            return false;
        }

        return true;
    }

    @Override
    public long deleteAllByUserId(String userId) {
        try {
            return cleaningActivityRepository.deleteAllByUserId(userId);
        } catch (Exception e) {
            System.err.println("Failed to delete all Cleaning Activities by User Id: " + e.getMessage());
        }

        return 0;
    }
}
