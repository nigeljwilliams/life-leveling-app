package com.nigelwilliams.app.services;

import com.nigelwilliams.app.models.BaseActivity;
import com.nigelwilliams.app.models.HygieneActivity;
import com.nigelwilliams.app.repositories.HygieneActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HygieneActivityService extends BaseActivityService {
    private final HygieneActivityRepository hygieneActivityRepository;


    @Override
    public List<HygieneActivity> getAllActivities() {
        return hygieneActivityRepository.findAll();
    }

    @Override
    public HygieneActivity addActivity(BaseActivity activity) {
        try {
            return hygieneActivityRepository.insert((HygieneActivity)activity);
        } catch (Exception e) {
            System.err.println("Failed to add Hygiene Activity: " + e.getMessage());
        }

        return null;
    }

    @Override
    public HygieneActivity updateActivity(BaseActivity activity) {
        try {
            return hygieneActivityRepository.save((HygieneActivity)activity);
        } catch (Exception e) {
            System.err.println("Failed to update Hygiene Activity: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean deleteActivity(String id) {
        try {
            hygieneActivityRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Failed to delete Hygiene Activity: " + e.getMessage());

            return false;
        }

        return true;
    }
}
