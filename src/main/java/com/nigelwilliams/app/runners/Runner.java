package com.nigelwilliams.app.runners;

import com.nigelwilliams.app.repositories.CleaningActivityRepository;
import com.nigelwilliams.app.repositories.ExerciseActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// The Spring Framework will automatically find this runner
@Component
public class Runner implements CommandLineRunner {
    private final ExerciseActivityRepository exerciseActivityRepository;
    private final CleaningActivityRepository cleaningActivityRepository;

    public Runner(ExerciseActivityRepository exerciseActivityRepository,
                  CleaningActivityRepository cleaningActivityRepository) {
        this.exerciseActivityRepository = exerciseActivityRepository;
        this.cleaningActivityRepository = cleaningActivityRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Testing Life Leveling App");
    }
}
