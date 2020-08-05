package hackerrank.medium;

public class activityNotifications{
    static double median(int[] aux, int d){
                if((d%2)==0){
                    int count=0;
                    int index1=-1,index2=-1;
                    for(int i=0;i<aux.length;i++){
                        if(aux[i]!=0)
                            count+=aux[i];

                        if(count==(d/2)){
                            if(index1==-1)
                                index1=i;
                        }else if(count>(d/2)){
                            if(index1==-1){
                                index1=i;
                            }
                            if(index2==-1){
                                index2=i;
                            }
                            break;
                        }
                    }

                    return ((double)(index1+index2)/(double)2);
                }else{
                    int count=0;
                    for(int i=0;i<aux.length;i++){
                        if(aux[i]!=0)
                            count+=aux[i];

                        if(count>(d/2))
                            return i;
                    }
                    return -1;
                }
    }
    static int activityNotifications(int[] arr, int d) {

                final short SIZE=201;

                int[] aux=new int[SIZE];

                for(int i=0;i<d;i++){
                    aux[arr[i]]+=1;
                }
                int count=0;
                for(int i=d;i<arr.length;i++){
                    double med=median(aux,d);
                    med=2*med;
                    if(med <= (double) arr[i])
                        count++;

                    aux[arr[i]]+=1;
                    aux[arr[i-d]]-=1;
                }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5},5));
        System.out.println(activityNotifications(new int[]{1,2,3,4,4},4));
    }
}
