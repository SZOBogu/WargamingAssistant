package rosterBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnitCounter {
    public static int countUnits(Roster roster){
        int count = 0;
        for(int i = 0; i < roster.size(); i++){         //po detkach
            for(int j = 0; j < roster.getDetachments().get(i).getBoughtUnitsCategorized().size(); j++){//po kategoriach
                for(int k = 0; k < roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).size(); k++){  //po unitach
                    count += 1;
                }
            }
        }
        return count;
    }

    public static int countUnitsNamed(Roster roster, String string){
        int count = 0;
        for(int i = 0; i < roster.size(); i++){         //po detkach
            for(int j = 0; j < roster.getDetachments().get(i).getBoughtUnitsCategorized().size(); j++){//po kategoriach
                for(int k = 0; k < roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).size(); k++){  //po unitach
                    Unit unit = roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).get(k);
                    if(string.equals(unit.getName())) {
                        count += 1;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static int countUnitsWith(Roster roster, Entity entity){
        int count = 0;
        for(int i = 0; i < roster.size(); i++){         //po detkach
            for(int j = 0; j < roster.getDetachments().get(i).getBoughtUnitsCategorized().size(); j++){//po kategoriach
                for(int k = 0; k < roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).size(); k++){  //po unitach
                    Unit unit = roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).get(k);
                    List<Entity> temp = new ArrayList<>();
                    List<Entity> nonBase = unit.getNonBaseEquipment();
                    List<Entity> base = unit.getBaseEquipmentAndRules();
                    temp.addAll(nonBase);
                    temp.addAll(base);
                    for (Entity value : temp) {
                        if (Objects.equals(value.getName(), entity.getName())) {
                            count += 1;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int countUnitsWithAll(Roster roster, List<Entity> entities){
        int count = 0;
        int matchingEntitiesCounter = 0;

        for(Detachment detachment : roster.getDetachments()){
            for(List<Unit> boughtUnitCategory : detachment.getBoughtUnitsCategorized()){
                for(Unit unit : boughtUnitCategory){
                    List<Entity> allEquipmentAndRules = Stream.concat(unit.getBaseEquipmentAndRules().stream(), unit.getNonBaseEquipment().stream())
                            .collect(Collectors.toList());

                    for (Entity entity : entities) {
                        if (allEquipmentAndRules.contains(entity)) {
                            matchingEntitiesCounter++;
                        }
                    }
                    if(matchingEntitiesCounter == entities.size()){
                        count += 1;
                        matchingEntitiesCounter = 0;
                    }

                }
            }
        }
        return count;
    }

    public static int countUnitsWithAny(Roster roster, List<Entity> entities) {
        int count = 0;

        for(Detachment detachment : roster.getDetachments()){
            for(List<Unit> boughtUnitCategory : detachment.getBoughtUnitsCategorized()){
                for(Unit unit : boughtUnitCategory){
                    List<Entity> allEquipmentAndRules = Stream.concat(unit.getBaseEquipmentAndRules().stream(), unit.getNonBaseEquipment().stream())
                            .collect(Collectors.toList());

                    boolean isContainingAny = false;
                    for (Entity entity : entities) {
                        if (allEquipmentAndRules.contains(entity)) {
                            isContainingAny = true;
                            break;
                        }
                    }
                    if(isContainingAny)
                        count += 1;
                }
            }
        }
        return count;
    }
}
