package rosterBuilder.utility;

import rosterBuilder.entities.Unit;
import rosterBuilder.entities.UnitProfile;

import java.util.ArrayList;
import java.util.List;

public class UnitTakenOptionsIndexGetter {

    private UnitTakenOptionsIndexGetter(){}

    public static List<List<Integer>> getTakenOptionsIndexes(Unit unit, UnitProfile unitProfile) {
        List<List<Integer>> takenOptionsIndexes = new ArrayList<>();

        for (int i = 0; i < unitProfile.getOptions().size(); i++) {
            for (int j = 0; j < unitProfile.getOptions().get(i).getOptions().size(); j++) {
                if (unit.getNonBaseEquipment().contains(unitProfile.getOptions()
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
