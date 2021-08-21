package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.pojos.*;
import rosterBuilder.rules.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testUnitProfile {
    Option option00 = new Option(new Weapon("op00", "bum bum"), 20);
    Option option01 = new Option(new SpecialRule("op01", "asdas"), 50);
    OptionSet optionSet0 = new SingleChoiceOptionSet(new ArrayList<>(Arrays.asList(option00, option01)));

    Option option10 = new Option(new Weapon("op10", "bam bam"), 200);
    Option option11 = new Option(new SpecialRule("op11", "asdasa"), 500);
    OptionSet optionSet1 = new MultipleChoiceOptionSet(new ArrayList<>(Arrays.asList(option10, option11)));

    Weapon eq00 = new Weapon("Pala0", "bum bum");
    Entity eq01 =    new Entity("plaszcz0", "asd");
    SpecialRule sr00 = new SpecialRule("skrmish0", "asdas");
    SpecialRule sr01 = new SpecialRule("swift0", "like, really");
    ArrayList<Entity> equipment0 = new ArrayList<>(Arrays.asList(eq00, eq01));
    ArrayList<SpecialRule> specialRules0 = new ArrayList<>(Arrays.asList(sr00, sr01));
    Statistic statistic00 = new Statistic("S", "1");
    Statistic statistic01 = new Statistic("D", "-1");
    Statistic statistic02 = new Statistic("toHit", "3+");
    Statline statline0 = new Statline(new ArrayList<>(Arrays.asList(statistic00, statistic01, statistic02)));

    ModelPart modelPart0 = new ModelPart("Model", statline0, specialRules0, equipment0);

    Weapon eq10 = new Weapon("Pala1", "bum bum");
    Entity eq11 =    new Entity("plaszcz1", "asd");
    SpecialRule sr10 = new SpecialRule("skrmish1", "asdas");
    SpecialRule sr11 = new SpecialRule("swift1", "like, really");
    ArrayList<Entity> equipment1 = new ArrayList<>(Arrays.asList(eq10, eq11));
    ArrayList<SpecialRule> specialRules1 = new ArrayList<>(Arrays.asList(sr10, sr11));
    Statistic statistic10 = new Statistic("S", "1");
    Statistic statistic11 = new Statistic("D", "-1");
    Statistic statistic12 = new Statistic("toHit", "3+");
    Statline statline1 = new Statline(new ArrayList<>(Arrays.asList(statistic10, statistic11, statistic12)));

    ModelPart modelPart1 = new ModelPart("Model", statline1, specialRules1, equipment1);

    ArrayList<ModelPart> modelParts = new ArrayList<>(Arrays.asList(modelPart0, modelPart1));
    ArrayList<OptionSet> optionSets = new ArrayList<>(Arrays.asList(optionSet0, optionSet1));

    UnitProfile unitProfile0 = new UnitProfile("Profile", modelParts, optionSets, 100);
    UnitProfile unitProfile1 = new UnitProfile("Profile 1", modelParts, optionSets, 200, 5);
    UnitProfile unitProfile2 = new UnitProfile("Profile 2", modelParts, optionSets, 300, 10, 50, 30);
    UnitProfile unitProfile3 = new UnitProfile("Profile 3", modelParts, optionSets, 400, 5, 15, 55, 2);
    UnitProfile unitProfile4 = new UnitProfile();
    @Test
    void testGetName(){
        assertEquals("Profile", unitProfile0.getName());
        assertEquals("Profile 1", unitProfile1.getName());
        assertEquals("Profile 2", unitProfile2.getName());
        assertEquals("Profile 3", unitProfile3.getName());
        assertEquals("", unitProfile4.getName());
    }

    @Test
    void testGetModelParts(){
        assertEquals(modelPart0.getName(), unitProfile0.getModelParts().get(0).getName());
        assertEquals(modelPart0.getStatline(), unitProfile0.getModelParts().get(0).getStatline());
        assertEquals(modelPart0.getSpecialRules(), unitProfile0.getModelParts().get(0).getSpecialRules());       //sprawdz dokumentacje
        assertEquals(modelPart0.getEquipment(), unitProfile0.getModelParts().get(0).getEquipment());       //sprawdz dokumentacje

        assertEquals(modelPart1.getName(), unitProfile0.getModelParts().get(1).getName());
        assertEquals(modelPart1.getStatline(), unitProfile0.getModelParts().get(1).getStatline());
        assertEquals(modelPart1.getSpecialRules(), unitProfile0.getModelParts().get(1).getSpecialRules());       //sprawdz dokumentacje
        assertEquals(modelPart1.getEquipment(), unitProfile0.getModelParts().get(1).getEquipment());       //sprawdz dokumentacje

        assertEquals(new ArrayList<>(), unitProfile4.getModelParts());
    }

    @Test
    void testGetOptionSet(){
        assertEquals(optionSet0, unitProfile0.getOptionSets().get(0));
        assertEquals(optionSet1, unitProfile0.getOptionSets().get(1));
        assertEquals(new ArrayList<>(), unitProfile4.getOptionSets());
    }

    @Test
    void testGetMinModels(){
        assertEquals(1, unitProfile0.getMinModels());
        assertEquals(1, unitProfile1.getMinModels());
        assertEquals(10, unitProfile2.getMinModels());
        assertEquals(5, unitProfile3.getMinModels());
        assertEquals(1, unitProfile4.getMinModels());
    }

    @Test
    void testGetMaxModels(){
        assertEquals(1, unitProfile0.getMaxModels());
        assertEquals(1, unitProfile1.getMaxModels());
        assertEquals(50, unitProfile2.getMaxModels());
        assertEquals(15, unitProfile3.getMaxModels());
        assertEquals(1, unitProfile4.getMaxModels());
    }

    @Test
    void testGetInitialCost(){
        assertEquals(100, unitProfile0.getInitialCost());
        assertEquals(200, unitProfile1.getInitialCost());
        assertEquals(300, unitProfile2.getInitialCost());
        assertEquals(400, unitProfile3.getInitialCost());
        assertEquals(0, unitProfile4.getInitialCost());
    }

    @Test
    void testGetAdditionalModel(){
        assertEquals(0, unitProfile0.getAdditionalModelCost());
        assertEquals(0, unitProfile1.getAdditionalModelCost());
        assertEquals(30, unitProfile2.getAdditionalModelCost());
        assertEquals(55, unitProfile3.getAdditionalModelCost());
        assertEquals(0, unitProfile4.getAdditionalModelCost());
    }

    @Test
    void testSetAdditionalModel(){
        unitProfile0.setAdditionalModelCost(0);
        unitProfile1.setAdditionalModelCost(1);
        unitProfile2.setAdditionalModelCost(2);
        unitProfile3.setAdditionalModelCost(3);
        assertEquals(0, unitProfile0.getAdditionalModelCost());
        assertEquals(1, unitProfile1.getAdditionalModelCost());
        assertEquals(2, unitProfile2.getAdditionalModelCost());
        assertEquals(3, unitProfile3.getAdditionalModelCost());
    }

    @Test
    void testGetUnitsPerArmy(){
        assertEquals(100, unitProfile0.getUnitsPerArmy());
        assertEquals(5, unitProfile1.getUnitsPerArmy());
        assertEquals(100, unitProfile2.getUnitsPerArmy());
        assertEquals(2, unitProfile3.getUnitsPerArmy());
        assertEquals(100, unitProfile4.getUnitsPerArmy());
    }

    @Test
    void testSetUnitsPerArmy(){
        unitProfile0.setUnitsPerArmy(0);
        unitProfile1.setUnitsPerArmy(1);
        unitProfile2.setUnitsPerArmy(2);
        unitProfile3.setUnitsPerArmy(3);
        assertEquals(0, unitProfile0.getUnitsPerArmy());
        assertEquals(1, unitProfile1.getUnitsPerArmy());
        assertEquals(2, unitProfile2.getUnitsPerArmy());
        assertEquals(3, unitProfile3.getUnitsPerArmy());
    }

    @Test
    void testToString(){
        String expected0 = "Profile\t100p\n" +
                "Single model\n" +
                "\tModel\tS: 1 D: -1 toHit: 3+ \tskrmish0, swift0, Pala0, plaszcz0\n" +
                "\tModel\tS: 1 D: -1 toHit: 3+ \tskrmish1, swift1, Pala1, plaszcz1\n";
        String expected1 = "Profile 1\t200p\n" +
                "Single model\n" +
                "\tModel\tS: 1 D: -1 toHit: 3+ \tskrmish0, swift0, Pala0, plaszcz0\n" +
                "\tModel\tS: 1 D: -1 toHit: 3+ \tskrmish1, swift1, Pala1, plaszcz1\n";
        String expected2 = "Profile 2\t300p\n" +
                "10-50 models\n" +
                "\tModel\tS: 1 D: -1 toHit: 3+ \tskrmish0, swift0, Pala0, plaszcz0\n" +
                "\tModel\tS: 1 D: -1 toHit: 3+ \tskrmish1, swift1, Pala1, plaszcz1\n";
        String expected3 = "Profile 3\t400p\n" +
                "5-15 models\n" +
                "\tModel\tS: 1 D: -1 toHit: 3+ \tskrmish0, swift0, Pala0, plaszcz0\n" +
                "\tModel\tS: 1 D: -1 toHit: 3+ \tskrmish1, swift1, Pala1, plaszcz1\n";
        String expected4 = "\t0p\n" +
                "Single model\n";

        assertEquals(expected0, unitProfile0.toString());
        assertEquals(expected1, unitProfile1.toString());
        assertEquals(expected2, unitProfile2.toString());
        assertEquals(expected3, unitProfile3.toString());
        assertEquals(expected4, unitProfile4.toString());
    }

    @Test
    void testGetStandardEquipmentAndRules(){
        ArrayList<Entity> entities1 = new ArrayList<>();
        assertTrue(entities1.addAll(modelPart0.getEquipment()));
        assertTrue(entities1.addAll(modelPart0.getSpecialRules()));
        assertTrue(entities1.addAll(modelPart1.getEquipment()));
        assertTrue(entities1.addAll(modelPart1.getSpecialRules()));

        assertEquals(entities1, unitProfile0.getBaseEquipmentAndRules());
        assertEquals(8, entities1.size());
    }

    @Test
    void testGetRules(){
        assertEquals(new ArrayList<>(), unitProfile0.getRules());
    }

    @Test
    void testSetRules(){
        CannotBeTakenTogether rule0 = new CannotBeTakenTogether(new Entity("",""), new Entity("",""));
        CannotHaveTogether rule1 = new CannotHaveTogether(new Entity("",""), new Entity("",""));
        ArrayList<UnitBuildingRule> rules = new ArrayList<>(Arrays.asList(rule0, rule1));
        unitProfile0.setRules(rules);
        assertEquals(rules, unitProfile0.getRules());
    }
}