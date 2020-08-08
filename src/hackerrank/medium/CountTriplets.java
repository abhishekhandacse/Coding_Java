package hackerrank.medium;

import java.util.*;

public class CountTriplets {
    ///// Problem setters code
    static long countTriplets(List<Long> arr, long k) {

        HashMap<Long,Long> l=new HashMap<>();
        HashMap<Long,Long> r=new HashMap<>();

        long n=arr.size();
        for(int i=0;i<n;i++){
            Object obj=r.get( arr.get(i) );
            if(obj==null)
                r.put(arr.get(i),1L);
            else
                r.put(arr.get(i),(Long)obj +1);
        }

        long ans=0;

        for(int i=0;i<n;i++){

            Long count = r.get(arr.get(i));
            r.put(arr.get(i),count-1);

            if( (arr.get(i))%k==0) {
                Object left = l.get((arr.get(i) / k));
                Object right = r.get((arr.get(i) * k));
                if(left!=null && right!=null){
                    ans+=(Long)left*(Long)right;
                }
            }

            Object obj= l.get(arr.get(i));

            if(obj==null){
                l.put(arr.get(i),1L);
            }else{
                l.put(arr.get(i),(Long)obj +1L);
            }

        }
        return ans;
    }
    /*
    //// -1 for invalid otherwise will return index between 0 --> len-1 where len is length of the array
    static int findCeil(List<Integer> arr,int key){
        if(arr==null)return -1;
        int len=arr.size();
        if(len==0)return -1;
        int low=0, high=len-1, mid;
        while( low <= high ){
            mid= low + (high-low)/2;
            if(key==arr.get(mid))return mid;
            else if ( key < arr.get(mid) )high=mid-1;
            else low=mid+1;
        }

        if(low > len -1)return -1;
        if(high < 0)return 0;
        return low;
    }
    static long countTriplets(List<Long> arr, long r) {

        HashMap< Long  , List<Integer> > hm = new HashMap<>();

        for( int i=0 ; i<arr.size() ; i++){
            Long element = arr.get(i);
            List<Integer> obj = hm.get(element);
            if(obj==null){
                List<Integer> l = new ArrayList<>();
                l.add(i);
                hm.put(element, l);
            }else{
                obj.add(i);
                hm.put(element,obj);
            }
        }

        long count=0,first,second,third;
        for( Map.Entry it:hm.entrySet() ){
            first=(Long)it.getKey();
            second=r*first;
            third=r*second;

            List<Integer> firstList , secondList , thirdList;
            secondList =  hm.get(second);
            thirdList = hm.get(third);
            if(secondList!=null && thirdList!=null){
                //Check the compatibility for the conditions i < j < k
                firstList=(List<Integer>)it.getValue();
                ////// Using the brute force just for initial submission
                /////  Could be optimized using Binary Search Algorithm
                for(int i=0;i<firstList.size();i++) {
                    int index=firstList.get(i);
                    int secondIndex=findCeil(secondList,index+1);
                    if(secondIndex!=-1){
                        for(int j=secondIndex;j<secondList.size();j++) {
                            int thirdIndex = findCeil(thirdList, secondList.get(j) + 1);
                            if (thirdIndex != -1) {
                                count += (thirdList.size() - thirdIndex);
                            }
                        }
                    }
                }
                ///// Commented code works but gives TLE for larger test cases
                //for(int i=0;i<firstList.size();i++){
                  //  for(int j=0;j<secondList.size();j++){
                    //    for(int k=0;k<thirdList.size();k++){
                      //      if(firstList.get(i) < secondList.get(j) && secondList.get(j) < thirdList.get(k) )
                        //        count=count+1;
                        }
                    }
                }
            }
        }
        return count;
    }
    */
    public static void main(String[] args) {
        System.out.println(countTriplets(Arrays.asList( new Long[]{1L,2L,2L,4L} ),2));
        System.out.println(countTriplets(Arrays.asList( new Long[]{1L,3L,9L,9L,27L,81L} ),3));
        System.out.println(countTriplets(Arrays.asList( new Long[]{1L,5L,5L,25L,125L} ),5));
        System.out.println(countTriplets(Arrays.asList( new Long[]{1L,2L,1L,2L,4L} ),2));
    }
}
