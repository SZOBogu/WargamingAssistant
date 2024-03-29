package scenarioGenerator.utility;

import java.util.ArrayList;
import java.util.List;

public class BoolListToIndexListConverter {

    private BoolListToIndexListConverter(){}

    public static List<Integer> convertList(List<Boolean> booleansArray){
        List<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < booleansArray.size(); i++){
            if(booleansArray.get(i)) indexList.add(i);
        }
        return indexList;
    }

    public static List<List<Integer>> convert2dList(List<List<Boolean>> booleansArraysArray){
        List<List<Integer>> convertedList = new ArrayList<>();
        for (List<Boolean> booleans : booleansArraysArray) {
            convertedList.add(convertList(booleans));
        }
        return convertedList;
    }
}
