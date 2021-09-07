package rosterBuilder.pojos;

import rosterBuilder.rules.RosterBuildingRule;
import scenarioGenerator.pojos.Deployment;
import scenarioGenerator.pojos.MissionList;
import scenarioGenerator.pojos.Scenario;

import java.util.ArrayList;
import java.util.List;

public class WargamingSystem {
    private String name;
    private List<Army> armies;
    private EntityContainer allInGameEntities;
    private List<Deployment> deployments;
    private List<MissionList> missions;
    private List<Detachment> detachments;
    private List<Scenario> scenarios;
    private int maxDetachments;
    private boolean isAllowingAlliances;
    private List<RosterBuildingRule> rules;
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

    public List<Army> getArmies() {
        return armies;
    }

    public Army getArmy(int index) {
        return armies.get(index);
    }

    public void setArmies(List<Army> armies) {
        this.armies = armies;
    }

    public List<Deployment> getDeployments() {
        return deployments;
    }

    public Deployment getDeployment(int index) {
        return deployments.get(index);
    }

    public void setDeployments(List<Deployment> deployments) {
        this.deployments = deployments;
    }

    public List<MissionList> getAllMissions() {
        return missions;
    }

    public MissionList getMissionList(int index) {
        return missions.get(index);
    }

    public void setMissions(List<MissionList> missions) {
        this.missions = missions;
    }

    public int getMaxDetachments() {
        return maxDetachments;
    }

    public void setMaxDetachments(int maxDetachments) {
        this.maxDetachments = maxDetachments;
    }

    public List<Detachment> getDetachments() {
        return detachments;
    }

    public Detachment getDetachment(int index) {
        return detachments.get(index);
    }

    public Detachment getEmptyDetachment(int index) {
        return detachments.get(index).copyEmptyDetachment();
    }

    public void setDetachments(List<Detachment> detachments) {
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

    public List<RosterBuildingRule> getRules() {
        return rules;
    }

    public void setRules(List<RosterBuildingRule> rules) {
        this.rules = rules;
    }

    public UniqueEntitiesPool getPool() {
        return pool;
    }

    public void setPool(UniqueEntitiesPool pool) {
        this.pool = pool;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<Scenario> scenarios) {
        this.scenarios = scenarios;
    }
}