package codeforces.div3_667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//   1<=n<=2*10^5
//   1<=k<=10^9
//   1<=xi<=10^9
// Incomplete ... will try after some time
public class E_Two_Platforms {

    public static void main(String[] args) throws Exception {
        final boolean PRINTS=false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testcases = br.readLine();
        int TC = Integer.parseInt(testcases);
        for (int tc = 0; tc < TC; tc++){
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            final int n,k;
            n=Integer.parseInt(line[0]);
            k=Integer.parseInt(line[1]);
            
            br.readLine();//Y co-ordinate is not required and given extra
        }
    }
}

