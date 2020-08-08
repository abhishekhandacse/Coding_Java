package hackerrank.medium;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String str){
        int answer=0;
        int n=str.length();
        final int SIZE=26;
        int[][] freq = new int[ ((n*(n+1))/2) ][SIZE];
        int counter=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=i;k<=j;k++){
                    int ascii = str.charAt(k)-'a';
                    freq[counter][ascii]+=1;
                }
                counter++;
            }
        }
        for(int i=0;i<counter;i++){
            for(int j=i+1;j<counter;j++){
                int k;
                for(k=0;k<SIZE;k++){
                    if(freq[i][k]!=freq[j][k])break;
                }
                if(k==SIZE)
                    answer=answer+1;
            }
        }
        return answer;
    }

}
