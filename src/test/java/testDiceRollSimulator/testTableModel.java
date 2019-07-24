package testDiceRollSimulator;

import diceRollSimulator.DiceRoll;
import diceRollSimulator.TableModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testTableModel {
    TableModel tableModel = new TableModel();
    DiceRoll testRoll0 = new DiceRoll(10, 5, false, false, 6);
    DiceRoll testRoll1 = new DiceRoll(40, 3, false, false, 6);
    DiceRoll testRoll2 = new DiceRoll(50, 4, false, false, 6);

    @Test
    void testSetDataAndGetRowCount(){
        ArrayList<DiceRoll> rolls = new ArrayList<DiceRoll>(Arrays.asList(testRoll0, testRoll1, testRoll2));
        assertEquals(tableModel.getRowCount(), 0);
        tableModel.setData(rolls);
        assertEquals(tableModel.getRowCount(), 3);
    }

    @Test
    void testGetColumnName(){
        assertEquals(tableModel.getColumnName(0), "No.");
        assertEquals(tableModel.getColumnName(1), "Quantity");
        assertEquals(tableModel.getColumnName(2), "Success Value");
        assertEquals(tableModel.getColumnName(3), "Rerolling");
        assertEquals(tableModel.getColumnName(4), "Failures");
        assertEquals(tableModel.getColumnName(5), "Dice Sides");
        assertEquals(tableModel.getColumnName(6), "Value to Reroll");
    }

    @Test
    void testGetColumnCount(){
        assertEquals(tableModel.getColumnCount(), 7);
    }

    @Test
    void testGetValueAt(){
        ArrayList<DiceRoll> rolls = new ArrayList<DiceRoll>(Arrays.asList(testRoll0, testRoll1, testRoll2));
        tableModel.setData(rolls);
        assertEquals(tableModel.getValueAt(0,0), 1);
        assertEquals(tableModel.getValueAt(0,1), 10);
        assertEquals(tableModel.getValueAt(0,2), 5);
        assertEquals(tableModel.getValueAt(0,3), false);
        assertEquals(tableModel.getValueAt(0,4), false);
        assertEquals(tableModel.getValueAt(0,5), 6);
        assertEquals(tableModel.getValueAt(0,6), "None");
        assertEquals(tableModel.getValueAt(1,0), 2);
        assertEquals(tableModel.getValueAt(1,1), ' ');
        assertEquals(tableModel.getValueAt(1,2), 3);
        assertEquals(tableModel.getValueAt(1,3), false);
        assertEquals(tableModel.getValueAt(1,4), false);
        assertEquals(tableModel.getValueAt(1,5), 6);
        assertEquals(tableModel.getValueAt(1,6), "None");
        assertEquals(tableModel.getValueAt(2,0), 3);
        assertEquals(tableModel.getValueAt(2,1), ' ');
        assertEquals(tableModel.getValueAt(2,2), 4);
        assertEquals(tableModel.getValueAt(2,3), false);
        assertEquals(tableModel.getValueAt(2,4), false);
        assertEquals(tableModel.getValueAt(2,5), 6);
        assertEquals(tableModel.getValueAt(2,6), "None");
    }
}
