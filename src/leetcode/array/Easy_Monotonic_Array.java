package leetcode.array;

public class Easy_Monotonic_Array {

    public boolean isMonotonic(int[] A) {
        boolean mono_inc=false,mono_dec=false;

        for(int i=1;i<A.length;i++){
            if(A[i-1]>A[i])
                mono_inc=true;
            if(A[i-1]<A[i])
                mono_dec=true;
        }
        if(mono_inc==false && mono_dec==true || mono_inc==true && mono_dec==false ||mono_inc==false && mono_dec==false   )
            return true;
        return false;
    }
}
