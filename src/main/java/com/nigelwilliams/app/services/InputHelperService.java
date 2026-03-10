package com.nigelwilliams.app.services;

import com.nigelwilliams.app.models.User;
import com.nigelwilliams.app.services.enums.ActivityType;
import com.nigelwilliams.app.utils.ActivityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class InputHelperService {
    private final ActivitySelectionService activitySelectionService;

    private final Scanner scanner = new Scanner(System.in);

    public void handleActivityRecording() {
        boolean canExit = false;
        do {
            ActivityType selectedActivityType = ActivityUtil.promptAndReturnActivity(scanner);

            canExit = selectedActivityType == ActivityType.NONE;
            if (!canExit) {
                activitySelectionService.handleSelectedActivity(selectedActivityType);
            } else {
                System.out.println("\nExiting Program.");
            }
        } while (!canExit);
    }
}
