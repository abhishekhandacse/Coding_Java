package design_patterns.factory.factory_object;

public class Client {
    public static void main(String[] args) {

        KnifeStore knifeStore=new KnifeStore(new KnifeFactory());

        Knife steakknife=knifeStore.orderKnife("steak");

        Knife chefsknife=knifeStore.orderKnife("chefs");

    }
}
