package scenarioGenerator;

import java.util.ArrayList;

public class ScenarioWithDeployment extends Scenario{
    private Deployment deployment;

    public ScenarioWithDeployment(String name, ArrayList<Objective> objectives, Deployment deployment){
        super(name, objectives);
        this.deployment = deployment;
    }


}
