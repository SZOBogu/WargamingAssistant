package common;
import java.util.ArrayList;
import java.util.List;

public class RandomArrayElementsGetter {

    public <T> List<T> randomArrayElementsWithoutReps(List<T> list, int howManyElements){
        ArrayList<T> elementList = new ArrayList<>(list);
        ArrayList<T> resultList = new ArrayList<>();

        if(elementList.size() < howManyElements)
            return elementList;
        else if(elementList.size() == howManyElements){
            ArrayOrderMixer mixer = new ArrayOrderMixer();
            return mixer.getArrayInRandomOrder(list);
        }
        else {
            ArrayList<Integer> indexList = new ArrayList<>();
            for(int i = 0; i < elementList.size(); i++) {
                indexList.add(i);
            }
            for(int i = 0; i < howManyElements; i++){
                Dice dice  = new Dice(indexList.size());
                int roll = dice.roll() - 1;
                resultList.add(elementList.get(roll));
                indexList.remove(roll);
                elementList.remove(roll);
            }
        }
        return resultList;
    }

    public <T> List<T> randomArrayElementsWithReps(List<T> list, List<Integer> repList, int howManyElements){
        ArrayList<T> objectList = new ArrayList<>(list);
        ArrayList<Integer> repCountList = new ArrayList<>(repList);

        for(int i = 0; i < repCountList.size(); i++) {
            if (repCountList.get(i) == 0) {
                objectList.remove(i);
                repCountList.remove(i);
            }
        }

        if(objectList.size() > repCountList.size()){
            for(int i = 0; i < objectList.size() - repCountList.size(); i++){
                repCountList.add(1);
            }
        }
        else if(objectList.size() < repCountList.size()){
            repCountList = new ArrayList<>(repCountList.subList(0, objectList.size()));
        }

        List<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < objectList.size(); i++){
            indexList.add(i);
        }

        for(int i = 0; i < repCountList.size(); i++){
            for(int j = 1; j < repCountList.get(i); j++){
                objectList.add(objectList.get(i));
            }
        }

        List<T> randomsList = this.randomArrayElementsWithoutReps(objectList, howManyElements);
        List<T> resultList = new ArrayList<>();
        for(int i = 0; i < randomsList.size(); i++){
            resultList.add(randomsList.get(i));

        }
        return resultList;
    }

    public <T> List<T> randomArrayElementsWithReps(List<T> list, int reps, int howManyElements){
        List<Integer> repList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            repList.add(reps);
        }
        return this.randomArrayElementsWithReps(list, repList, howManyElements);
    }

    public <T> List<T> randomArrayElementsWithAnyReps(List<T> list, int howManyElements){
        List<T> elementList = new ArrayList<>();
        Dice dice = new Dice(list.size());
        for(int i = 0; i < howManyElements; i++){
            elementList.add(list.get(dice.roll() - 1));
        }
        return elementList;
    }
}
