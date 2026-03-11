package com.nigelwilliams.app.typehandlers;


import com.nigelwilliams.app.models.CleaningActivity;
import com.nigelwilliams.app.models.User;
import com.nigelwilliams.app.models.enums.CleaningActivityType;
import com.nigelwilliams.app.services.CleaningActivityService;
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
    private final CleaningActivityService cleaningActivityService;

    private CleaningActivityType type;
    private final Map<CleaningActivityType, Integer> typeExperiencePointsMap = Map.ofEntries(
            Map.entry(CleaningActivityType.DISHES, 10),
            Map.entry(CleaningActivityType.LAUNDRY, 15),
            Map.entry(CleaningActivityType.MOPPING, 15),
            Map.entry(CleaningActivityType.SWEEPING, 10),
            Map.entry(CleaningActivityType.TOILET, 15),
            Map.entry(CleaningActivityType.STOVE, 10),
            Map.entry(CleaningActivityType.ROOM, 15),
            Map.entry(CleaningActivityType.DUSTING, 10)
    );

    @Override
    public String getHandlerActivityName() {
        return ActivityType.CLEANING.toString();
    }

    @Override
    public void handleActivity() {
        User currentUser = userSessionService.getCurrentUser();
        if (currentUser == null) {
            System.err.println("Can't proceed. You're not signed in. (This shouldn't be happening)");

            return;
        }

        System.out.println("You chose " + type);
        CleaningActivity activity = new CleaningActivity();
        activity.setType(type);
        int expPoints = typeExperiencePointsMap.get(type);
        activity.setExperiencePoints(expPoints);
        activity.setUserId(currentUser.getId());

        cleaningActivityService.addActivity(activity);

        userService.updateExperienceAndSave(currentUser.getId(), expPoints);

        System.out.println("You gained " + expPoints + " experience!");
    }

    public void setCleaningActivityType(CleaningActivityType type) {
        this.type = type;
    }
}
