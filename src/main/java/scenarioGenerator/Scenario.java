package scenarioGenerator;

import javax.swing.*;
import java.util.ArrayList;

public class Scenario {
    private String name;
    private ArrayList<Objective> objectives;
    private Deployment deployment;
    private String description;

    public Scenario(){
        this.name = "Scenario";
        this.objectives = new ArrayList<>();
        this.deployment = null;
    }

    public Scenario(String name, ArrayList<Objective> objectives){
        this.name = name;
        this.objectives = objectives;
        this.deployment = null;
        this.description = "";
    }

    public Scenario(String name, ArrayList<Objective> objectives, String description){
        this.name = name;
        this.objectives = objectives;
        this.deployment = null;
        this.description = description;
    }

    public Scenario(String name, ArrayList<Objective> objectives, Deployment deployment){
        this.name = name;
        this.objectives = objectives;
        this.deployment = deployment;
        this.description = "";
    }

    public Scenario(String name, ArrayList<Objective> objectives, Deployment deployment, String description){
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
