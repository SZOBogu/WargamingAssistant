package scenarioGenerator;

import common.Dice;
import java.util.ArrayList;

public class RandomIndexGenerator {
    public int getIndex(ArrayList<Integer> indexes){
        if(indexes.size() > 0) {
            Dice dice = new Dice(indexes.size());
            return indexes.get(dice.roll() - 1);
        }
        else
            return -1;
    }

    public ArrayList<Integer> getIndexes(ArrayList<ArrayList<Integer>> indexList){
        ArrayList<Integer> indexes = new ArrayList<>();
        for (ArrayList<Integer> integers : indexList) {
            indexes.add(getIndex(integers));
        }
        return indexes;
    }

}
