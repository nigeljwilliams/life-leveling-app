package com.nigelwilliams.app.typehandlers;

import com.nigelwilliams.app.models.enums.HygieneActivityType;
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

    private HygieneActivityType type;
    private final Map<HygieneActivityType, Integer> typeExperiencePointsMap = Map.of(
            HygieneActivityType.BRUSH_TEETH, 10,
            HygieneActivityType.SHOWER, 10,
            HygieneActivityType.WASH_HAIR, 5,
            HygieneActivityType.CLIP_FINGER_NAILS, 10,
            HygieneActivityType.CLIP_TOE_NAILS, 15,
            HygieneActivityType.CLEAN_NOSE, 10,
            HygieneActivityType.CLEAN_EARS, 10
    );

    @Override
    public String getHandlerActivityName() {
        return ActivityType.HYGIENE.toString();
    }

    @Override
    public void handleActivity() {

    }

    public void setHygieneActivityType(HygieneActivityType type) {
        this.type = type;
    }
}
