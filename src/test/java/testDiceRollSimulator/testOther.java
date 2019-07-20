package testDiceRollSimulator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testOther {
    private ArrayList<Boolean> array0 = new ArrayList<>(Arrays.asList(true, false, false));
    private ArrayList<Boolean> array1 = new ArrayList<>(Arrays.asList(false, false, false));
    private ArrayList<Boolean> array2 = new ArrayList<>(Arrays.asList(true, false, false));
    private ArrayList<Boolean> array3 = new ArrayList<>(Arrays.asList(false, false, false));

    private ArrayList<ArrayList<Boolean>> total = new ArrayList<>(Arrays.asList(array0, array1, array2, array3));

    @Test
    void testLoop(){
        assertEquals(4, total.size());
//        for(int i = 0; i < total.size(); i++){
//            if(total.get(i).size() == 0){
//                total.remove(i);
//                i--;
//            }
//        }
        ArrayList<Integer> allFalseArraysIndexes = new ArrayList<>();
        for(int i = 0; i < total.size(); i++) {
            boolean isArrayAllFalse = true;
            for (int j = 0; j < total.get(i).size(); j++) {
                if(total.get(i).get(j))
                    isArrayAllFalse = false;
            }
            if(isArrayAllFalse)
                allFalseArraysIndexes.add(i);
        }
        Collections.reverse(allFalseArraysIndexes);

        for(int i = 0; i < allFalseArraysIndexes.size(); i++) {
            total.remove((int)allFalseArraysIndexes.get(i));
        }
        assertEquals(2, total.size());
        assertEquals(array0, total.get(0));
        assertEquals(array2, total.get(1));
    }
}
