package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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
             }
             else {
                 System.out.println("Please enter an integer: ");
                 isInt = false;
                 scnr.next();
             }
         } while(!(isInt));

         tempNum = num;
         sumCubeDigits(tempNum);





        System.out.println("Thank you! You entered: " + num);
        System.out.println(sumCubeDigits(tempNum));


    }

    public static int sumCubeDigits(int tempNum) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int sum = 0;
        int i = 0;

        while (tempNum != 0) {
            nums.add(tempNum % 10);
            tempNum = tempNum / 10;
        }

        for (i=0; i < nums.size(); i++){
            sum = sum + cube(nums.get(i));
        }
        return sum;
    }
    public static int cube(int x) {
        return (x * x * x);
    }
    }












