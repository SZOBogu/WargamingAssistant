package testDiceRollSimulator;

import diceRollSimulator.FormEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class testFormEvent {
    Object source = new Object();
    public FormEvent formEvent = new FormEvent(source, 10, 2, false, false, 6, -1);

    @Test
    public void testGetters(){
        assertEquals(formEvent.getSource(), source);
        assertEquals(formEvent.getQuantity(), 10);
        assertEquals(formEvent.getSuccessValue(), 2);
        assertFalse(formEvent.isReroll());
        assertEquals(formEvent.getValueToReRoll(), -1);
        assertFalse(formEvent.isFailures());
        assertEquals(formEvent.getDiceSides(), 6);
    }
}
