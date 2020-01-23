package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Mission;
import scenarioGenerator.Objective;
import scenarioGenerator.RandomScenariosGetter;
import scenarioGenerator.MissionList;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testRandomScenariosGetter {
    RandomScenariosGetter getter = new RandomScenariosGetter();

    ArrayList<Boolean> chosenScen0 = new ArrayList<>(Arrays.asList(true, false, true));
    ArrayList<Boolean> chosenScen1 = new ArrayList<>(Arrays.asList(false, true, true));
    ArrayList<Boolean> chosenScen2 = new ArrayList<>(Arrays.asList(true, true, false));
    ArrayList<ArrayList<Boolean>> chosenScenList0 = new ArrayList<>(Arrays.asList(chosenScen0, chosenScen1, chosenScen2));

    Mission scen00 = new Mission("00", new ArrayList<>(Arrays.asList(new Objective("Kup mleko"))));
    Mission scen01 = new Mission("01", new ArrayList<>(Arrays.asList(new Objective("Pokrój masło"))));
    Mission scen02 = new Mission("02", new ArrayList<>(Arrays.asList(new Objective("Umyj kubek"))));
    ArrayList<Mission> scenPack0 = new ArrayList<>(Arrays.asList(scen00, scen01, scen02));

    Mission scen10 = new Mission("00", new ArrayList<>(Arrays.asList(new Objective("Na jeziorze"))));
    Mission scen11 = new Mission("01", new ArrayList<>(Arrays.asList(new Objective("Wielka burza"))));
    Mission scen12 = new Mission("02", new ArrayList<>(Arrays.asList(new Objective("Jezus ze mną w łodzi jest"))));
    ArrayList<Mission> scenPack1 = new ArrayList<>(Arrays.asList(scen10, scen11, scen12));

    Mission scen20 = new Mission("00", new ArrayList<>(Arrays.asList(new Objective("Leć do kuchnie i z bifyja gornczek weź"))));
    Mission scen21 = new Mission("01", new ArrayList<>(Arrays.asList(new Objective("Puś kokotek, nalyj wody i na piec."))));
    Mission scen22 = new Mission("02", new ArrayList<>(Arrays.asList(new Objective("Potym łobejrz cy porzondny łogiyn mosz."))));
    ArrayList<Mission> scenPack2 = new ArrayList<>(Arrays.asList(scen20, scen21, scen22));

    MissionList scenList0 = new MissionList("0", scenPack0);
    MissionList scenList1 = new MissionList("1", scenPack1);
    MissionList scenList2 = new MissionList("2", scenPack2);
    ArrayList<MissionList> missionListArrayList = new ArrayList<>(Arrays.asList(scenList0, scenList1, scenList2));
    @Test
    void testGetScenarios(){
        for(int i = 0; i < 1000; i++) {
            ArrayList<Mission> generatedMissions = getter.getScenarios(missionListArrayList, chosenScenList0);
            assertTrue(generatedMissions.get(0) == scen00 || generatedMissions.get(0) == scen02);
            assertTrue(generatedMissions.get(1) == scen11 || generatedMissions.get(1) == scen12);
            assertTrue(generatedMissions.get(2) == scen20 || generatedMissions.get(2) == scen21);
        }
    }
}