package diceRollSimulator;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {
    private ArrayList<DiceRoll> db = new ArrayList<>();
    private String[] colNames = {"No.", "Quantity", "Success Value", "Rerolling", "Failures", "Dice Sides", "Value to Reroll"};

    public void setData(ArrayList<DiceRoll> db){
        this.db = db;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
   public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int col) {
        DiceRoll diceRoll = db.get(row);

        switch(col) {
            case 0:
                return row+1;
            case 1:
                if(row>0) return ' ';
                else return diceRoll.getQuantity();
            case 2:
                return diceRoll.getSuccessValue();
            case 3:
                return diceRoll.isReroll();
            case 4:
                return diceRoll.isFailures();
            case 5:
                return diceRoll.getDiceSides();
            case 6:
                if(diceRoll.getValueToReRoll() > 0) return diceRoll.getValueToReRoll();
                else return "None";
        }
        return null;
    }
}
