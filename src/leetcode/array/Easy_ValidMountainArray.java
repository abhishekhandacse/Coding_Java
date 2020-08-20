package leetcode.array;

public class Easy_ValidMountainArray {
    // TC O(N) SC O(1)
    public boolean validMountainArray(int[] A){
                if(A.length<3)return false;
                int i=0,j=1,k=2;
                boolean hasReachedMaxima=false;
                for(k=2 ; k< A.length ; k++){
                    j=k-1;
                    i=j-1;
                    if(A[i]==A[j] || A[j]==A[k] )return false;
                    if(hasReachedMaxima==false){//Upslope
                        if( A[i] > A[j] && A[j] > A[k] )
                            return false;
                        else if( A[i] < A[j] && A[j] > A[k] ){
                            hasReachedMaxima=true;// Maxima Hit
                        }else if(A[i] > A[j] && A[j] < A[k]){
                            return false;
                        }
                    }else{//Downslope
                        if( A[i] < A[j] && A[j] < A[k] )
                            return false;
                        else if ( A[i] > A[j] && A[j] < A[k] )
                            return false;
                    }
                }
                return hasReachedMaxima;
    }

    public static void main(String[] args){
        Easy_ValidMountainArray obj=new Easy_ValidMountainArray();
        System.out.println(obj.validMountainArray(new int[]{0,1,2,1,2}));//f
        System.out.println(obj.validMountainArray(new int[]{2,1}));//f
        System.out.println(obj.validMountainArray(new int[]{3,5,5}));//f
        System.out.println(obj.validMountainArray(new int[]{0,3,2,1}));//t
        System.out.println(obj.validMountainArray(new int[]{1,3,2}));//t
        System.out.println(obj.validMountainArray(new int[]{3,5,5}));//f
        System.out.println(obj.validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9}));//f
    }
}
