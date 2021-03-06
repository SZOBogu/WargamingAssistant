package common;

import java.util.ArrayList;
import java.util.List;

public class ArrayOrderMixer {
    public <T> ArrayList<T> getArrayInRandomOrder(List<T> objectList){
        ArrayList<T> elementList = new ArrayList<>();
        ArrayList<T> tempList = new ArrayList<>(objectList);

        while(!tempList.isEmpty()){
            Dice dice = new Dice(tempList.size());
            int roll = dice.roll() - 1;
            elementList.add(tempList.get(roll));
            tempList.remove(roll);
        }
        return elementList;
    }
}
