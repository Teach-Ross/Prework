package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CubeSum {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int num = 0;
        int tempNum = 0;
        boolean isInt = false;

        System.out.println("Enter an integer: ");

        //runs until user has correctly entered an integer
        do {
            if (scnr.hasNextInt()) {
                num = scnr.nextInt();
                isInt = true;
            } else {
                System.out.println("Please enter an integer: ");
                isInt = false;
                scnr.next();
            }
        } while (!(isInt));


        /*assigns sum of digits cubed for user entered integer to tempNum
        then uses equal method to test whether this value equals the number itself
        */
        tempNum = sumCubeDigits(num);
        System.out.println(equal(num, tempNum));




    }
    // tests if two integers are equals and returns boolean value
    public static boolean equal(int num, int sumCube) {
        if (num == sumCube) {
            return true;
        } else {
            return false;
        }
    }

    /* separates digits of the integer into an arraylist
    using a while loop. then sums the cubes of each integer
    and returns this sum value.
     */

    public static int sumCubeDigits(int tempNum) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int sum = 0;
        int i = 0;

        while (tempNum != 0) {
            nums.add(tempNum % 10);
            tempNum = tempNum / 10;
        }

        for (i = 0; i < nums.size(); i++) {
            sum += Math.pow(nums.get(i), 3);
        }
        return sum;
    }
}













