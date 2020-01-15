package scenarioGenerator;

import java.util.ArrayList;

public class ScenarioList{
    private ArrayList<Scenario> scenarios;
    private String name;

    public ScenarioList(String name){
        this(name, new ArrayList<>());
    }

    public ScenarioList(String name, ArrayList<Scenario> scenarios){
        this.name = name;
        this.scenarios = scenarios;
    }

    public String getName() {
        return name;
    }

    public Scenario get(int index){
        return this.scenarios.get(index);
    }

    public int size(){
        return this.scenarios.size();
    }

    public void add(Scenario scenario){
        this.scenarios.add(scenario);
    }
}
