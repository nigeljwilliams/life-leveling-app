package com.nigelwilliams.app.typehandlers;

import com.nigelwilliams.app.models.User;
import com.nigelwilliams.app.models.YardWorkActivity;
import com.nigelwilliams.app.models.enums.YardWorkActivityType;
import com.nigelwilliams.app.services.UserService;
import com.nigelwilliams.app.services.UserSessionService;
import com.nigelwilliams.app.services.YardWorkActivityService;
import com.nigelwilliams.app.services.enums.ActivityType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("YARD_WORK") // Make sure name matches the name of the ActivityType enum
@RequiredArgsConstructor
public final class YardWorkActivityTypeHandler implements ActivityTypeHandler {
    private final UserSessionService userSessionService;
    private final UserService userService;
    private final YardWorkActivityService yardWorkActivityService;

    private YardWorkActivityType type;
    private final Map<YardWorkActivityType, Integer> typeExperiencePointsMap = Map.ofEntries(
            Map.entry(YardWorkActivityType.MOWING, 30),
            Map.entry(YardWorkActivityType.EDGING, 40),
            Map.entry(YardWorkActivityType.LANDSCAPING, 50),
            Map.entry(YardWorkActivityType.PICK_UP_TRASH, 20),
            Map.entry(YardWorkActivityType.PRESSURE_WASHING, 60),
            Map.entry(YardWorkActivityType.PULLING_WEEDS, 50)
    );

    @Override
    public String getHandlerActivityName() {
        return ActivityType.YARD_WORK.toString();
    }

    @Override
    public void handleActivity() {
        User currentUser = userSessionService.getCurrentUser();
        if (currentUser == null) {
            System.err.println("Can't proceed. You're not signed in. (This shouldn't be happening)");

            return;
        }

        System.out.println("You chose " + type);
        YardWorkActivity activity = new YardWorkActivity();
        activity.setType(type);
        int expPoints = typeExperiencePointsMap.get(type);
        activity.setExperiencePoints(expPoints);
        activity.setUserId(currentUser.getId());

        yardWorkActivityService.addActivity(activity);

        userService.updateExperienceAndSave(currentUser.getId(), expPoints);

        System.out.println("You gained " + expPoints + " experience!");
    }

    public void setYardWorkActivityType(YardWorkActivityType type) {
        this.type = type;
    }
}
