package leetcode.array;

public class Easy_Relative_Sort_Array {
    //  Brute Force Solution
    //  Time Complexity -: O(1) (Considering constraints)             Space Complexity -: O(1)
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] hm=new int[1001];
            for(int i:arr1){//O(N)
                hm[i]+=1;
            }
            int index=0;
            for(int i:arr2){//O(N*N)
                int count=hm[i];
                while(count!=0){
                    arr1[index]=i;
                    index++;
                    count--;
                }
                hm[i]=0;
            }

            for(int i=0;i<1001;i++){//O(N*N)
                if(hm[i]==0)continue;
                int count=hm[i];
                while(count!=0){
                    arr1[index]=i;
                    index++;
                    count--;
                }
            }
            return arr1;
    }
}
