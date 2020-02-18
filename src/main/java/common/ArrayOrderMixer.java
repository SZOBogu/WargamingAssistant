package common;

import java.util.ArrayList;
import java.util.List;

public class ArrayOrderMixer {
    public <T> List<T> getArrayInRandomOrder(List<T> objectList){
        List<T> elementList = new ArrayList<>();
        List<T> tempList = new ArrayList<>();

        for(int i = 0; i < objectList.size(); i++) {
            tempList.add(objectList.get(i));
        }
        while(!tempList.isEmpty()){
            Dice dice = new Dice(tempList.size());
            int roll = dice.roll() - 1;
            elementList.add(tempList.get(roll));
            tempList.remove(roll);
        }
        return elementList;
    }
}
