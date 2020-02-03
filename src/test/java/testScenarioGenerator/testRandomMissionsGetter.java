package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Mission;
import scenarioGenerator.Objective;
import scenarioGenerator.RandomMissionsGetter;
import scenarioGenerator.MissionList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testRandomMissionsGetter {
    RandomMissionsGetter getter = new RandomMissionsGetter();

    ArrayList<Boolean> chosenMiss0 = new ArrayList<>(Arrays.asList(true, false, true));
    ArrayList<Boolean> chosenMiss1 = new ArrayList<>(Arrays.asList(false, true, true));
    ArrayList<Boolean> chosenMiss2 = new ArrayList<>(Arrays.asList(true, true, false));
    ArrayList<ArrayList<Boolean>> chosenMissList0 = new ArrayList<>(Arrays.asList(chosenMiss0, chosenMiss1, chosenMiss2));

    Mission miss00 = new Mission("00", new ArrayList<>(Collections.singletonList(new Objective("Kup mleko"))));
    Mission miss01 = new Mission("01", new ArrayList<>(Collections.singletonList(new Objective("Pokrój masło"))));
    Mission miss02 = new Mission("02", new ArrayList<>(Collections.singletonList(new Objective("Umyj kubek"))));
    ArrayList<Mission> missPack0 = new ArrayList<>(Arrays.asList(miss00, miss01, miss02));

    Mission miss10 = new Mission("00", new ArrayList<>(Collections.singletonList(new Objective("Na jeziorze"))));
    Mission miss11 = new Mission("01", new ArrayList<>(Collections.singletonList(new Objective("Wielka burza"))));
    Mission miss12 = new Mission("02", new ArrayList<>(Collections.singletonList(new Objective("Jezus ze mną w łodzi jest"))));
    ArrayList<Mission> missPack1 = new ArrayList<>(Arrays.asList(miss10, miss11, miss12));

    Mission miss20 = new Mission("00", new ArrayList<>(Collections.singletonList(new Objective("Leć do kuchnie i z bifyja gornczek weź"))));
    Mission miss21 = new Mission("01", new ArrayList<>(Collections.singletonList(new Objective("Puś kokotek, nalyj wody i na piec."))));
    Mission miss22 = new Mission("02", new ArrayList<>(Collections.singletonList(new Objective("Potym łobejrz cy porzondny łogiyn mosz."))));
    ArrayList<Mission> missPack2 = new ArrayList<>(Arrays.asList(miss20, miss21, miss22));

    MissionList missList0 = new MissionList("0", missPack0);
    MissionList missList1 = new MissionList("1", missPack1);
    MissionList missList2 = new MissionList("2", missPack2);
    ArrayList<MissionList> missionListArrayList = new ArrayList<>(Arrays.asList(missList0, missList1, missList2));
    @Test
    void testGetMissarios(){
        for(int i = 0; i < 1000; i++) {
            ArrayList<Mission> generatedMissions = getter.getMissions(missionListArrayList, chosenMissList0);
            assertTrue(generatedMissions.get(0) == miss00 || generatedMissions.get(0) == miss02);
            assertTrue(generatedMissions.get(1) == miss11 || generatedMissions.get(1) == miss12);
            assertTrue(generatedMissions.get(2) == miss20 || generatedMissions.get(2) == miss21);
        }
    }
}