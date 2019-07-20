package rosterBuilder;

import java.util.ArrayList;

public class UnitCounter {
    public int countUnits(Roster roster){
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

    public int countUnitsNamed(Roster roster, String string){
        int count = 0;
        for(int i = 0; i < roster.size(); i++){         //po detkach
            for(int j = 0; j < roster.getDetachments().get(i).getBoughtUnitsCategorized().size(); j++){//po kategoriach
                for(int k = 0; k < roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).size(); k++){  //po unitach
                    Unit unit = roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).get(k);
                    if(string == unit.getName()) {
                        count += 1;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public int countUnitsWith(Roster roster, Entity entity){
        int count = 0;
        for(int i = 0; i < roster.size(); i++){         //po detkach
            for(int j = 0; j < roster.getDetachments().get(i).getBoughtUnitsCategorized().size(); j++){//po kategoriach
                for(int k = 0; k < roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).size(); k++){  //po unitach
                    Unit unit = roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).get(k);
                    ArrayList<Entity> temp = new ArrayList<>();
                    ArrayList<Entity> nonBase = unit.getNonBaseEquipment();
                    ArrayList<Entity> base = unit.getNonBaseEquipment();
                    temp.addAll(nonBase);
                    temp.addAll(base);
                    for(int l = 0; l < temp.size();l++){
                        if(temp.get(l).getName() == entity.getName()) {
                            count += 1;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int countUnitsWithAll(Roster roster, ArrayList<Entity> entities){
        int count = 0;
        int matchingEntitiesCounter = 0;
        for (int i = 0; i < roster.size(); i++) {         //po detkach
            for (int j = 0; j < roster.getDetachments().get(i).getBoughtUnitsCategorized().size(); j++) {//po kategoriach
                for (int k = 0; k < roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).size(); k++) {  //po unitach
                    Unit unit = roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).get(k);
                    ArrayList<Entity> temp = new ArrayList<>();
                    ArrayList<Entity> nonBase = unit.getNonBaseEquipment();
                    ArrayList<Entity> base = unit.getNonBaseEquipment();
                    temp.addAll(nonBase);
                    temp.addAll(base);
                    for(int l = 0; l < entities.size(); l++) {
                        if(temp.contains(entities.get(l))){
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

    public int countUnitsWithAny(Roster roster, ArrayList<Entity> entities) {
        int count = 0;
        for (int i = 0; i < roster.size(); i++) {         //po detkach
            for (int j = 0; j < roster.getDetachments().get(i).getBoughtUnitsCategorized().size(); j++) {//po kategoriach
                for (int k = 0; k < roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).size(); k++) {  //po unitach
                    Unit unit = roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).get(k);
                    ArrayList<Entity> temp = new ArrayList<>();
                    ArrayList<Entity> nonBase = unit.getNonBaseEquipment();
                    ArrayList<Entity> base = unit.getNonBaseEquipment();
                    temp.addAll(nonBase);
                    temp.addAll(base);
                    boolean isContainingAny = false;
                    for(int l = 0; l < entities.size(); l++) {
                        if(temp.contains(entities.get(l))){
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
