/*
* Consider this stress testing sub-package seperate and is not in any means related to the rest of project
* I am keeping it here just for later reference purpose
* Use the jdk and jre separately to compile this package
*
* */

package stress_testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Random;

public class Generate_array {
    // Please run this file as java SeedVal
    public static void main(String[] args) throws FileNotFoundException {
        Random random=new Random();
        if(args.length==0){
            System.out.println("Please Give 1 command line argument");
            return;
        }
        random.setSeed(Integer.parseInt(args[0]));    // Set a seed value < long range
        int min=2,max=20;// This is indirectly the size of the input array
        int N=random.nextInt((max - min) + 1) + min;

        HashSet<Integer> used=new HashSet<>();


        // Array with N elements is prepared,
        // We just need to add that to our input.txt file
        PrintStream o1=new PrintStream(new File("input.txt"));
        System.setOut(o1);
        System.out.print(N+" ");
        for(int i=0;i<N;i++){
            int x;
            do{
                x=random.nextInt(50);
            }while (used.contains(x)==true);
            System.out.print(x+" ");
            used.add(x);
        }
        System.out.println();
    }
}
