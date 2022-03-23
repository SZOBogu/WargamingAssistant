package testRosterBuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import rosterBuilder.entities.Roster;
import rosterBuilder.pojos.RosterObserverSubject;

public class testRosterObserverSubject {
    RosterObserverSubject rosterOS = new RosterObserverSubject();
    Roster roster = new Roster();

    @Test
    void testSetRoster(){
        rosterOS.setRoster(roster);
        assertEquals(roster, rosterOS.getRoster());
    }

    @Test
    void testGetRoster(){
        assertNull(rosterOS.getRoster());
    }
}
