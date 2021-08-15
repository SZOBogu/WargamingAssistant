package testDiceRollSimulator;

import diceRollSimulator.DiceRoll;
import diceRollSimulator.FormEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class testFormEvent {
    Object source = new Object();
    DiceRoll diceRoll = Mockito.mock(DiceRoll.class);
    public FormEvent formEvent = new FormEvent(source, diceRoll);

    @Test
    public void testGetters(){
        assertEquals(formEvent.getSource(), source);
        assertEquals(formEvent.getDiceRoll(), diceRoll);
    }
}
