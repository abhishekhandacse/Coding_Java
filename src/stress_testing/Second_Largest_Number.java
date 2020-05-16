package stress_testing;

/*
 * Consider this stress testing sub-package seperate and is not in any means related to the rest of the project
 * I am keeping it here just for later reference purpose
 * Use the jdk and jre separately to compile this package & Dont try to use JDK JRE of Intellj(You will litterally save much pain later)
 *
 * */

/*
* This tutorial is referenced from https://www.youtube.com/watch?v=JXTVOyQpSGM
* Basically I am trying to convert the complete tutorial to Java
* */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Second_Largest_Number {
    // Time Complexity O(NlogN)
    static int  printSecondLargest_brute_force(int[] arr){


        // Following intentionally not optimized Sorting approach
        Arrays.sort(arr);   // Sorts the array in ascending order
        return arr[arr.length-2];
    }

    // Time Complexity O(N)
    static int printSecondLargest_optimized(int[] arr){
        if(arr==null || arr.length==0 || arr.length==1)return Integer.MAX_VALUE;   // Second largest only exists in an array with size > 2

        int largest=Math.max(arr[0],arr[1]),second_largest=Math.min(arr[0],arr[1]);

        for(int i=2;i<arr.length;i++){
            if(arr[i]>largest){
                second_largest=largest;
                largest=arr[i];
            }else if(arr[i]>second_largest){
                second_largest=arr[i];
            }else{}
        }
        return second_largest;
    }


    public static void main(String[] args) throws FileNotFoundException {
        // Reading an array from file
        File file=new File("input.txt");// Just give relative path from the project base directory
        Scanner sc=new Scanner(file);
        sc.useDelimiter("\n");  // Please put /n at the end of file to ensure its safe termination
        String[] input=sc.next().split(" ");
        int N=Integer.parseInt(input[0]);
        int[] arr=new int[N];

        for(int i=1;i<input.length;i++){
            arr[i-1]=Integer.parseInt(input[i]);
        }

        PrintStream o1=new PrintStream(new File("out1.txt"));
        PrintStream o2=new PrintStream(new File("out2.txt"));
        System.setOut(o1);
        System.out.println(printSecondLargest_brute_force(arr));
        System.setOut(o2);
        System.out.println(printSecondLargest_optimized(arr));
    }
}
