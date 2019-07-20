package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testArmySubcategory {
    Option option000 = new Option(new Weapon("Pala", "bum bum"), 20);
    Option option001 = new Option(new SpecialRule("skirmish", "asdas"), 50);
    OptionSet optionSet00 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option000, option001)));

    Option option010 = new Option(new Weapon("Miecz", "bam bam"), 200);
    Option option011 = new Option(new SpecialRule("block", "asdasa"), 500);
    OptionSet optionSet01 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option010, option011)));

    Weapon eq000 = new Weapon("Palasz", "bum bum");
    Entity eq001 =    new Entity("kutrka", "asd");
    SpecialRule sr000 = new SpecialRule("fast", "asdas");
    SpecialRule sr001 = new SpecialRule("fearless", "like, really");
    ArrayList<Entity> equipment00 = new ArrayList<>(Arrays.asList(eq000, eq001));
    ArrayList<SpecialRule> specialRules00 = new ArrayList<>(Arrays.asList(sr000, sr001));
    Statistic statistic000 = new Statistic("S", "1");
    Statistic statistic001 = new Statistic("D", "-1");
    Statistic statistic002 = new Statistic("toHit", "3+");
    Statline statline00 = new Statline(new ArrayList<>(Arrays.asList(statistic000, statistic001, statistic002)));

    ModelPart modelPart00 = new ModelPart("Model00", statline00, specialRules00, equipment00);

    Weapon eq010 = new Weapon("Pala", "bum bum");
    Entity eq011 =    new Entity("plaszcz", "asd");
    SpecialRule sr010 = new SpecialRule("skrmish", "asdas");
    SpecialRule sr011 = new SpecialRule("swift", "like, really");
    ArrayList<Entity> equipment01 = new ArrayList<>(Arrays.asList(eq010, eq011));
    ArrayList<SpecialRule> specialRules01 = new ArrayList<>(Arrays.asList(sr010, sr011));
    Statistic statistic010 = new Statistic("S", "1");
    Statistic statistic011 = new Statistic("D", "-1");
    Statistic statistic012 = new Statistic("toHit", "3+");
    Statline statline01 = new Statline(new ArrayList<>(Arrays.asList(statistic010, statistic011, statistic012)));

    ModelPart modelPart01 = new ModelPart("Model00", statline01, specialRules01, equipment01);

    ArrayList<ModelPart> modelParts0 = new ArrayList<>(Arrays.asList(modelPart00, modelPart01));
    ArrayList<OptionSet> optionSets0 = new ArrayList<>(Arrays.asList(optionSet00, optionSet01));

    UnitProfile unitProfile0 = new UnitProfile("Profile 0", modelParts0, optionSets0, 100);
    //*************************************************PROFIL 2 ************************************************
    Option option100 = new Option(new Weapon("pistolet", "paf paf"), 20);
    Option option101 = new Option(new SpecialRule("atsknf", "sm"), 50);
    OptionSet optionSet10 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option100, option101)));

    Option option110 = new Option(new Weapon("szabla", "ciah ciach"), 200);
    Option option111 = new Option(new SpecialRule("hatred", "re roll 1"), 500);
    OptionSet optionSet11 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option110, option111)));

    Weapon eq100 = new Weapon("laser", "bziu");
    Entity eq101 =    new Entity("zbroja", "assd");
    SpecialRule sr100 = new SpecialRule("s&p", "s&ps");
    SpecialRule sr101 = new SpecialRule("relentless", "ssssaa");
    ArrayList<Entity> equipment10 = new ArrayList<>(Arrays.asList(eq100, eq101));
    ArrayList<SpecialRule> specialRules10 = new ArrayList<>(Arrays.asList(sr100, sr101));
    Statistic statistic100 = new Statistic("Aim", "d20");
    Statistic statistic101 = new Statistic("Wounds", "10");
    Statistic statistic102 = new Statistic("Save", "3+");
    Statline statline10 = new Statline(new ArrayList<>(Arrays.asList(statistic100, statistic101, statistic102)));

    ModelPart modelPart10 = new ModelPart("Model10", statline10, specialRules10, equipment10);

    Weapon eq110 = new Weapon("Pala", "bum bum");
    Entity eq111 =    new Entity("plaszcz", "asd");
    SpecialRule sr110 = new SpecialRule("skrmish", "asdas");
    SpecialRule sr111 = new SpecialRule("swift", "like, really");
    ArrayList<Entity> equipment11 = new ArrayList<>(Arrays.asList(eq110, eq111));
    ArrayList<SpecialRule> specialRules11 = new ArrayList<>(Arrays.asList(sr110, sr111));
    Statistic statistic110 = new Statistic("S", "1");
    Statistic statistic111 = new Statistic("D", "-1");
    Statistic statistic112 = new Statistic("toHit", "3+");
    Statline statline11 = new Statline(new ArrayList<>(Arrays.asList(statistic110, statistic111, statistic112)));

    ModelPart modelPart11 = new ModelPart("Model11", statline11, specialRules11, equipment11);

    ArrayList<ModelPart> modelParts1 = new ArrayList<>(Arrays.asList(modelPart10, modelPart11));
    ArrayList<OptionSet> optionSets1 = new ArrayList<>(Arrays.asList(optionSet10, optionSet11));

    UnitProfile unitProfile1 = new UnitProfile("Profile 1", modelParts1, optionSets1, 200);
    //*************************************************ARMY SUB ************************************************
    ArrayList<UnitProfile> unitProfiles = new ArrayList<>(Arrays.asList(unitProfile0, unitProfile1));

    ArmySubcategory armySubcategory = new ArmySubcategory("TROOPS", unitProfiles);

    @Test
    void testGetName(){
        assertEquals("TROOPS", armySubcategory.getName());
    }

    @Test
    void testGetUnitProfile(){
        assertEquals(unitProfile0, armySubcategory.getUnitProfile(0));
        assertEquals(unitProfile1, armySubcategory.getUnitProfile(1));
    }

    @Test
    void testSize(){
        assertEquals(2, armySubcategory.size());
    }

}
