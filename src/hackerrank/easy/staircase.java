package hackerrank.easy;

public class staircase {

    void staircase(int n) {
            int spaces=n-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(j<spaces) System.out.print(" ");
                    else System.out.print("#");
                }
                spaces--;
                System.out.println();
            }

    }
}
