package diceRollSimulator;

public class StringListener {
    private Controller controller;

    public StringListener(Controller controller){
        this.controller = controller;
    }

    public void textEmitted(String text) {

    }

    public Controller getController(){
        return this.controller;
    }
}
