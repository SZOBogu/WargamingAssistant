package scenarioGenerator;

import java.util.ArrayList;

public class BoolToListIndexConverter {
    public ArrayList<Integer> convert(ArrayList<Boolean> booleansArray){
        ArrayList<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < booleansArray.size(); i++){
            if(booleansArray.get(i)) indexList.add(i);
        }
        return indexList;
    }

    public ArrayList<ArrayList<Integer>> convertList(ArrayList<ArrayList<Boolean>> booleansArraysArray){
        ArrayList<ArrayList<Integer>> convertedList = new ArrayList<>();
        for(int i = 0; i < booleansArraysArray.size(); i++){
            convertedList.add(convert(booleansArraysArray.get(i)));
        }
        return convertedList;
    }
}
