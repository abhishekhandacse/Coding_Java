package design_patterns.singleton;


/*  --> Creational Pattern<--
*   Singleton class with lazy creation (instance wont be created its requirement comes)
*   Primary Application
*   1) Preferences in an application    (Since they are only 1 for an app)
*   2) Print key of a printer
*   3) Software driver for device.
*/
class ExampleSingleton {
    private static ExampleSingleton instance=null;
    private ExampleSingleton(){}   // Constructor is private

    public static ExampleSingleton getInstance(){
        if(instance==null){
            instance=new ExampleSingleton();
        }
        return instance;
    }
}

public class Singleton{
    // This is the client class
    public static void main(String[] args) {
        ExampleSingleton instance;
        instance=ExampleSingleton.getInstance();    //  static methods are class methods and can be invoked using class
    }
}
