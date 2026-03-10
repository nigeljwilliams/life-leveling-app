package com.nigelwilliams.app.services;

import com.nigelwilliams.app.models.BaseActivity;
import com.nigelwilliams.app.models.YardWorkActivity;
import com.nigelwilliams.app.repositories.YardWorkActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class YardWorkActivityService extends BaseActivityService {
    private final YardWorkActivityRepository yardWorkActivityRepository;

    @Override
    public List<YardWorkActivity> getAllActivities() {
        return yardWorkActivityRepository.findAll();
    }

    @Override
    public YardWorkActivity addActivity(BaseActivity activity) {
        try {
            return yardWorkActivityRepository.insert((YardWorkActivity)activity);
        } catch (Exception e) {
            System.err.println("Failed to add Yard Work Activity: " + e.getMessage());
        }

        return null;
    }

    @Override
    public YardWorkActivity updateActivity(BaseActivity activity) {
        try {
            return yardWorkActivityRepository.save((YardWorkActivity)activity);
        } catch (Exception e) {
            System.err.println("Failed to update Yard Work Activity: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean deleteActivity(String id) {
        try {
            yardWorkActivityRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Failed to delete Yard Work Activity: " + e.getMessage());

            return false;
        }

        return true;
    }
}
