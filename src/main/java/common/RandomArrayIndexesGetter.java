package common;
import java.util.ArrayList;
import java.util.List;

public class RandomArrayIndexesGetter {
    public List<Integer> getIndexesThatWereDuplicated(List<Object> list, List<Integer> indexList, List<Integer> repList, int originalSize){
        ArrayList<Integer> indexArrayList = new ArrayList<>(indexList);
        ArrayList<Integer> originalList = new ArrayList<>(indexArrayList.subList(0, originalSize));
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            indexes.add(i);
        }

        List<Integer> tempList = new ArrayList<>(originalList);
        for(int i = 0; i < repList.size(); i++){
            for(int j = 1; j < repList.get(i); j++){
                tempList.add(indexes.get(i));
            }
        }                                               //stara metoda konczy sie tutaj

        List<Integer> dedubbedList = new ArrayList<>();
        for(int i = 0; i < indexArrayList.size(); i++){
            dedubbedList.add(tempList.get(indexArrayList.get(i)));
        }
        List<Integer> resultList = new ArrayList<>();

        for(int i = 0; i < indexArrayList.size(); i++){
            resultList.add(dedubbedList.get(i));
        }
        return resultList;
    }

    public List<Integer> randomArrayIndexesWithoutReps(List<Object> list, int howManyElements){
        List<Integer> indexList = new ArrayList<>();
        ArrayList<Object> elementList = new ArrayList<>(list);
        if(elementList.size() < howManyElements)
            return indexList;
        else if(elementList.size() == howManyElements){
            ArrayOrderMixer mixer = new ArrayOrderMixer();
            return mixer.getArrayIndexesInRandomOrder(list);
        }
        else {
            ArrayList<Integer> tempList = new ArrayList<>(); //list of subsequent indexes
            for(int i = 0; i < elementList.size(); i++) {
                tempList.add(i);
            }
            for(int i = 0; i < howManyElements; i++){
                Dice dice  = new Dice(tempList.size());
                int roll = dice.roll() - 1;
                indexList.add(tempList.get(roll));
                tempList.remove(roll);
            }
        }
        return indexList;
    }

    public List<Integer> randomArrayIndexesWithReps(List<Object> list, List<Integer> repList, int howManyElements){
        int listSize = list.size();
        List<Object> objectList = new ArrayList<>(list);
        List<Integer> repCountList = new ArrayList<>(repList);

        for(int i = 0; i < repCountList.size(); i++) {
            if (repCountList.get(i) < 1) {
                objectList.remove(i);
                repCountList.remove(i);
            }
        }

        if(list.size() > repCountList.size()){
            for(int i = 0; i < list.size() - repCountList.size(); i++){
                repCountList.add(1);
            }
        }
        else if(list.size() < repCountList.size()){
            for(int i = 0; i < repCountList.size() - list.size(); i++){
                repCountList.remove(repCountList.size() - 1);
            }
        }
        for(int i = 0; i < repCountList.size(); i++) {
                for (int j = 1; j < repCountList.get(i); j++) {
                    objectList.add(objectList.get(i));
                }
        }

        List<Integer> indexes = this.randomArrayIndexesWithoutReps(objectList, howManyElements);
        indexes = this.getIndexesThatWereDuplicated(list ,indexes, repCountList, listSize);

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < indexes.size(); i++) {
            resultList.add((Integer)objectList.get(indexes.get(i)));
        }
        return indexes;
    }

    public List<Integer> randomArrayIndexesWithReps(List<Object> list, int reps, int howManyElements){
        List<Integer> repList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            repList.add(reps);
        }
        return this.randomArrayIndexesWithReps(list, repList, howManyElements);
    }

    public List<Integer> randomArrayIndexesWithAnyReps(List<Object> list, int howManyElements){
        List<Object> objectList = new ArrayList<>();
        Dice dice = new Dice(list.size());
        for(int i = 0; i < howManyElements; i++){
            objectList.add(list.get(dice.roll() - 1));
        }
        return this.randomArrayIndexesWithoutReps(objectList, howManyElements);
    }
}
