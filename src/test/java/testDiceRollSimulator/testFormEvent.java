package testDiceRollSimulator;

import diceRollSimulator.FormEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFormEvent {
    Object source = new Object();
    public FormEvent formEvent = new FormEvent(source, 10, 2, false, false, 6, -1);

    @Test
    public void testGetters(){
        assertEquals(formEvent.getSource(), source);
        assertEquals(formEvent.getQuantity(), 10);
        assertEquals(formEvent.getSuccessValue(), 2);
        assertEquals(formEvent.isReroll(), false);
        assertEquals(formEvent.getValueToReRoll(), -1);
        assertEquals(formEvent.isFailures(), false);
        assertEquals(formEvent.getDiceSides(), 6);
    }
}
