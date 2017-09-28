package com.theironyard.ThymeleafProject;

import java.util.Arrays;

public enum Grade {
    First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth, Tenth, Eleventh, Twelfth;

    @Override
    public String toString() {
        return name();
    }

    public static void printAll() {
        Arrays.stream(Grade.values()).forEach(System.out::println);
    }
}
