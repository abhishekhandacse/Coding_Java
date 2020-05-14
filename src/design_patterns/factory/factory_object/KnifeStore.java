package design_patterns.factory.factory_object;

public class KnifeStore {
    private KnifeFactory knifeFactory;

    public KnifeStore(KnifeFactory knifeFactory) {
        this.knifeFactory = knifeFactory;
    }

    public Knife orderKnife(String type){
        Knife knife;

        knife=knifeFactory.createKnife(type);

        return knife;

    }

}
