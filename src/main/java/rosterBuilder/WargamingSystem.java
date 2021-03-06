package rosterBuilder;

import rosterBuilder.rules.RosterBuildingRule;
import scenarioGenerator.Deployment;
import scenarioGenerator.MissionList;
import scenarioGenerator.Scenario;

import java.util.ArrayList;

public class WargamingSystem {
    private String name;
    private ArrayList<Army> armies;
    private EntityContainer allInGameEntities;
    private ArrayList<Deployment> deployments;
    private ArrayList<MissionList> missions;
    private ArrayList<Detachment> detachments;
    private ArrayList<Scenario> scenarios;
    private int maxDetachments;
    private boolean isAllowingAlliances;
    private ArrayList<RosterBuildingRule> rules;
    private UniqueEntitiesPool pool;

    public WargamingSystem(String name){
        this(name, new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), 1, false);
    }

    public WargamingSystem(String name, ArrayList<Army> armies, ArrayList<Entity> allEqAndSR,
                           ArrayList<Deployment> deployments, ArrayList<MissionList> missions,
                           ArrayList<Scenario> scenarios, ArrayList<Detachment> detachments,
                           int maxDetachments, boolean isAllowingAlliances){
        this.name = name;
        this.armies = armies;
        this.allInGameEntities = new EntityContainer();
        this.allInGameEntities.addAll(allEqAndSR);
        this.deployments = deployments;
        this.missions = missions;
        this.detachments = detachments;
        this.scenarios = scenarios;
        this.maxDetachments = maxDetachments;
        this.isAllowingAlliances = isAllowingAlliances;
        this.rules = new ArrayList<>();
        this.pool = new UniqueEntitiesPool(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public ArrayList<Army> getArmies() {
        return armies;
    }

    public Army getArmy(int index) {
        return armies.get(index);
    }

    public void setArmies(ArrayList<Army> armies) {
        this.armies = armies;
    }

    public ArrayList<Deployment> getDeployments() {
        return deployments;
    }

    public Deployment getDeployment(int index) {
        return deployments.get(index);
    }

    public void setDeployments(ArrayList<Deployment> deployments) {
        this.deployments = deployments;
    }

    public ArrayList<MissionList> getAllMissions() {
        return missions;
    }

    public MissionList getMissionList(int index) {
        return missions.get(index);
    }

    public void setMissions(ArrayList<MissionList> missions) {
        this.missions = missions;
    }

    public int getMaxDetachments() {
        return maxDetachments;
    }

    public void setMaxDetachments(int maxDetachments) {
        this.maxDetachments = maxDetachments;
    }

    public ArrayList<Detachment> getDetachments() {
        return detachments;
    }

    public Detachment getDetachment(int index) {
        return detachments.get(index);
    }

    public Detachment getEmptyDetachment(int index) {
        return detachments.get(index).copyEmptyDetachment();
    }

    public void setDetachments(ArrayList<Detachment> detachments) {
        this.detachments = detachments;
    }

    public EntityContainer getAllInGameEntities() {
        return allInGameEntities;
    }

    public boolean isAllowingAlliances(){
        return this.isAllowingAlliances;
    }

    public void setAllowingAlliances(boolean allowingAlliances) {
        isAllowingAlliances = allowingAlliances;
    }

    public ArrayList<RosterBuildingRule> getRules() {
        return rules;
    }

    public void setRules(ArrayList<RosterBuildingRule> rules) {
        this.rules = rules;
    }

    public UniqueEntitiesPool getPool() {
        return pool;
    }

    public void setPool(UniqueEntitiesPool pool) {
        this.pool = pool;
    }

    public ArrayList<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(ArrayList<Scenario> scenarios) {
        this.scenarios = scenarios;
    }
}
