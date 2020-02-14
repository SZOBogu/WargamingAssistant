package common;

import java.util.ArrayList;
import java.util.List;

public class ArrayOrderMixer {
    public List<Integer> getArrayIndexesInRandomOrder(List<Object> objectList){
        List<Integer> indexList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        for(int i = 0; i < objectList.size(); i++) {
            tempList.add(i);
        }
        while(!tempList.isEmpty()){
            Dice dice = new Dice(tempList.size());
            int roll = dice.roll() - 1;
            indexList.add(tempList.get(roll));
            tempList.remove(roll);
        }
        return indexList;
    }
}
