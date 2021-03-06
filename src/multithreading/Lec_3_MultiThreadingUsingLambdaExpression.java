package multithreading;
/*
 *   I have referred Telusko channel https://www.youtube.com/watch?v=Xj1uYKa8rIw&list=PLsyeobzWxl7rmuFYRpkqLanwoG4pQQ7oW&index=2
 */
// Reducing LOC using Lambda Expression and Anonymous class
public class Lec_3_MultiThreadingUsingLambdaExpression {
    public static void main(String[]  args) {
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
        t1.start();
        t2.start();


    }
}
