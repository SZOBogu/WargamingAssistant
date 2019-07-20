package diceRollSimulator;

public class ClearListener {
    private Controller controller;
    private TablePanel tablePanel;

    public ClearListener(Controller controller, TablePanel tablePanel) {
        this.controller = controller;
        this.tablePanel = tablePanel;
    }

    public void clearButtonPressed(){
        this.controller.clear();
    }

    public Controller getController() {
        return controller;
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }
}
//
//public interface ClearListener{
//    public void clearButtonPressed(Controller controller);
//}