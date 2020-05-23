package multithreading;

class Counter{
    int count;
    Counter(){count=0;}

    public synchronized void  increment(){
        count=count+1;
    }
}

public class Lec_6_SynchronizedKeyword {
    public static void main(String[] args) throws InterruptedException {
        Counter c=new Counter();
        System.out.println("Count is " + c.count);

        Thread t1=new Thread(
                ()->{
            for(int i=1;i<=1000;i++){
                c.increment();
            }
        }
        );

        Thread t2=new Thread(
                ()->{
                    for(int i=1;i<=1000;i++){
                        c.increment();
                    }
                }
        );
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count " + c.count);
        // The synchronized keyword ensures that only single thread enters inside increment function and other waits for the method to become free.
    }
}
