package com.nigelwilliams.app.services;

import com.nigelwilliams.app.models.User;
import com.nigelwilliams.app.repositories.CleaningActivityRepository;
import com.nigelwilliams.app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final CleaningActivityService cleaningActivityService;
    private final ExerciseActivityService exerciseActivityService;
    private final FoodPrepActivityService foodPrepActivityService;
    private final HygieneActivityService hygieneActivityService;
    private final YardWorkActivityService yardWorkActivityService;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name).orElse(null);
    }

    public List<User> getUsersByLevel(int level) {
        return userRepository.findByLevel(level);
    }

    public boolean updateExperienceAndSave(String id, int expGained) {
        User user = getUser(id);
        if (user != null) {
            user.setCurrentExperiencePoints(user.getCurrentExperiencePoints() + expGained);
            if (user.getCurrentExperiencePoints() >= user.getMaxExperiencePoints()) {
                user.setLevel(user.getLevel() + 1);
                user.setCurrentExperiencePoints(user.getCurrentExperiencePoints() - user.getMaxExperiencePoints());
                // Increate the User's max experience points by 20%
                user.setMaxExperiencePoints(user.getMaxExperiencePoints() + (user.getMaxExperiencePoints() / 5));

                System.out.println("Congratulations! Your level has increased to level " + user.getLevel() + "!");
            }

            if (updateUser(user) != null) {
                return true;
            }
        }

        System.err.println("Failed to update experience and save User data");

        return false;
    }

    public User addUser(User user) {
        try {
            return userRepository.insert(user);
        } catch (Exception e) {
            System.err.println("Failed to add user: " + e.getMessage());
        }

        return null;
    }

    public User updateUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            System.err.println("Failed to update user: " + e.getMessage());
        }

        return null;
    }

    public boolean deleteUser(String id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Failed to delete user: " + e);

            return false;
        }

        return true;
    }

    public boolean deleteUserAndRelevantData(String id) {
        User userToDelete = getUser(id);
        if (userToDelete == null) {
            System.err.println("Failed to delete User and relevant data. User doesn't exist");

            return false;
        }

        long recordsDeleted = cleaningActivityService.deleteAllByUserId(id);
        System.out.println("Cleaning Activities deleted: " + recordsDeleted);

        recordsDeleted = exerciseActivityService.deleteAllByUserId(id);
        System.out.println("Exercise Activities deleted: " + recordsDeleted);

        recordsDeleted = foodPrepActivityService.deleteAllByUserId(id);
        System.out.println("Food Prep Activities deleted: " + recordsDeleted);

        recordsDeleted = hygieneActivityService.deleteAllByUserId(id);
        System.out.println("Hygiene Activities deleted: " + recordsDeleted);

        recordsDeleted = yardWorkActivityService.deleteAllByUserId(id);
        System.out.println("Yard Work Activities deleted: " + recordsDeleted);

        return deleteUser(id);
    }
}
