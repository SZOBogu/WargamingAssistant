package scenarioGenerator;

import java.util.ArrayList;
import java.util.Objects;

public class Mission {
    private String name;
    private ArrayList<Objective> objectives;
    private Deployment deployment;
    private String description;

    public Mission(Mission mission){
        this(mission.getName(), mission.getObjectives(), mission.getDeployment(), mission.getDescription());
    }

    public Mission(){
        this("Mission", new ArrayList<>(), null, "");
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

    //TODO: testy
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mission mission = (Mission) o;
        return Objects.equals(name, mission.name) &&
                Objects.equals(objectives, mission.objectives) &&
                Objects.equals(deployment, mission.deployment) &&
                Objects.equals(description, mission.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, objectives, deployment, description);
    }
}
