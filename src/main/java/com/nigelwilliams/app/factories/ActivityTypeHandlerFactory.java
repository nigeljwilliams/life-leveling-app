package com.nigelwilliams.app.factories;

import com.nigelwilliams.app.models.enums.*;
import com.nigelwilliams.app.services.enums.ActivityType;
import com.nigelwilliams.app.typehandlers.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ActivityTypeHandlerFactory {
    private final Map<String, ActivityTypeHandler> activityTypeHandlers;

    public ActivityTypeHandler getActivityTypeHandler(ActivityType type) {
        return activityTypeHandlers.get(type.toString());
    }
}
