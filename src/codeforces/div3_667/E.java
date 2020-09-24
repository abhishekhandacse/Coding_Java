package codeforces.div3_667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
 
//   1<=n<=2*10^5
//   1<=k<=10^9
//   1<=xi<=10^9
 
// Getting Time limit exceeded for this submission :( Java Specific issue
public class E{
 
 
    static int bs_left(List<Integer> arr,int start,int k){
                if(k==1){
                    int answer=0;
                    int iter=start;
                    while(iter>=0 &&  (arr.get(start)-arr.get(iter)==0 || arr.get(start)-arr.get(iter)==1) ){
                        answer++;
                        iter--;
                    }
                    return answer;
                }
                if(arr.get(0)>=arr.get(start)-k)return start+1;
                //find the ceil of arr[start]-k 
                int low=0,high=start,key=arr.get(start)-k;
                while(low<=high){
                    int mid=low+(high-low)/2;
                    if(key==arr.get(mid)){
                        while(mid-1>=0 && key==arr.get(mid-1)){//Include as much points as possible incase multiple points at the same co-ordinate
                            mid--;
                        }
                        return start-mid+1;
                    }//search the left most occurece of the key
                    if(key<arr.get(mid))high=mid-1;
                    else low=mid+1;
                }
                return start-low+1;//All the points inside the bar
    }
    static int bs_right(List<Integer> arr,int start,int k){
                int n=arr.size();
                if(k==1){
                    int answer=0;
                    int iter=start;
                    while(iter<n &&  (arr.get(iter)-arr.get(start)==0 || arr.get(iter)-arr.get(start)==1) ){
                        answer++;
                        iter++;
                    }
                    return answer;
                }
                
                if(arr.get(n-1)<=arr.get(start)+k)return n-1-start+1;
                //find the ceil of arr[start]-k 
                int low=start+1,high=n-1,key=arr.get(start)+k;
                while(low<=high){
                    int mid=low+(high-low)/2;
                    if(key==arr.get(mid)){
                        while( mid+1<n && key==arr.get(mid+1)){//Include as much points as possible incase multiple points at the same co-ordinate
                            mid++;
                        }
                        return mid-start+1;
                    }//search the left most occurece of the key
                    if(key<arr.get(mid))high=mid-1;
                    else low=mid+1;
                }
                return high-start+1;//All the points inside the bar
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testcases = br.readLine();
        int TC = Integer.parseInt(testcases);
        List<Integer> arr=new ArrayList<Integer>();
        int[] prefix_max_arr=new int[200005];
        int[] suffix_max_arr=new int[200005];
        for (int tc = 0; tc < TC; tc++){
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            int n,k;
            n=Integer.parseInt(line[0]);
            k=Integer.parseInt(line[1]);
            if(n==1){
                System.out.println(1);
                br.readLine();
                br.readLine();
                continue;
            }
           
            
            line=br.readLine().split(" ");
            
            //int[] arr=new int[n];
            arr.clear();
            for(int i=0;i<n;i++)
                arr.add(Integer.parseInt(line[i]));
 
            Collections.sort(arr);
            for(int i=0;i<n;i++){
                if(i==0)prefix_max_arr[i]=bs_left(arr, i, k);
                else prefix_max_arr[i]=Math.max(prefix_max_arr[i-1],bs_left(arr, i, k));
            } 
            
            for(int i=n-1;i>0;i--){
                if(i==n-1)suffix_max_arr[i]=bs_right(arr,i,k);
                else suffix_max_arr[i]=Math.max(suffix_max_arr[i+1],bs_right(arr,i,k));
            }
 
            int answer=0;
            for(int i=0;i<n-1;i++){
                answer=Math.max(answer,prefix_max_arr[i]+suffix_max_arr[i+1]);
            }
           
            br.readLine();//Y co-ordinate is not required and given extra
            System.out.println(answer);

        }
    }
}