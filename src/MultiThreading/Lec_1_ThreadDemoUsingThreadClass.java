package MultiThreading;
/*
*   I have referred Telusko channel https://www.youtube.com/watch?v=Xj1uYKa8rIw&list=PLsyeobzWxl7rmuFYRpkqLanwoG4pQQ7oW&index=2
*/
// Multithreading using Class in Java
class Hi extends Thread{
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
class Hello extends Thread{
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
public class Lec_1_ThreadDemoUsingThreadClass {
    public static void main(String[] args) {
        Hi obj1=new Hi();
        Hello obj2=new Hello();

        obj1.start();

        obj2.start();

    }
}
