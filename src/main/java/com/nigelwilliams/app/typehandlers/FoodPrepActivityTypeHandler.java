package com.nigelwilliams.app.typehandlers;

import com.nigelwilliams.app.models.enums.FoodPrepActivityType;
import com.nigelwilliams.app.services.UserService;
import com.nigelwilliams.app.services.UserSessionService;
import com.nigelwilliams.app.services.enums.ActivityType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("FOOD_PREP") // Make sure name matches the name of the ActivityType enum
@RequiredArgsConstructor
public final class FoodPrepActivityTypeHandler implements ActivityTypeHandler {
    private final UserSessionService userSessionService;
    private final UserService userService;

    private FoodPrepActivityType type;

    @Override
    public String getHandlerActivityName() {
        return ActivityType.FOOD_PREP.toString();
    }

    @Override
    public void handleActivity() {

    }

    public void setFoodPrepActivityType(FoodPrepActivityType type) {
        this.type = type;
    }
}
