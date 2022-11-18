package com.nighthawk.spring_portfolio.mvc.calendar;
import java.util.*;

// Prototype Implementation

public class APCalendar {
    /** Returns true if year is a leap year and false otherwise.
     * isLeapYear(2019) returns False
     * isLeapYear(2016) returns True
     */          
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }

        return false;
    }
        
    /** Returns the value representing the day of the week 
     * 0 denotes Sunday, 
     * 1 denotes Monday, ..., 
     * 6 denotes Saturday. 
     * firstDayOfYear(2019) returns 2 for Tuesday.
    */
    private static int firstDayOfYear(int year) {
        int currentYearFirstDay = 6;

        if (year == 2022) {
            currentYearFirstDay = 6;
        } else if (year < 2022) {
            int yearsAway = 2022 - year;
            int leapYearsAway = numberOfLeapYears(year, 2022);
            int nonLeapYearsAway = yearsAway - leapYearsAway;
            int daysAway = (leapYearsAway * 366) + (nonLeapYearsAway * 365);
            for (int i = 0; i < daysAway; i++) {
                currentYearFirstDay--;
                if (currentYearFirstDay == -1) {
                    currentYearFirstDay = 6;
                }
            }
        } else if (year > 2022) {
            int yearsAway = year - 2022;
            int leapYearsAway = numberOfLeapYears(2022, year-1);
            int nonLeapYearsAway = yearsAway - leapYearsAway;
            int daysAway = (leapYearsAway * 366) + (nonLeapYearsAway * 365);
            for (int i = 0; i < daysAway; i++) {
                currentYearFirstDay++;
                if (currentYearFirstDay == 7) {
                    currentYearFirstDay = 0;
                }
            }
        }
        
        return currentYearFirstDay;
    }


    /** Returns n, where month, day, and year specify the nth day of the year.
     * This method accounts for whether year is a leap year. 
     * dayOfYear(1, 1, 2019) return 1
     * dayOfYear(3, 1, 2017) returns 60, since 2017 is not a leap year
     * dayOfYear(3, 1, 2016) returns 61, since 2016 is a leap year. 
    */ 
    private static int dayOfYear(int month, int day, int year) {
        int n = 0;
        int feb = 28;
        if (isLeapYear(year) == true) {
            feb = 29;
        }

        int[] months = {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            n += months[i];
        }

        n += day;
        
        return n;
    }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    public static int numberOfLeapYears(int year1, int year2) {
        int leapCount = 0;

        for (int i = year1; i <= year2; i++ ) {
            if (isLeapYear(i) == true) {
                leapCount++;
            }
        }

        return leapCount;
    }

    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year) { 
        int yearFirstDay = firstDayOfYear(year);
        int feb = 28;
         if (isLeapYear(year) == true) {
            feb = 29;
        }
        int daysAway = 0;
        int[] months = {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            daysAway += months[i];
        }

        daysAway += (day - 1);

        int weekDay = yearFirstDay;
        for (int i = 0; i < daysAway; i++) {
            weekDay++;
            if (weekDay == 7) {
                weekDay = 0;
            }
        }

        return weekDay;
    }

    /** Tester method */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        // Private access modifiers
        System.out.println("Enter a year:");
        int yearInput1 = userInput.nextInt();
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(yearInput1));

        System.out.println("Enter a year:");
        int yearInput2 = userInput.nextInt();
        System.out.println("Enter a month:");
        int monthInput2 = userInput.nextInt();
        System.out.println("Enter a day:");
        int dayInput2 = userInput.nextInt();
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(monthInput2, dayInput2, yearInput2));

        // Public access modifiers
        System.out.println("Enter a year:");
        int yearInput3 = userInput.nextInt();
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(yearInput3));

        System.out.println("Enter a year:");
        int yearInput4 = userInput.nextInt();
        System.out.println("Enter a year that comes after the previous year you input:");
        int yearInput4After = userInput.nextInt();
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(yearInput4, yearInput4After));

        System.out.println("Enter a year:");
        int yearInput5 = userInput.nextInt();
        System.out.println("Enter a month:");
        int monthInput5 = userInput.nextInt();
        System.out.println("Enter a day:");
        int dayInput5 = userInput.nextInt();
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(monthInput5, dayInput5, yearInput5));
    }
}