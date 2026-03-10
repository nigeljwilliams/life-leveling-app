package com.nigelwilliams.app.typehandlers;

import com.nigelwilliams.app.models.enums.ExerciseActivityType;
import com.nigelwilliams.app.services.UserService;
import com.nigelwilliams.app.services.UserSessionService;
import com.nigelwilliams.app.services.enums.ActivityType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("EXERCISE") // Make sure name matches the name of the ActivityType enum
@RequiredArgsConstructor
public final class ExerciseActivityTypeHandler implements ActivityTypeHandler {
    private final UserSessionService userSessionService;
    private final UserService userService;

    private ExerciseActivityType type;

    @Override
    public String getHandlerActivityName() {
        return ActivityType.EXERCISE.toString();
    }

    @Override
    public void handleActivity() {

    }

    public void setExerciseActivityType(ExerciseActivityType type) {
        this.type = type;
    }
}
