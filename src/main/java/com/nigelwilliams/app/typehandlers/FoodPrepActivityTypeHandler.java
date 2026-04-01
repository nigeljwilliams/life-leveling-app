package com.nigelwilliams.app.typehandlers;

import com.nigelwilliams.app.models.FoodPrepActivity;
import com.nigelwilliams.app.models.User;
import com.nigelwilliams.app.models.enums.FoodPrepActivityType;
import com.nigelwilliams.app.services.FoodPrepActivityService;
import com.nigelwilliams.app.services.UserService;
import com.nigelwilliams.app.services.UserSessionService;
import com.nigelwilliams.app.services.enums.ActivityType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("FOOD_PREP") // Make sure name matches the name of the ActivityType enum
@RequiredArgsConstructor
public final class FoodPrepActivityTypeHandler implements ActivityTypeHandler {
    private final UserSessionService userSessionService;
    private final UserService userService;
    private final FoodPrepActivityService foodPrepActivityService;

    private FoodPrepActivityType type;
    private final Map<FoodPrepActivityType, Integer> typeExperiencePointsMap = Map.ofEntries(
            Map.entry(FoodPrepActivityType.MAKE_SALAD, 5),
            Map.entry(FoodPrepActivityType.MAKE_CEREAL, 5),
            Map.entry(FoodPrepActivityType.MAKE_EASY_SANDWICH, 5),
            Map.entry(FoodPrepActivityType.MAKE_MEDIUM_SANDWICH, 10),
            Map.entry(FoodPrepActivityType.MAKE_DIFFICULT_SANDWICH, 15),
            Map.entry(FoodPrepActivityType.COOK_EASY_BREAKFAST, 7),
            Map.entry(FoodPrepActivityType.COOK_MEDIUM_BREAKFAST, 12),
            Map.entry(FoodPrepActivityType.COOK_DIFFICULT_BREAKFAST, 17),
            Map.entry(FoodPrepActivityType.COOK_EASY_LUNCH, 7),
            Map.entry(FoodPrepActivityType.COOK_MEDIUM_LUNCH, 12),
            Map.entry(FoodPrepActivityType.COOK_DIFFICULT_LUNCH, 17),
            Map.entry(FoodPrepActivityType.COOK_EASY_DINNER, 10),
            Map.entry(FoodPrepActivityType.COOK_MEDIUM_DINNER, 15),
            Map.entry(FoodPrepActivityType.COOK_DIFFICULT_DINNER, 20),
            Map.entry(FoodPrepActivityType.COOK_EASY_DESSERT, 10),
            Map.entry(FoodPrepActivityType.COOK_MEDIUM_DESSERT, 15),
            Map.entry(FoodPrepActivityType.COOK_DIFFICULT_DESSERT, 20)
    );

    @Override
    public String getHandlerActivityName() {
        return ActivityType.FOOD_PREP.toString();
    }

    @Override
    public void handleActivity() {
        User currentUser = userSessionService.getCurrentUser();
        if (currentUser == null) {
            System.err.println("Can't proceed. You're not signed in. (This shouldn't be happening)");

            return;
        }

        System.out.println("You chose " + type);
        FoodPrepActivity activity = new FoodPrepActivity();
        activity.setType(type);
        int expPoints = typeExperiencePointsMap.get(type);
        activity.setExperiencePoints(expPoints);
        activity.setUserId(currentUser.getId());

        foodPrepActivityService.addActivity(activity);

        userService.updateExperienceAndSave(currentUser.getId(), expPoints);

        System.out.println("You gained " + expPoints + " experience!");
    }

    public void setFoodPrepActivityType(FoodPrepActivityType type) {
        this.type = type;
    }
}
