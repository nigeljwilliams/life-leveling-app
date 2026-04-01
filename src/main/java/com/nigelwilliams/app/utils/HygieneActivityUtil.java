package com.nigelwilliams.app.utils;

import com.nigelwilliams.app.models.enums.HygieneActivityType;

import java.util.Scanner;

public class HygieneActivityUtil {
    public static HygieneActivityType fromActivityCode(char activityCode) {
        return switch (activityCode) {
            case 'A' -> HygieneActivityType.BRUSH_TEETH;
            case 'B' -> HygieneActivityType.SHOWER;
            case 'C' -> HygieneActivityType.WASH_HAIR;
            case 'D' -> HygieneActivityType.CLIP_FINGER_NAILS;
            case 'E' -> HygieneActivityType.CLIP_TOE_NAILS;
            case 'F' -> HygieneActivityType.CLEAN_NOSE;
            case 'G' -> HygieneActivityType.CLEAN_EARS;
            case 'H' -> HygieneActivityType.CUT_HAIR;
            case 'I' -> HygieneActivityType.SHAVE;
            default -> HygieneActivityType.NONE;
        };
    }

    public static void printActivityInputOptions() {
        System.out.println("""
                [A] BRUSH TEETH, [B] SHOWER, [C] WASH HAIR, [D] CLIP FINGER NAILS
                [E] CLIP TOE NAILS, [F] CLEAN NOSE, [G] CLEAN EARS, [H] CUT HAIR
                [I] SHAVE
                [Q] GO BACK""");
    }

    public static HygieneActivityType promptAndReturnActivity(Scanner scanner) {
        System.out.println("\nWhat was the hygiene activity?");
        printActivityInputOptions();

        char activityChar = InputHelperUtil.getLetterFromInput(scanner);
        if (activityChar != 0) {
            System.out.println("\nYou entered [" + activityChar + "]");
            return fromActivityCode(activityChar);
        }

        return HygieneActivityType.NONE;
    }
}
