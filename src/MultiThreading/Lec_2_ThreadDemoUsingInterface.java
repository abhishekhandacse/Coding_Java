package MultiThreading;
/*
 *   I have referred Telusko channel https://www.youtube.com/watch?v=Xj1uYKa8rIw&list=PLsyeobzWxl7rmuFYRpkqLanwoG4pQQ7oW&index=2
 */
// Multithreading using Class in Java
class Hi1 implements Runnable{
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("Hi");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Hello1 implements Runnable{
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("Hello");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Lec_2_ThreadDemoUsingInterface {
    public static void main(String[] args) {
        Hi1 obj1=new Hi1();
        Hello1 obj2=new Hello1();
        Thread t1=new Thread(obj1);
        Thread t2=new Thread(obj2);
        t1.start();

        t2.start();

    }
}
