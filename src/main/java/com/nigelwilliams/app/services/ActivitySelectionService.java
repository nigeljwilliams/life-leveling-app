package com.nigelwilliams.app.services;

import com.nigelwilliams.app.factories.ActivityTypeHandlerFactory;
import com.nigelwilliams.app.models.enums.*;
import com.nigelwilliams.app.services.enums.ActivityType;
import com.nigelwilliams.app.typehandlers.*;
import com.nigelwilliams.app.utils.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ActivitySelectionService {
    private final ActivityTypeHandlerFactory factory;
    private final Scanner scanner = new Scanner(System.in);

    public void handleSelectedActivity(ActivityType selectedActivityType) {
        switch (selectedActivityType) {
            case CLEANING: {
                CleaningActivityType cleaningActivityType = CleaningActivityUtil.promptAndReturnActivity(scanner);
                CleaningActivityTypeHandler handler =
                        (CleaningActivityTypeHandler) factory.getActivityTypeHandler(selectedActivityType);
                handler.setCleaningActivityType(cleaningActivityType);
                handler.handleActivity();
                break;
            }
            case EXERCISE: {
                ExerciseActivityType exerciseActivityType = ExerciseActivityUtil.promptAndReturnActivity(scanner);
                ExerciseActivityTypeHandler handler =
                        (ExerciseActivityTypeHandler) factory.getActivityTypeHandler(selectedActivityType);
                handler.setExerciseActivityType(exerciseActivityType);
                handler.handleActivity();
                break;
            }
            case FOOD_PREP: {
                FoodPrepActivityType foodPrepActivityType = FoodPrepActivityUtil.promptAndReturnActivity(scanner);
                FoodPrepActivityTypeHandler handler =
                        (FoodPrepActivityTypeHandler) factory.getActivityTypeHandler(selectedActivityType);
                handler.setFoodPrepActivityType(foodPrepActivityType);
                handler.handleActivity();
                break;
            }
            case HYGIENE: {
                HygieneActivityType hygieneActivityType = HygieneActivityUtil.promptAndReturnActivity(scanner);
                HygieneActivityTypeHandler handler =
                        (HygieneActivityTypeHandler) factory.getActivityTypeHandler(selectedActivityType);
                handler.setHygieneActivityType(hygieneActivityType);
                handler.handleActivity();
                break;
            }
            default: { // ActivityType.YARD_WORK
                YardWorkActivityType yardWorkActivityType = YardWorkActivityUtil.promptAndReturnActivity(scanner);
                YardWorkActivityTypeHandler handler =
                        (YardWorkActivityTypeHandler) factory.getActivityTypeHandler(selectedActivityType);
                handler.setYardWorkActivityType(yardWorkActivityType);
                handler.handleActivity();
                break;
            }
        }
    }
}
