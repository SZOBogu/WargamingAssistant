package scenarioGenerator;

import java.util.ArrayList;

public class MissionWithDeployment extends Mission {
    private Deployment deployment;

    public MissionWithDeployment(String name, ArrayList<Objective> objectives, Deployment deployment){
        super(name, objectives);
        this.deployment = deployment;
    }
}
