package rosterBuilder.entities;

import rosterBuilder.rules.RosterBuildingRule;
import scenarioGenerator.entities.Deployment;
import scenarioGenerator.entities.MissionList;
import scenarioGenerator.entities.Scenario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "wargamingSystem", schema = "wargaming_assistant")
public class WargamingSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "wargamingSystem", cascade = {CascadeType.ALL})
    private List<Army> armies;
    @OneToMany(mappedBy = "wargamingSystem", cascade = {CascadeType.ALL})
    private List<Entity> allInGameEntities;
    @OneToMany(mappedBy = "wargamingSystem", cascade = {CascadeType.ALL})
    private List<Detachment> detachments;

    @OneToMany(mappedBy = "wargamingSystem", cascade = {CascadeType.ALL})
    @JoinColumn(name = "system_id")
    private List<Deployment> deployments;
    @OneToMany(mappedBy = "wargamingSystem", cascade = {CascadeType.ALL})
    @JoinColumn(name = "system_id")
    private List<MissionList> missions;
    @OneToMany(mappedBy = "wargamingSystem", cascade = {CascadeType.ALL})
    @JoinColumn(name = "system_id")
    private List<Scenario> scenarios;

    @Column(name = "maxDetachments")
    private int maxDetachments;
    @Column(name = "isAllowingAlliances")
    private boolean isAllowingAlliances;

    @OneToMany(mappedBy = "wargamingSystem", cascade = {CascadeType.ALL})
    private List<RosterBuildingRule> rules;

    @OneToOne(targetEntity = UniqueEntitiesPool.class, mappedBy = "wargamingSystem",
            cascade = {CascadeType.ALL})
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
