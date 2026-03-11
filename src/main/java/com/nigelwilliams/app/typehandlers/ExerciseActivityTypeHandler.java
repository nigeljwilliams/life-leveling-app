package com.nigelwilliams.app.typehandlers;

import com.nigelwilliams.app.models.CleaningActivity;
import com.nigelwilliams.app.models.ExerciseActivity;
import com.nigelwilliams.app.models.User;
import com.nigelwilliams.app.models.enums.ExerciseActivityType;
import com.nigelwilliams.app.models.enums.HygieneActivityType;
import com.nigelwilliams.app.services.ExerciseActivityService;
import com.nigelwilliams.app.services.UserService;
import com.nigelwilliams.app.services.UserSessionService;
import com.nigelwilliams.app.services.enums.ActivityType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("EXERCISE") // Make sure name matches the name of the ActivityType enum
@RequiredArgsConstructor
public final class ExerciseActivityTypeHandler implements ActivityTypeHandler {
    private final UserSessionService userSessionService;
    private final UserService userService;
    private final ExerciseActivityService exerciseActivityService;

    private ExerciseActivityType type;
    private final Map<ExerciseActivityType, Integer> typeExperiencePointsMap = Map.ofEntries(
            Map.entry(ExerciseActivityType.WALK, 15),
            Map.entry(ExerciseActivityType.RUN, 25),
            Map.entry(ExerciseActivityType.OTHER_CARDIO, 20),
            Map.entry(ExerciseActivityType.PUSHUPS, 20),
            Map.entry(ExerciseActivityType.SQUATS, 25),
            Map.entry(ExerciseActivityType.SITUPS, 25),
            Map.entry(ExerciseActivityType.OTHER_STRENGTH_TRAINING, 20),
            Map.entry(ExerciseActivityType.SINGLE_SET_MULTI_EXERCISE, 30),
            Map.entry(ExerciseActivityType.DOUBLE_SET_MULTI_EXERCISE, 45),
            Map.entry(ExerciseActivityType.TRIPLE_SET_MULTI_EXERCISE, 60),
            Map.entry(ExerciseActivityType.MULTI_SET_MULTI_EXERCISE, 75)
    );

    @Override
    public String getHandlerActivityName() {
        return ActivityType.EXERCISE.toString();
    }

    @Override
    public void handleActivity() {
        User currentUser = userSessionService.getCurrentUser();
        if (currentUser == null) {
            System.err.println("Can't proceed. You're not signed in. (This shouldn't be happening)");

            return;
        }

        System.out.println("You chose " + type);
        ExerciseActivity activity = new ExerciseActivity();
        activity.setType(type);
        int expPoints = typeExperiencePointsMap.get(type);
        activity.setExperiencePoints(expPoints);
        activity.setUserId(currentUser.getId());

        exerciseActivityService.addActivity(activity);

        userService.updateExperienceAndSave(currentUser.getId(), expPoints);

        System.out.println("You gained " + expPoints + " experience!");
    }

    public void setExerciseActivityType(ExerciseActivityType type) {
        this.type = type;
    }
}
