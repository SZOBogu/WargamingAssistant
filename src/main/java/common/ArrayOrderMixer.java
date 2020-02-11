package common;

import java.util.ArrayList;
import java.util.List;

public class ArrayOrderMixer {
    public List<Object> getArrayInRandomOrder(List<Object> objectList){
        ArrayList<Object> elementList = new ArrayList<>(objectList);
        ArrayList<Object> resultList = new ArrayList<>();

        while(!elementList.isEmpty()){
            Dice dice = new Dice(elementList.size());
            int roll = dice.roll() - 1;
            resultList.add(elementList.get(roll));
            elementList.remove(roll);
        }

        return resultList;
    }
}
