package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static Scanner scnr = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    /*
    method getDifference take integers values obtained from the calendar dates and
    adjusts these values appropriately as these obtained values can be negative.
    A negative days value will decrement months by one and adds this negative value to
    the number of days in the second dates month.
    A negative months value will decrement years by one and adds this negative value to
    12 (a full year of months).

    */

    public static String getDifference (int years, int months, int days, int daysInMonth){
        if (days < 0){
            days = daysInMonth + days;
            --months;
        }

        if (months < 0){
            months += 12;
            --years;
        }

        return years + " " + months + " " + days;
    }

    /* prompts user to enter two dates in the specificed format
       uses catch(ParseException) to validate user input using specified date format
       prompts user again if user input is not validated
       converts user string to date then to calendar
    */

    public static Calendar getInput (String message){
        Calendar cal = Calendar.getInstance();
        Date userInput = null;
        String input;

        while(userInput == null) {
            System.out.println(message);
            try {
                input = scnr.nextLine();
                userInput = sdf.parse(input);
                cal.setTime(userInput);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }

        return cal;
    }

    public static void main(String[] args) {

        Calendar temp = Calendar.getInstance();
        Calendar d1 = getInput("Enter date (MM-DD-YYY): ");
        Calendar d2 = getInput("Enter another date (MM-DD-YYY): ");

        //swaps dates if first date occurs after the second
        if(d1.after(d2)){
            temp = d1;
            d1 = d2;
            d2 = temp;
        }
        //gathers all necessary input for getDifference method
        int yearsBetween = d2.get(Calendar.YEAR) - d1.get(Calendar.YEAR);
        int monthsBetween = d2.get(Calendar.MONTH) - d1.get(Calendar.MONTH);
        int daysBetween = d2.get(Calendar.DAY_OF_MONTH) - d1.get(Calendar.DAY_OF_MONTH);
        int daysInMonth = d1.getActualMaximum(Calendar.DAY_OF_MONTH);


        //returns the duration between these dates and seprates the returned string value
        String diff = getDifference(yearsBetween, monthsBetween, daysBetween, daysInMonth);
        String[] difference = diff.split(" ");
        String diffYears = difference[0];
        String diffMonths = difference[1];
        String diffDays = difference[2];
        System.out.print("The duration between the two dates is: " + diffYears);
        System.out.print("" + " years, " + diffMonths + " months and " + diffDays + " days.");

    }
}
