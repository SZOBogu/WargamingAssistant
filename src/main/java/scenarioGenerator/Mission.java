package scenarioGenerator;

import java.util.ArrayList;

public class Mission {
    private String name;
    private ArrayList<Objective> objectives;
    private Deployment deployment;
    private String description;

    public Mission(){
        this("Scenario", new ArrayList<>(), null, "");
    }

    public Mission(String name, ArrayList<Objective> objectives){
        this(name, objectives, null, "");
    }

    public Mission(String name, ArrayList<Objective> objectives, String description){
        this(name, objectives, null, description);
    }

    public Mission(String name, ArrayList<Objective> objectives, Deployment deployment){
        this(name, objectives, deployment, "");
    }

    public Mission(String name, ArrayList<Objective> objectives, Deployment deployment, String description){
        this.name = name;
        this.objectives = objectives;
        this.deployment = deployment;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Objective> getObjectives() {
        return objectives;
    }

    public Deployment getDeployment() {
        return deployment;
    }

    public String getDescription() {
        return description;
    }
}
