package stacks;



public class Medium_ValidateStackSequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int pushindex = 0;
        int popindex = 0;
        int st[] = new int[1001];
        int stindex = 0;
        while (pushindex<pushed.length && popindex<popped.length && stindex>=0) {
            if(stindex!=0 && (st[stindex-1]==popped[popindex] )){
                stindex--;
                popindex++;
            }else{
                st[stindex] = pushed[pushindex];
                pushindex++;
                stindex++;
            }
        }
        while(popindex<popped.length && popped[popindex]==st[stindex-1]){
            stindex--;
            popindex++;
        }
        if(pushindex==pushed.length && popindex==popped.length)
            return true;
        return false;
    }

}
