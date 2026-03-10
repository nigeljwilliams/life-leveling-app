package com.nigelwilliams.app.runners;

import com.nigelwilliams.app.models.User;
import com.nigelwilliams.app.repositories.*;
import com.nigelwilliams.app.services.*;
import com.nigelwilliams.app.utils.InputHelperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

// The Spring Framework will automatically find this runner
@Component
@RequiredArgsConstructor // Lombok will automatically generate the constructor with services and repos set in it
public class Runner implements CommandLineRunner {
    private final InputHelperService inputHelperService;

    private final ExerciseActivityService exerciseActivityService;
    private final CleaningActivityService cleaningActivityService;
    private final FoodPrepActivityService foodPrepActivityService;
    private final HygieneActivityService hygieneActivityService;
    private final UserService userService;
    private final YardWorkActivityService yardWorkActivityService;

    private final Scanner scanner = new Scanner(System.in);
    private final UserSessionService userSessionService;

    @Override
    public void run(String... args) {
        System.out.println("Hello! Welcome to the Life Leveling App!\nChoose an option:\n");
        if (!userService.getAllUsers().isEmpty()) {
            System.out.println("Existing Users:\n");
            for (User user : userService.getAllUsers()) {
                System.out.println("[" + user.getName() + "] ");
            }
            System.out.println("\n[A] CREATE ACCOUNT, [B] LOGIN, [C] DELETE EXISTING ACCOUNT");

            char accountOptionCode = InputHelperUtil.getCharFromInput(scanner);
            switch (accountOptionCode) {
                case 'A': {
                    User createdUser = promptUserAndCreateAccount();
                    if (createdUser != null && userSessionService.login(createdUser.getName())) {
                        System.out.println("\nWelcome " + createdUser.getName() + "!");
                        inputHelperService.handleActivityRecording();
                    } else {
                        System.err.println("\nFailed to create account. Exiting Program.");

                        return;
                    }
                    break;
                }
                case 'B': {
                    if (promptUserAndLogin()) {
                        System.out.println("\nWelcome!");
                        inputHelperService.handleActivityRecording();
                    } else {
                        System.err.println("\nFailed to login. The user with the provided name doesn't exist. " +
                                "Exiting Program.");

                        return;
                    }
                    break;
                }
                case 'C': {
                    if (promptUserAndDeleteAccount()) {
                        System.out.println("\nThe account was deleted! Exiting Program.");
                    } else {
                        System.err.println("\nFailed to delete account. The user with the provided name doesn't exist. " +
                                "Exiting Program.");

                        return;
                    }
                    break;
                }
                default: {
                    System.err.println("\nInvalid option selected. Exiting Program.");
                    break;
                }
            }
        } else {
            User createdUser = promptUserAndCreateAccount();
            if (createdUser != null && userSessionService.login(createdUser.getName())) {
                System.out.println("\nWelcome!");
                inputHelperService.handleActivityRecording();
            } else {
                System.err.println("\nFailed to create account. Exiting Program.");
            }
        }
    }

    private User promptUserAndCreateAccount() {
        System.out.println("\nEnter the name you want associated with your account");
        String name = InputHelperUtil.getNameFromInput(scanner);
        if (name != null) {
            User newUser = new User();
            newUser.setName(name);
            newUser.setLevel(1);

            return userService.addUser(newUser);
        }

        return null;
    }

    private boolean promptUserAndLogin() {
        System.out.println("\nEnter the name associated with your account");
        String name = InputHelperUtil.getNameFromInput(scanner);
        if (name != null) {
            return userSessionService.login(name);
        }

        return false;
    }

    private boolean promptUserAndDeleteAccount() {
        System.out.println("\nEnter the name associated with the account you want to delete");
        String name = InputHelperUtil.getNameFromInput(scanner);
        if (name != null) {
            User existingUser = userService.getUserByName(name);
            if (existingUser != null) {
                return userService.deleteUser(existingUser.getId());
            }
        }

        return false;
    }
}
