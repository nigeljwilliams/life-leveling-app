package com.nigelwilliams.app.typehandlers;

import com.nigelwilliams.app.services.enums.ActivityType;

public sealed interface ActivityTypeHandler permits
        CleaningActivityTypeHandler,
        ExerciseActivityTypeHandler,
        FoodPrepActivityTypeHandler,
        HygieneActivityTypeHandler,
        YardWorkActivityTypeHandler
{
    /**
     * The type of activity associated with the handler. Acts as a key.
     * @return
     */
    String getHandlerActivityName();
    void handleActivity();
}
