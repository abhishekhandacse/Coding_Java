package MultiThreading;
/*
 *   I have referred Telusko channel https://www.youtube.com/watch?v=Xj1uYKa8rIw&list=PLsyeobzWxl7rmuFYRpkqLanwoG4pQQ7oW&index=2
 */
// Reducing LOC using Lambda Expression and Anonymous class
public class Lec_4_IsAlive_Join_methods {
    public static void main(String[]  args) throws InterruptedException {
        Runnable obj1= ()->{
            for(int i=1;i<=5;i++){
                System.out.println("Hi");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        Runnable obj2= ()->{
            for(int i=1;i<=5;i++){
                System.out.println("Hello");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        Thread t1=new Thread(obj1);

        Thread t2=new Thread(obj2);
        // We can paste the obj and obj2 directly in their respective constructors since we are using them only once.// Just omitting that for better understanding
        System.out.println(t1.isAlive());
        t1.start();
        t2.start();
        System.out.println(t1.isAlive());
        t1.join();// Makes the control wait here till that respective thread finishes its functionality
        t2.join();
        System.out.println(t1.isAlive());// Tell weather the thread is Alive or Not
        System.out.println(t1.isAlive());

    }
}
