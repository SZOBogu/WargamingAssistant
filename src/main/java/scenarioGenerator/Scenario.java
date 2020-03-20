package scenarioGenerator;

import java.util.ArrayList;
import java.util.List;

public class Scenario {
    private String name;
    private Deployment deployment;
    private List<Mission> missions;

    public Scenario(){
        this("Scenario", new Deployment("Deployment"), new ArrayList<Mission>());
    }

    public Scenario(String name, Deployment deployment, List<Mission> missions){
        this.name = name;
        this.deployment = deployment;
        this.missions = missions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deployment getDeployment() {
        return deployment;
    }

    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}
