package com.nigelwilliams.app.typehandlers;

import com.nigelwilliams.app.models.HygieneActivity;
import com.nigelwilliams.app.models.User;
import com.nigelwilliams.app.models.enums.HygieneActivityType;
import com.nigelwilliams.app.services.HygieneActivityService;
import com.nigelwilliams.app.services.UserService;
import com.nigelwilliams.app.services.UserSessionService;
import com.nigelwilliams.app.services.enums.ActivityType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("HYGIENE") // Make sure name matches the name of the ActivityType enum
@RequiredArgsConstructor
public final class HygieneActivityTypeHandler implements ActivityTypeHandler {
    private final UserSessionService userSessionService;
    private final UserService userService;
    private final HygieneActivityService hygieneActivityService;

    private HygieneActivityType type;
    private final Map<HygieneActivityType, Integer> typeExperiencePointsMap = Map.ofEntries(
            Map.entry(HygieneActivityType.BRUSH_TEETH, 10),
            Map.entry(HygieneActivityType.SHOWER, 10),
            Map.entry(HygieneActivityType.WASH_HAIR, 5),
            Map.entry(HygieneActivityType.CLIP_FINGER_NAILS, 10),
            Map.entry(HygieneActivityType.CLIP_TOE_NAILS, 15),
            Map.entry(HygieneActivityType.CLEAN_NOSE, 10),
            Map.entry(HygieneActivityType.CLEAN_EARS, 10),
            Map.entry(HygieneActivityType.CUT_HAIR, 20),
            Map.entry(HygieneActivityType.SHAVE, 10)
    );

    @Override
    public String getHandlerActivityName() {
        return ActivityType.HYGIENE.toString();
    }

    @Override
    public void handleActivity() {
        User currentUser = userSessionService.getCurrentUser();
        if (currentUser == null) {
            System.err.println("Can't proceed. You're not signed in. (This shouldn't be happening)");

            return;
        }

        System.out.println("You chose " + type);
        HygieneActivity activity = new HygieneActivity();
        activity.setType(type);
        int expPoints = typeExperiencePointsMap.get(type);
        activity.setExperiencePoints(expPoints);
        activity.setUserId(currentUser.getId());

        hygieneActivityService.addActivity(activity);

        userService.updateExperienceAndSave(currentUser.getId(), expPoints);

        System.out.println("You gained " + expPoints + " experience!");
    }

    public void setHygieneActivityType(HygieneActivityType type) {
        this.type = type;
    }
}
