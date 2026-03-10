package com.nigelwilliams.app.typehandlers;


import com.nigelwilliams.app.models.enums.CleaningActivityType;
import com.nigelwilliams.app.services.UserService;
import com.nigelwilliams.app.services.UserSessionService;
import com.nigelwilliams.app.services.enums.ActivityType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("CLEANING") // Make sure name matches the name of the ActivityType enum
@RequiredArgsConstructor
public final class CleaningActivityTypeHandler implements ActivityTypeHandler {
    private final UserSessionService userSessionService;
    private final UserService userService;

    private CleaningActivityType type;
    private final Map<CleaningActivityType, Integer> typeExperiencePointsMap = Map.of(
            CleaningActivityType.DISHES, 10,
            CleaningActivityType.LAUNDRY, 15,
            CleaningActivityType.MOPPING, 15,
            CleaningActivityType.SWEEPING, 10,
            CleaningActivityType.TOILET, 15,
            CleaningActivityType.STOVE, 10,
            CleaningActivityType.ROOM, 15,
            CleaningActivityType.DUSTING, 10
    );

    @Override
    public String getHandlerActivityName() {
        return ActivityType.CLEANING.toString();
    }

    @Override
    public void handleActivity() {
        System.out.println("You chose " + type);
        int expPoints = typeExperiencePointsMap.get(type);

    }

    public void setCleaningActivityType(CleaningActivityType type) {
        this.type = type;
    }
}
