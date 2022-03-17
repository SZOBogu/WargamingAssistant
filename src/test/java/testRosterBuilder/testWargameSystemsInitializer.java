//package testRosterBuilder;
//
//import org.junit.jupiter.api.Test;
//import rosterBuilder.helpers.WargameSystemsInitializer;
//import rosterBuilder.pojos.WargamingSystem;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class testWargameSystemsInitializer {
//    WargameSystemsInitializer wargameSystemsInitializer = new WargameSystemsInitializer();
//
//    @Test
//    void testInitialize(){
//        ArrayList<WargamingSystem> wargamingSystems = wargameSystemsInitializer.initialize();
//        assertEquals(1, wargamingSystems.size());
//        assertEquals("The 9th Age", wargamingSystems.get(0).getName());
//        assertTrue(wargamingSystems.get(0).getArmies().size() > 0);
//        assertTrue(wargamingSystems.get(0).getAllInGameEntities().size() > 0);
//        assertTrue(wargamingSystems.get(0).getDetachments().size() > 0);
//        assertTrue(wargamingSystems.get(0).getDeployments().size() > 0);
//        assertTrue(wargamingSystems.get(0).getMissions().size() > 0);
//    }
//}
