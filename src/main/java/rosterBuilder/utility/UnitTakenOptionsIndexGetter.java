package rosterBuilder.utility;

import rosterBuilder.pojos.Unit;
import rosterBuilder.pojos.UnitProfile;

import java.util.ArrayList;
import java.util.List;

public class UnitTakenOptionsIndexGetter {

    private UnitTakenOptionsIndexGetter(){}

    public static List<List<Integer>> getTakenOptionsIndexes(Unit unit, UnitProfile unitProfile) {
        List<List<Integer>> takenOptionsIndexes = new ArrayList<>();

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
