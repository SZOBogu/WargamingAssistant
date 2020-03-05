package rosterBuilder;

import java.util.ArrayList;

public class UnitTakenOptionsIndexGetter {
    public ArrayList<ArrayList<Integer>> getTakenOptionsIndexes(Unit unit, UnitProfile unitProfile) {
        ArrayList<ArrayList<Integer>> takenOptionsIndexes = new ArrayList<>();

        for (int i = 0; i < unitProfile.getOptionSets().size(); i++) {
            for (int j = 0; j < unitProfile.getOptionSets().get(i).getOptions().size(); j++) {
                if (unit.getNonBaseEquipment().contains(unitProfile.getOptionSets()
                        .get(i).getOptions().get(j).getEntity())) {
                    takenOptionsIndexes.add(new ArrayList<>());
                    takenOptionsIndexes.get(takenOptionsIndexes.size() - 1).add(i);
                    takenOptionsIndexes.get(takenOptionsIndexes.size() - 1).add(j);
                }
            }
        }
        return takenOptionsIndexes;
    }
}
