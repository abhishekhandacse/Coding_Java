package leetcode.dp;


public class Easy_Divisor_Game {


    // Brute Force DP
    public boolean divisorGame(int N) {

        boolean[] Alice_Wins=new boolean[1001];
//      Alice_Wins[1]=false;        //Redundant
        Alice_Wins[2]=true;
        for(int i=3;i<=N;i++){
            for(int j=1;j<i;j++){
                if( (i%j) == 0){
                    if(Alice_Wins[i-j]==false){
                        Alice_Wins[i]=true;
                        break;
                    }
                }

            }
        }


        return Alice_Wins[N];
    }
/*The thing to not is that, on 2 its true and every even number has 2 as one of its factor so eventually all even numbers would be reduced to 2*/
/* implies its always true for N==even*/
/*For odd number, it could be always reduced to even number by subtracting one implies or its factor would also be odd and odd -odd is always even
*  so alex would always end up giving bob even number hence she would always fail
*/


    public boolean divisorGame_Opt(int N) {

        if((N%2)==0)return true;
        return false;


    }


}
