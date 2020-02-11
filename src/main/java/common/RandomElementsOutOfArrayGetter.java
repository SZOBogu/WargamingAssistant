package common;
import java.util.ArrayList;
import java.util.List;

public class RandomElementsOutOfArrayGetter {
    public List<Object> randomArrayWithoutReps(List<Object> list, int howManyElements){
        List<Object> resultList = new ArrayList<>();
        ArrayList<Object> elementList = new ArrayList<>(list);
        if(elementList.size() < howManyElements)
            return resultList;
        else{
            for(int i = 0; i < howManyElements; i++){
                Dice dice  = new Dice(elementList.size());
                int roll = dice.roll() - 1;
                resultList.add(elementList.get(roll));
                elementList.remove(roll);
            }
        }
        return resultList;
    }

    public List<Object> randomArrayWithReps(List<Object> list, List<Integer> repCountList, int howManyElements){
        List<Object> resultList = new ArrayList<>(list);

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

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < repCountList.get(i); j++){
                resultList.add(list.get(i));
            }
        }

        resultList = this.randomArrayWithoutReps(resultList, howManyElements);
        return resultList;
    }

    public List<Object> randomArrayWithReps(List<Object> list, int reps, int howManyElements){
        List<Object> resultList = new ArrayList<>();
        for(int i = 0; i < reps; i++){
            resultList.addAll(list);
        }
        resultList = this.randomArrayWithoutReps(resultList, howManyElements);
        return resultList;
    }

    public List<Object> randomArrayWithAnyReps(List<Object> list, int howManyElements){
        List<Object> resultList = new ArrayList<>();
        Dice dice = new Dice(list.size());
        for(int i = 0; i < howManyElements; i++){
            resultList.add(list.get(dice.roll() - 1));
        }
        return resultList;
    }
}
