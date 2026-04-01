package com.nigelwilliams.app.utils;

import com.nigelwilliams.app.models.enums.FoodPrepActivityType;

import java.util.Scanner;

public class FoodPrepActivityUtil {
    public static FoodPrepActivityType fromActivityCode(char activityCode) {
        return switch (activityCode) {
            case 'A' -> FoodPrepActivityType.MAKE_SALAD;
            case 'B' -> FoodPrepActivityType.MAKE_CEREAL;
            case 'C' -> FoodPrepActivityType.MAKE_EASY_SANDWICH;
            case 'D' -> FoodPrepActivityType.MAKE_MEDIUM_SANDWICH;
            case 'E' -> FoodPrepActivityType.MAKE_DIFFICULT_SANDWICH;
            case 'F' -> FoodPrepActivityType.COOK_EASY_BREAKFAST;
            case 'G' -> FoodPrepActivityType.COOK_MEDIUM_BREAKFAST;
            case 'H' -> FoodPrepActivityType.COOK_DIFFICULT_BREAKFAST;
            case 'I' -> FoodPrepActivityType.COOK_EASY_LUNCH;
            case 'J' -> FoodPrepActivityType.COOK_MEDIUM_LUNCH;
            case 'K' -> FoodPrepActivityType.COOK_DIFFICULT_LUNCH;
            case 'L' -> FoodPrepActivityType.COOK_EASY_DINNER;
            case 'M' -> FoodPrepActivityType.COOK_MEDIUM_DINNER;
            case 'N' -> FoodPrepActivityType.COOK_DIFFICULT_DINNER;
            case 'O' -> FoodPrepActivityType.COOK_EASY_DESSERT;
            case 'P' -> FoodPrepActivityType.COOK_MEDIUM_DESSERT;
            case 'Q' -> FoodPrepActivityType.COOK_DIFFICULT_DESSERT;
            default -> FoodPrepActivityType.NONE;
        };
    }

    public static void printActivityInputOptions() {
        System.out.println("""
                [A] MAKE SALAD, [B] MAKE CEREAL, [C] MAKE EASY SANDWICH, [D] MAKE MEDIUM SANDWICH
                [E] MAKE DIFFICULT SANDWICH, [F] COOK EASY BREAKFAST, [G] COOK MEDIUM BREAKFAST
                [H] COOK DIFFICULT BREAKFAST, [I] COOK EASY LUNCH, [J] COOK MEDIUM LUNCH, \
                [K] COOK DIFFICULT LUNCH
                [L] COOK EASY DINNER, [M] COOK MEDIUM DINNER, [N] COOK DIFFICULT DINNER
                [O] COOK EASY DESSERT, [P] COOK MEDIUM DESSERT, [Q] COOK DIFFICULT DESSERT
                [Q] GO BACK""");
    }

    public static FoodPrepActivityType promptAndReturnActivity(Scanner scanner) {
        System.out.println("\nWhat was the food prep activity?");
        printActivityInputOptions();

        char activityChar = InputHelperUtil.getLetterFromInput(scanner);
        if (activityChar != 0) {
            System.out.println("\nYou entered [" + activityChar + "]");
            return fromActivityCode(activityChar);
        }

        return FoodPrepActivityType.NONE;
    }
}
