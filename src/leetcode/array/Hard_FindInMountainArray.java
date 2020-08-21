package leetcode.array;

public class Hard_FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr){
                // Find the peak of the array first using binary search

                int low=0,high=mountainArr.length()-1,mid=-1;

                while(true){
                    mid=low+((high-low)/2);
                    int left,middle,right;
                    if(mid==0){
                        low=high;
                        continue;
                    }else{
                        left=mountainArr.get(mid-1);
                    }

                    middle=mountainArr.get(mid);

                    if(mid==mountainArr.length()-1){
                        high=low;
                        continue;
                    }else{
                        right=mountainArr.get(mid+1);
                    }


                    if( middle > left && middle > right){
                        break;
                    }else if( middle > left && middle < right){
                        low=mid+1;
                    }else if(middle < left && middle > right){
                        high=mid-1;
                    }else{
                        // Not a mountain array (Not possible under normal circumstances)
                    }
                }

                // mid now points to the peak of the mountain
                    int copy_mid=mid;
                // Now we can do search on left of the mountain

                    low=0;high=mid;

                    while(low<=high){
                        mid=low+((high-low)/2);
                        int val=mountainArr.get(mid);
                        if(val < target){
                            low=mid+1;
                        }else if (val > target){
                            high=mid-1;
                        }else return mid;
                    }
                // Search right of the mountain

                    low=copy_mid; high=mountainArr.length()-1;

                    while(low<=high){
                        mid=low+((high-low)/2);
                        int val=mountainArr.get(mid);
                        if(val<target){
                            high=mid-1;
                        }else if (val>target){
                            low=mid+1;
                        }else return mid;
                    }

                    return -1;// Search Unsuccessfull case
    }
}
