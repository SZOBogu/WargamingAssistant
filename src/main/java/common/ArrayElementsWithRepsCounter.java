package common;

import java.util.ArrayList;
import java.util.List;

public class ArrayElementsWithRepsCounter {
    public <T> int count(List<T> elements, int reps){
        List<Integer> reppedList = new ArrayList();

        for(int i = 0; i < elements.size(); i ++){
            reppedList.add(reps);
        }
        return this.count(elements, reppedList);
    }

    public <T> int count(List<T> elements, List<Integer> repList){
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

    public <T> int count2D(List<List<T>> elements, int reps){
        return -1;
    }

    public <T> int count2D(List<List<T>> elements, List<T> repList){
        return -1;
    }
}
