package design_patterns.factory.factory_object;

public class KnifeFactory {
    public Knife createKnife(String type){
        Knife knife=null;
        // create Knife object
        if (type.equals("steak")) {
            knife = new SteakKnife(type);
        } else if (type.equals("chefs")) {
            knife = new ChefsKnife(type);
        }
        return knife;
    }
}

class BudgetKnifeFactory extends KnifeFactory{

}

class ExpensiveKnifeFactory extends KnifeFactory{

}