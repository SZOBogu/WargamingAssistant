package rosterBuilder;

import java.util.ArrayList;

public class UnitTakenOptionsIndexGetter {
    public ArrayList<ArrayList<Integer>> getTakenOptionsIndexes(Unit unit, UnitProfile unitProfile) {
        ArrayList<ArrayList<Integer>> takenOptionsIndexes = new ArrayList<>();

        for (int i = 0; i < unitProfile.getOptionSets().size(); i++) {
            for (int j = 0; j < unitProfile.getOptionSets().get(i).getOptions().size(); j++) {
                if (unit.getNonBaseEquipment().contains(unitProfile.getOptionSets().get(i).getOptions().get(j).getEntity())) {
                    takenOptionsIndexes.add(new ArrayList<>());
                    takenOptionsIndexes.get(takenOptionsIndexes.size() - 1).add(i);
                    takenOptionsIndexes.get(takenOptionsIndexes.size() - 1).add(j);
                }
            }
        }
        return takenOptionsIndexes;
    }
}
//        ArrayList<ArrayList<Integer>> takenOptionsIndexes = new ArrayList<>();
//        for(int i = 0; i < unitProfile.getOptionSets().size(); i++){
//            takenOptionsIndexes.add(new ArrayList<>());
//        }
//
//        System.out.println("size:" + takenOptionsIndexes.size());
//
//        for(int i = 0; i < takenOptionsIndexes.size(); i++) {
//            System.out.println("row " + i + ":");
//            for (int j = 0; j < takenOptionsIndexes.size(); j++) {
//                System.out.println(takenOptionsIndexes.get(i).get(j));
//            }
//            System.out.println("\n");
//        }
//
//        System.out.println("actual function");
//
//        for(int i = 0; i < unitProfile.getOptionSets().size(); i++){
//            for(int j = 0; j < unitProfile.getOptionSets().get(i).getOptions().size(); j++){
//                if(unit.getNonBaseEquipment().contains(unitProfile.getOptionSets().get(i).getOptions().get(j).getEntity())){
//                    takenOptionsIndexes.get(i).add(j);
//                }
//            }
//        }
//        for(int i = 0; i < unitProfile.getOptionSets().size(); i++) {
//            System.out.println("row " + i + ":");
//            for (int j = 0; j < unitProfile.getOptionSets().get(i).getOptions().size(); j++) {
//                System.out.println(takenOptionsIndexes.get(i).get(j));
//            }
//            System.out.println("\n");
//        }
//        return takenOptionsIndexes;
//    }
//}
