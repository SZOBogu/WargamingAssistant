package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Objective;
import scenarioGenerator.RandomScenariosGetter;
import scenarioGenerator.Scenario;
import scenarioGenerator.ScenarioList;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testRandomScenariosGetter {
    RandomScenariosGetter getter = new RandomScenariosGetter();

    ArrayList<Boolean> chosenScen0 = new ArrayList<>(Arrays.asList(true, false, true));
    ArrayList<Boolean> chosenScen1 = new ArrayList<>(Arrays.asList(false, true, true));
    ArrayList<Boolean> chosenScen2 = new ArrayList<>(Arrays.asList(true, true, false));
    ArrayList<ArrayList<Boolean>> chosenScenList0 = new ArrayList<>(Arrays.asList(chosenScen0, chosenScen1, chosenScen2));

    Scenario scen00 = new Scenario("00", new ArrayList<>(Arrays.asList(new Objective("Kup mleko"))));
    Scenario scen01 = new Scenario("01", new ArrayList<>(Arrays.asList(new Objective("Pokrój masło"))));
    Scenario scen02 = new Scenario("02", new ArrayList<>(Arrays.asList(new Objective("Umyj kubek"))));
    ArrayList<Scenario> scenPack0 = new ArrayList<>(Arrays.asList(scen00, scen01, scen02));

    Scenario scen10 = new Scenario("00", new ArrayList<>(Arrays.asList(new Objective("Na jeziorze"))));
    Scenario scen11 = new Scenario("01", new ArrayList<>(Arrays.asList(new Objective("Wielka burza"))));
    Scenario scen12 = new Scenario("02", new ArrayList<>(Arrays.asList(new Objective("Jezus ze mną w łodzi jest"))));
    ArrayList<Scenario> scenPack1 = new ArrayList<>(Arrays.asList(scen10, scen11, scen12));

    Scenario scen20 = new Scenario("00", new ArrayList<>(Arrays.asList(new Objective("Leć do kuchnie i z bifyja gornczek weź"))));
    Scenario scen21 = new Scenario("01", new ArrayList<>(Arrays.asList(new Objective("Puś kokotek, nalyj wody i na piec."))));
    Scenario scen22 = new Scenario("02", new ArrayList<>(Arrays.asList(new Objective("Potym łobejrz cy porzondny łogiyn mosz."))));
    ArrayList<Scenario> scenPack2 = new ArrayList<>(Arrays.asList(scen20, scen21, scen22));

    ScenarioList scenList0 = new ScenarioList("0", scenPack0);
    ScenarioList scenList1 = new ScenarioList("1", scenPack1);
    ScenarioList scenList2 = new ScenarioList("2", scenPack2);
    ArrayList<ScenarioList> scenarioListArrayList = new ArrayList<>(Arrays.asList(scenList0, scenList1, scenList2));
    @Test
    void testGetScenarios(){
        for(int i = 0; i < 1000; i++) {
            ArrayList<Scenario> generatedScenarios = getter.getScenarios(scenarioListArrayList, chosenScenList0);
            assertTrue(generatedScenarios.get(0) == scen00 || generatedScenarios.get(0) == scen02);
            assertTrue(generatedScenarios.get(1) == scen11 || generatedScenarios.get(1) == scen12);
            assertTrue(generatedScenarios.get(2) == scen20 || generatedScenarios.get(2) == scen21);
        }
    }
}