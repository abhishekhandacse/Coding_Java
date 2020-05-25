package design_patterns.Adapter;

public class CoffeeTouchscreenAdapter  implements CoffeeMachineInterface {
    OldCoffeeMachine oldCoffeeMachine;

    public CoffeeTouchscreenAdapter(OldCoffeeMachine oldCoffeeMachine) {
        this.oldCoffeeMachine = oldCoffeeMachine;
    }

    @Override
    public void chooseFirstSelection() {
        System.out.println("First selected from Generic Coffee machine");
    }

    @Override
    public void chooseSecondSelection() {
        System.out.println("Second selected from Generic Coffee machine");
    }
}
