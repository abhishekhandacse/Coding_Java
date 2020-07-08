package hackerrank.easy;

import java.util.List;

public class diagnolDifference {
    int diagonalDifference(List<List<Integer>> arr) {
        int k=0;
        int l=arr.get(0).size()-1;
        int ansleft=0,ansright=0;
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.get(i).size();j++){
                if(i==j){
                    ansleft+=arr.get(i).get(j);
                    ansright+=arr.get(k).get(l);
                    k++;
                    l--;
                }

            }
        }
        return Math.abs(ansleft-ansright);
    }
}
