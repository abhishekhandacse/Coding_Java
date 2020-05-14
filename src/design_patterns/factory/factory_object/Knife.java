package design_patterns.factory.factory_object;

 public abstract class Knife {
     String name;
     abstract void polish();
     abstract void sharpen();
     abstract void packaged();
}

class SteakKnife extends Knife{
    public SteakKnife(String name) {
        this.name = name;
        polish();
        sharpen();
        packaged();
    }
    void polish(){
        System.out.println("I am polishing "+ name);
    }
    void sharpen(){
        System.out.println("I am sharpen "+ name);
    }
    void packaged(){
        System.out.println("I am packaging "+ name);
    }
}


class ChefsKnife extends Knife{

    public ChefsKnife(String name) {
        this.name = name;
        polish();
        sharpen();
        packaged();
    }
    void polish(){
        System.out.println("I am polishing "+ name);
    }
    void sharpen(){
        System.out.println("I am sharpen "+ name);
    }
    void packaged(){
        System.out.println("I am packaging "+ name);
    }
}