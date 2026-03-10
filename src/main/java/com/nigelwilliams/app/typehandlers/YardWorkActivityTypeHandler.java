package com.nigelwilliams.app.typehandlers;

import com.nigelwilliams.app.models.enums.YardWorkActivityType;
import com.nigelwilliams.app.services.UserService;
import com.nigelwilliams.app.services.UserSessionService;
import com.nigelwilliams.app.services.enums.ActivityType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("YARD_WORK") // Make sure name matches the name of the ActivityType enum
@RequiredArgsConstructor
public final class YardWorkActivityTypeHandler implements ActivityTypeHandler {
    private final UserSessionService userSessionService;
    private final UserService userService;

    private YardWorkActivityType type;

    @Override
    public String getHandlerActivityName() {
        return ActivityType.YARD_WORK.toString();
    }

    @Override
    public void handleActivity() {

    }

    public void setYardWorkActivityType(YardWorkActivityType type) {
        this.type = type;
    }
}
