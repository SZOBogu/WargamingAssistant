package scenarioGenerator;

import java.util.ArrayList;

public class RandomScenariosGetter {
    public ArrayList<Scenario> getScenarios(ArrayList<ScenarioList> scenarioLists, ArrayList<ArrayList<Boolean>> chosenScenarios){
        BoolToListIndexConverter converter = new BoolToListIndexConverter();
        RandomIndexGenerator generator = new RandomIndexGenerator();
        ArrayList<ArrayList<Integer>> chosenScenarioIndexes = converter.convertList(chosenScenarios);

        ArrayList<Integer> scenarioIndexes = generator.getIndexes(chosenScenarioIndexes);
        ArrayList<Scenario> randomScenarios = new ArrayList<>();
        for (int i = 0; i < scenarioIndexes.size(); i++) {
            randomScenarios.add(scenarioLists.get(i).get(scenarioIndexes.get(i)));
        }
        return randomScenarios;
    }
}