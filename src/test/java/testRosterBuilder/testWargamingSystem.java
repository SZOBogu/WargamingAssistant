package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import rosterBuilder.rules.*;
import scenarioGenerator.Deployment;
import scenarioGenerator.Mission;
import scenarioGenerator.MissionList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testWargamingSystem {
    Option option0000 = new Option(new Weapon("Pala", "bum bum"), 20);
    Option option0001 = new Option(new SpecialRule("skirmish", "asdas"), 50);
    OptionSet optionSet000 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0000, option0001)));

    Option option0010 = new Option(new Weapon("Miecz", "bam bam"), 200);
    Option option0011 = new Option(new SpecialRule("block", "asdasa"), 500);
    OptionSet optionSet001 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0010, option0011)));

    Weapon eq0000 = new Weapon("Palasz", "bum bum");
    Entity eq0001 =    new Entity("kutrka", "asd");
    SpecialRule sr0000 = new SpecialRule("fast", "asdas");
    SpecialRule sr0001 = new SpecialRule("fearless", "like, really");
    ArrayList<Entity> equipment000 = new ArrayList<>(Arrays.asList(eq0000, eq0001));
    ArrayList<SpecialRule> specialRules000 = new ArrayList<>(Arrays.asList(sr0000, sr0001));
    Statistic statistic0000 = new Statistic("S", "1");
    Statistic statistic0001 = new Statistic("D", "-1");
    Statistic statistic0002 = new Statistic("toHit", "3+");
    Statline statline000 = new Statline(new ArrayList<>(Arrays.asList(statistic0000, statistic0001, statistic0002)));

    ModelPart modelPart000 = new ModelPart("Model00", statline000, specialRules000, equipment000);

    Weapon eq0010 = new Weapon("Pala", "bum bum");
    Entity eq0011 =    new Entity("plaszcz", "asd");
    SpecialRule sr0010 = new SpecialRule("skrmish", "asdas");
    SpecialRule sr0011 = new SpecialRule("swift", "like, really");
    ArrayList<Entity> equipment001 = new ArrayList<>(Arrays.asList(eq0010, eq0011));
    ArrayList<SpecialRule> specialRules001 = new ArrayList<>(Arrays.asList(sr0010, sr0011));
    Statistic statistic0010 = new Statistic("S", "1");
    Statistic statistic0011 = new Statistic("D", "-1");
    Statistic statistic0012 = new Statistic("toHit", "3+");
    Statline statline001 = new Statline(new ArrayList<>(Arrays.asList(statistic0010, statistic0011, statistic0012)));

    ModelPart modelPart001 = new ModelPart("Model000", statline001, specialRules001, equipment001);

    ArrayList<ModelPart> modelParts00 = new ArrayList<>(Arrays.asList(modelPart000, modelPart001));
    ArrayList<OptionSet> optionSets00 = new ArrayList<>(Arrays.asList(optionSet000, optionSet001));

    UnitProfile unitProfile00 = new UnitProfile("Profile 00", modelParts00, optionSets00, 100);
    //*************************************************PROFIL 2 ************************************************
    Option option0100 = new Option(new Weapon("pistolet", "paf paf"), 20);
    Option option0101 = new Option(new SpecialRule("atsknf", "sm"), 50);
    OptionSet optionSet010 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0100, option0101)));

    Option option0110 = new Option(new Weapon("szabla", "ciah ciach"), 200);
    Option option0111 = new Option(new SpecialRule("hatred", "re roll 1"), 500);
    OptionSet optionSet011 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0110, option0111)));

    Weapon eq0100 = new Weapon("laser", "bziu");
    Entity eq0101 =    new Entity("zbroja", "assd");
    SpecialRule sr0100 = new SpecialRule("s&p", "s&ps");
    SpecialRule sr0101 = new SpecialRule("relentless", "ssssaa");
    ArrayList<Entity> equipment010 = new ArrayList<>(Arrays.asList(eq0100, eq0101));
    ArrayList<SpecialRule> specialRules010 = new ArrayList<>(Arrays.asList(sr0100, sr0101));
    Statistic statistic0100 = new Statistic("Aim", "d20");
    Statistic statistic0101 = new Statistic("Wounds", "10");
    Statistic statistic0102 = new Statistic("Save", "3+");
    Statline statline010 = new Statline(new ArrayList<>(Arrays.asList(statistic0100, statistic0101, statistic0102)));

    ModelPart modelPart010 = new ModelPart("Model10", statline010, specialRules010, equipment010);

    Weapon eq0110 = new Weapon("Pala", "bum bum");
    Entity eq0111 =    new Entity("plaszcz", "asd");
    SpecialRule sr0110 = new SpecialRule("skrmish", "asdas");
    SpecialRule sr0111 = new SpecialRule("swift", "like, really");
    ArrayList<Entity> equipment011 = new ArrayList<>(Arrays.asList(eq0110, eq0111));
    ArrayList<SpecialRule> specialRules011 = new ArrayList<>(Arrays.asList(sr0110, sr0111));
    Statistic statistic0110 = new Statistic("S", "1");
    Statistic statistic0111 = new Statistic("D", "-1");
    Statistic statistic0112 = new Statistic("toHit", "3+");
    Statline statline011 = new Statline(new ArrayList<>(Arrays.asList(statistic0110, statistic0111, statistic0112)));

    ModelPart modelPart011 = new ModelPart("Model011", statline011, specialRules011, equipment011);

    ArrayList<ModelPart> modelParts01 = new ArrayList<>(Arrays.asList(modelPart010, modelPart011));
    ArrayList<OptionSet> optionSets01 = new ArrayList<>(Arrays.asList(optionSet010, optionSet011));

    UnitProfile unitProfile01 = new UnitProfile("Profile 01", modelParts01, optionSets01, 200);
    //*************************************************ARMY SUB 0************************************************
    ArrayList<UnitProfile> unitProfiles0 = new ArrayList<>(Arrays.asList(unitProfile00, unitProfile01));

    ArmySubcategory armySubcategory0 = new ArmySubcategory("HQ", unitProfiles0);


    //#############################################################################################################
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

    UnitProfile unitProfile0 = new UnitProfile("Profile 0", modelParts0, optionSets0, 300);
    //*************************************************PROFIL 2 ************************************************
    Option option1100 = new Option(new Weapon("pistolet", "paf paf"), 20);
    Option option1101 = new Option(new SpecialRule("atsknf", "sm"), 50);
    OptionSet optionSet110 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option1100, option1101)));

    Option option1110 = new Option(new Weapon("szabla", "ciah ciach"), 200);
    Option option1111 = new Option(new SpecialRule("hatred", "re roll 1"), 500);
    OptionSet optionSet111 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option1110, option1111)));

    Weapon eq1100 = new Weapon("laser", "bziu");
    Entity eq1101 =    new Entity("zbroja", "assd");
    SpecialRule sr1100 = new SpecialRule("s&p", "s&ps");
    SpecialRule sr1101 = new SpecialRule("relentless", "ssssaa");
    ArrayList<Entity> equipment110 = new ArrayList<>(Arrays.asList(eq1100, eq1101));
    ArrayList<SpecialRule> specialRules110 = new ArrayList<>(Arrays.asList(sr1100, sr1101));
    Statistic statistic1100 = new Statistic("Aim", "d20");
    Statistic statistic1101 = new Statistic("Wounds", "10");
    Statistic statistic1102 = new Statistic("Save", "3+");
    Statline statline110 = new Statline(new ArrayList<>(Arrays.asList(statistic1100, statistic1101, statistic1102)));

    ModelPart modelPart10 = new ModelPart("Model10", statline110, specialRules110, equipment110);

    Weapon eq1110 = new Weapon("Pala", "bum bum");
    Entity eq1111 =    new Entity("plaszcz", "asd");
    SpecialRule sr1110 = new SpecialRule("skrmish", "asdas");
    SpecialRule sr1111 = new SpecialRule("swift", "like, really");
    ArrayList<Entity> equipment111 = new ArrayList<>(Arrays.asList(eq1110, eq1111));
    ArrayList<SpecialRule> specialRules111 = new ArrayList<>(Arrays.asList(sr1110, sr1111));
    Statistic statistic1110 = new Statistic("S", "1");
    Statistic statistic1111 = new Statistic("D", "-1");
    Statistic statistic1112 = new Statistic("toHit", "3+");
    Statline statline111 = new Statline(new ArrayList<>(Arrays.asList(statistic1110, statistic1111, statistic1112)));

    ModelPart modelPart11 = new ModelPart("Model11", statline111, specialRules111, equipment111);

    ArrayList<ModelPart> modelParts1 = new ArrayList<>(Arrays.asList(modelPart10, modelPart11));
    ArrayList<OptionSet> optionSets1 = new ArrayList<>(Arrays.asList(optionSet110, optionSet111));

    UnitProfile unitProfile1 = new UnitProfile("Profile 1", modelParts1, optionSets1, 400);
    //*************************************************ARMY SUB ************************************************
    ArrayList<UnitProfile> unitProfiles1 = new ArrayList<>(Arrays.asList(unitProfile0, unitProfile1));

    ArmySubcategory armySubcategory1 = new ArmySubcategory("TROOPS", unitProfiles1);

    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    ArrayList<ArmySubcategory> armySubcategories = new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1));
    ImageIcon img = new ImageIcon();
    Army army = new Army("Cosmosailors", armySubcategories, img);

    ArrayList<Army> armies = new ArrayList<>(Arrays.asList(army));

    SpecialRule sr20 = new SpecialRule("sr1", "aaaaaaaaaaaaaaaa");
    SpecialRule sr21 = new SpecialRule("sr2", "bbbbbbbbbbbbbbbb");
    ArrayList<Entity> allEntities = new ArrayList<>(Arrays.asList(sr20, sr21));

    Weapon eq20 = new Weapon("luk", "sztrzalu");
    Entity eq21 =    new Entity("pancerz", "asdf");
    ArrayList<Entity> equipment2 = new ArrayList<>(Arrays.asList(eq20, eq21));
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@2222
    ImageIcon img0 = new ImageIcon("/home/bogu/IdeaProjects/WargamingAssistant//src/main/img/T9A/deployments/1.png");
    Deployment deployment0 = new Deployment("Deployment", img0);
    ImageIcon img1 = new ImageIcon("/home/bogu/IdeaProjects/WargamingAssistant//src/main/img/T9A/deployments/2.png");
    Deployment deployment1 = new Deployment("Deployment", img1);
    ArrayList<Deployment> deployments = new ArrayList<>(Arrays.asList(deployment0, deployment1));
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2222
    Mission scen00 = new Mission();
    Mission scen01 =  new Mission("test1", new ArrayList<>());
    ArrayList<Mission> scenarios0 = new ArrayList<>(Arrays.asList(scen00, scen01));
    MissionList scenList01 = new MissionList("Type", scenarios0);

    Mission scen10 = new Mission();
    Mission scen11 =  new Mission("test1", new ArrayList<>());
    ArrayList<Mission> scenarios1 = new ArrayList<>(Arrays.asList(scen10, scen11));
    MissionList scenList11 = new MissionList("Type", scenarios1);

    ArrayList<MissionList> scens = new ArrayList<>(Arrays.asList(scenList01, scenList11));

    Detachment det0 = new Detachment("Patrol", new ArrayList<Integer>(Arrays.asList(1,1,0)), new ArrayList<Integer>(Arrays.asList(1,4,2)), 0);
    Detachment det1 = new Detachment("CAD", new ArrayList<Integer>(Arrays.asList(1,2,0)), new ArrayList<Integer>(Arrays.asList(2,6,3)), 1);
    ArrayList<Detachment> detachments = new ArrayList<>(Arrays.asList(det0, det1));


    //ArrayList<ArrayList<Boolean>> allianceMatrix = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(true, true)), new ArrayList<>(Arrays.asList(false, true))));
    WargamingSystem system1 = new WargamingSystem("T10B", armies, new ArrayList<>(), deployments, scens, detachments, 3, true);
    WargamingSystem system2 = new WargamingSystem("QG50k");

    @Test
    void testGetName() {
        assertEquals("T10B", system1.getName());
        assertEquals("QG50k", system2.getName());
    }

    @Test
    void testGetArmies() {
        assertEquals(armies, system1.getArmies());
        //assertEquals(new ArrayList<>(), system2.getArmies());
    }

    @Test
    void testGetArmy() {
        assertEquals(army, system1.getArmy(0));
        //assertEquals(new ArrayList<>(), system2.getArmies());
    }

    @Test
    void testSetArmies() {
        system2.setArmies(armies);
        assertEquals(armies, system2.getArmies());
    }

    @Test
    void testGetAllInGameEntities(){
        assertEquals(0, system1.getAllInGameEntities().size());
        system1.getAllInGameEntities().addAll(allEntities);
        assertEquals(2, system1.getAllInGameEntities().size());
        system1.getAllInGameEntities().addAll(equipment2);
        assertEquals(4, system1.getAllInGameEntities().size());
    }

    @Test
    void testGetDeployments() {
        assertEquals(deployments, system1.getDeployments());
    }

    @Test
    void testGetDeployment() {
        assertEquals(deployment0, system1.getDeployment(0));
    }

    @Test
    void testSetDeployments() {
        system2.setDeployments(deployments);
        assertEquals(deployments, system2.getDeployments());
    }

    @Test
    void testGetAllScenarios() {
        assertEquals(scens, system1.getAllScenarios());
    }

    @Test
    void testGetScenarioList() {
        assertEquals(scenList01, system1.getScenarioList(0));
    }

    @Test
    void testSetScenarios() {
        system2.setScenarios(scens);
        assertEquals(scens, system2.getAllScenarios());
    }

    @Test
    void testGetDetachments() {
        assertEquals(detachments, system1.getDetachments());
    }

    @Test
    void testSetDetachments() {
        system2.setDetachments(detachments);
        assertEquals(detachments, system2.getDetachments());
    }

    @Test
    void testGetDetachment() {
        assertEquals(det0, system1.getDetachment(0));
    }

    @Test
    void testGetMaxDetachments() {
        assertEquals(3, system1.getMaxDetachments());
        assertEquals(1, system2.getMaxDetachments());
    }

    @Test
    void testSetMaxDetachments() {
        assertEquals(1, system2.getMaxDetachments());
        system2.setMaxDetachments(10);
        assertEquals(10, system2.getMaxDetachments());
    }

    @Test
    void testGetEmptyDetachment(){
        assertNotSame(det0, system1.getEmptyDetachment(0));
    }

    @Test
    void testIsAllowingAlliances() {
        assertTrue(system1.isAllowingAlliances());
        assertFalse(system2.isAllowingAlliances());
    }

    @Test
    void testSetIsAllowingAlliances(){
        system2.setAllowingAlliances(true);
        assertTrue(system2.isAllowingAlliances());
    }

    @Test
    void testGetRules() {
        assertEquals(new ArrayList<>(), system1.getRules());
    }

    @Test
    void testSetRules() {
        RosterBuildingRule rule0 = new CannotHaveMoreModelsWithThan(new Entity("f", ""), 1);
        RosterBuildingRule rule1 = new CannotBeMoreUnitsWithThan(new Entity("f", ""), 1);
        ArrayList<RosterBuildingRule> ruleArray = new ArrayList<>();
        ruleArray.add(rule0);
        ruleArray.add(rule1);
        system1.setRules(ruleArray);
        assertEquals(ruleArray, system1.getRules());
    }

    @Test
    void testGetPool() {
        assertEquals(new ArrayList<>(), system1.getPool().getAvailable());
    }

    @Test
    void testSetPool() {
        ArrayList<Entity> initArray = new ArrayList<>(Arrays.asList(eq000, eq0000,eq0110));
        UniqueEntitiesPool pool = new UniqueEntitiesPool(initArray);
        system1.setPool(pool);
        assertEquals(pool, system1.getPool());
    }
}
