package com.nigelwilliams.app.utils;

import com.nigelwilliams.app.models.enums.ExerciseActivityType;

import java.util.Scanner;

public class ExerciseActivityUtil {
    public static ExerciseActivityType fromActivityCode(char activityCode) {
        return switch (activityCode) {
            case 'A' -> ExerciseActivityType.WALK;
            case 'B' -> ExerciseActivityType.RUN;
            case 'C' -> ExerciseActivityType.OTHER_CARDIO;
            case 'D' -> ExerciseActivityType.PUSHUPS;
            case 'E' -> ExerciseActivityType.SQUATS;
            case 'F' -> ExerciseActivityType.SITUPS;
            case 'G' -> ExerciseActivityType.OTHER_STRENGTH_TRAINING;
            case 'H' -> ExerciseActivityType.SINGLE_SET_MULTI_EXERCISE;
            case 'I' -> ExerciseActivityType.DOUBLE_SET_MULTI_EXERCISE;
            case 'J' -> ExerciseActivityType.TRIPLE_SET_MULTI_EXERCISE;
            case 'K' -> ExerciseActivityType.MULTI_SET_MULTI_EXERCISE;
            default -> ExerciseActivityType.NONE;
        };
    }

    public static void printActivityInputOptions() {
        System.out.println("""
                [A] WALK, [B] RUN, [C] OTHER CARDIO, [D] PUSHUPS, \
                [E] SQUATS, [F] SITUPS, [G] OTHER STRENGTH TRAINING
                [H] SINGLE SET MULTI EXERCISE, \
                [I] DOUBLE SET MULTI EXERCISE, [J] TRIPLE SET MULTI EXERCISE, \
                [K] MULTI SET MULTI EXERCISE
                [Q] GO BACK""");
    }

    public static ExerciseActivityType promptAndReturnActivity(Scanner scanner) {
        System.out.println("\nWhat was the exercise activity?");
        printActivityInputOptions();

        char activityChar = InputHelperUtil.getLetterFromInput(scanner);
        if (activityChar != 0) {
            System.out.println("\nYou entered [" + activityChar + "]");
            return fromActivityCode(activityChar);
        }

        return ExerciseActivityType.NONE;
    }
}
