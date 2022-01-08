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
    private List<Entity> allInGameEntities;
    private List<Deployment> deployments;
    private List<MissionList> missions;
    private List<Detachment> detachments;
    private List<Scenario> scenarios;
    private int maxDetachments;
    private boolean isAllowingAlliances;
    private List<RosterBuildingRule> rules;
    private UniqueEntitiesPool pool;

    public WargamingSystem(){
        this("", new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), 1, false);
    }

    public WargamingSystem(String name, ArrayList<Army> armies, ArrayList<Entity> allEqAndSR,
                           ArrayList<Deployment> deployments, ArrayList<MissionList> missions,
                           ArrayList<Scenario> scenarios, ArrayList<Detachment> detachments,
                           int maxDetachments, boolean isAllowingAlliances){
        this.name = name;
        this.armies = armies;
        this.allInGameEntities = allEqAndSR;
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

    public void setName(String name) {
        this.name = name;
    }

    public List<Army> getArmies() {
        return armies;
    }

    public void setArmies(List<Army> armies) {
        this.armies = armies;
    }

    public List<Entity> getAllInGameEntities() {
        return allInGameEntities;
    }

    public void setAllInGameEntities(List<Entity> allInGameEntities) {
        this.allInGameEntities = allInGameEntities;
    }

    public List<Deployment> getDeployments() {
        return deployments;
    }

    public void setDeployments(List<Deployment> deployments) {
        this.deployments = deployments;
    }

    public List<MissionList> getMissions() {
        return missions;
    }

    public void setMissions(List<MissionList> missions) {
        this.missions = missions;
    }

    public List<Detachment> getDetachments() {
        return detachments;
    }

    public void setDetachments(List<Detachment> detachments) {
        this.detachments = detachments;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public int getMaxDetachments() {
        return maxDetachments;
    }

    public void setMaxDetachments(int maxDetachments) {
        this.maxDetachments = maxDetachments;
    }

    public boolean isAllowingAlliances() {
        return isAllowingAlliances;
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
}
