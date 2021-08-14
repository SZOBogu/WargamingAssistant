package common;

import java.util.ArrayList;
import java.util.List;

public class ArrayElementsWithRepsCounter {
    public static <T> int count(List<T> elements, int reps){
        List<Integer> reppedList = new ArrayList<>();

        for(int i = 0; i < elements.size(); i ++){
            reppedList.add(reps);
        }
        return ArrayElementsWithRepsCounter.count(elements, reppedList);
    }

    public static <T> int count(List<T> elements, List<Integer> repList){
        int count = 0;

        if(elements.size() > repList.size()){
            for(int i = 0; i < repList.size(); i ++) {
                repList.add(1);
            }
        }
        else if(elements.size() < repList.size()){
            repList = repList.subList(0, elements.size());
        }

        for(int i = 0; i < elements.size(); i++){
            if(repList.get(i) > 0)
                count += repList.get(i);
        }
        return count;
    }

    public static <T> int count2D(ArrayList<ArrayList<T>> elements, int reps){
        int count = 0;

        for (ArrayList<T> element : elements) {
            count += ArrayElementsWithRepsCounter.count(element, reps);
        }
        return count;
    }

    public static <T> int count2D(ArrayList<ArrayList<T>> elements, ArrayList<ArrayList<Integer>> repList){
        int count = 0;

        for(int i = 0; i < elements.size(); i++){
            count += ArrayElementsWithRepsCounter.count(elements.get(i), repList.get(i));
        }
        return count;
    }
}
