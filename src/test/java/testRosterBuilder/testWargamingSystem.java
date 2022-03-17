package testRosterBuilder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rosterBuilder.pojos.*;
import rosterBuilder.rules.*;
import scenarioGenerator.entities.Deployment;
import scenarioGenerator.entities.Mission;
import scenarioGenerator.entities.MissionList;
import scenarioGenerator.entities.Scenario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testWargamingSystem {
    UnitProfile unitProfile00 = Mockito.mock(UnitProfile.class);
    UnitProfile unitProfile01 = Mockito.mock(UnitProfile.class);
    ArrayList<UnitProfile> unitProfiles0 = new ArrayList<>(Arrays.asList(unitProfile00, unitProfile01));
    ArmySubcategory armySubcategory0 = new ArmySubcategory("HQ", unitProfiles0);

    UnitProfile unitProfile0 = Mockito.mock(UnitProfile.class);
    UnitProfile unitProfile1 = Mockito.mock(UnitProfile.class);
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


    Deployment deployment0 = Mockito.mock(Deployment.class);
    Deployment deployment1 = Mockito.mock(Deployment.class);
    ArrayList<Deployment> deployments = new ArrayList<>(Arrays.asList(deployment0, deployment1));

    Mission mission00 = Mockito.mock(Mission.class);
    Mission mission01 =  Mockito.mock(Mission.class);
    ArrayList<Mission> missions0 = new ArrayList<>(Arrays.asList(mission00, mission01));
    MissionList missionList01 = new MissionList("Type", missions0);

    Mission mission10 = Mockito.mock(Mission.class);
    Mission mission11 =  Mockito.mock(Mission.class);
    ArrayList<Mission> missions1 = new ArrayList<>(Arrays.asList(mission10, mission11));
    MissionList missionList11 = new MissionList("Type", missions1);

    ArrayList<MissionList> missions = new ArrayList<>(Arrays.asList(missionList01, missionList11));

    Detachment det0 = new Detachment.DetachmentBuilder("Patrol")
            .arrayOfMandatoryChoicesInCategories(new ArrayList<>(Arrays.asList(1,1,0)))
            .arrayOfMaxChoicesPerCategory(new ArrayList<>(Arrays.asList(1,4,2)))
            .build();

    Detachment det1 = new Detachment.DetachmentBuilder("CAD")
            .arrayOfMandatoryChoicesInCategories(new ArrayList<>(Arrays.asList(1,2,0)))
            .arrayOfMaxChoicesPerCategory(new ArrayList<>(Arrays.asList(2,6,3)))
            .detachmentNumber(1)
            .build();

    ArrayList<Detachment> detachments = new ArrayList<>(Arrays.asList(det0, det1));

    Scenario scenario0 = new Scenario();
    Scenario scenario1 = new Scenario();
    ArrayList<Scenario> scenarios = new ArrayList<>(Arrays.asList(scenario0, scenario1));

    WargamingSystem system1 = new WargamingSystem("T10B", armies, new ArrayList<>(), deployments,
            missions, scenarios, detachments, 3, true);
    WargamingSystem system2 = new WargamingSystem();

    @Test
    void testGetName() {
        assertEquals("T10B", system1.getName());
        assertEquals("", system2.getName());
    }

    @Test
    void testGetArmies() {
        assertEquals(armies, system1.getArmies());
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
    void testSetDeployments() {
        system2.setDeployments(deployments);
        assertEquals(deployments, system2.getDeployments());
    }

    @Test
    void testGetAllMissions() {
        assertEquals(missions, system1.getMissions());
    }

    @Test
    void testSetMissions() {
        system2.setMissions(missions);
        assertEquals(missions, system2.getMissions());
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
        Entity eq000 = Mockito.mock(Entity.class);
        Entity eq0000 = Mockito.mock(Entity.class);
        Entity eq0110 = Mockito.mock(Entity.class);

        ArrayList<Entity> initArray = new ArrayList<>(Arrays.asList(eq000, eq0000,eq0110));
        UniqueEntitiesPool pool = new UniqueEntitiesPool(initArray);
        system1.setPool(pool);
        assertEquals(pool, system1.getPool());
    }

    @Test
    void testGetScenarios(){
        assertEquals(scenarios, system1.getScenarios());
    }

    @Test
    void testSetScenarios(){
        Scenario scenario2 = Mockito.mock(Scenario.class);
        Scenario scenario3 = Mockito.mock(Scenario.class);
        ArrayList<Scenario> scenarios1 = new ArrayList<>(Arrays.asList(scenario2, scenario3));
        system2.setScenarios(scenarios1);
        assertEquals(scenarios1, system2.getScenarios());
    }
}
