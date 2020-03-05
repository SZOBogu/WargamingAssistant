package rosterBuilder;

import java.util.ArrayList;

public class ModelCounter {
    public int countModels(Roster roster){
        int count = 0;
        for(int i = 0; i < roster.size(); i++){         //po detkach
            for(int j = 0; j < roster.getDetachments().get(i).getBoughtUnitsCategorized().size(); j++){//po kategoriach
                for(int k = 0; k < roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).size(); k++){  //po unitach
                    count += roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).get(k).getModelsInUnit();
                }
            }
        }
        return count;
    }

    public int countModelsNamed(Roster roster, String string){
        int count = 0;
        for(int i = 0; i < roster.size(); i++){         //po detkach
            for(int j = 0; j < roster.getDetachments().get(i).getBoughtUnitsCategorized().size(); j++){//po kategoriach
                for(int k = 0; k < roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).size(); k++){  //po unitach
                    Unit unit = roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).get(k);
                    if(string.equals(unit.getName())) {
                        count += unit.getModelsInUnit();
                        break;
                    }
                }
            }
        }
        return count;
    }

    public int countModelsWith(Roster roster, Entity entity){
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
                    for (Entity value : temp) {
                        if (value.getName().equals(entity.getName())) {
                            count += unit.getModelsInUnit();
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int countModelsWithAll(Roster roster, ArrayList<Entity> entities){
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
                        for (Entity entity : entities) {
                            if (temp.contains(entity)) {
                                matchingEntitiesCounter++;
                            }
                        }
                        if(matchingEntitiesCounter == entities.size()){
                            count += unit.getModelsInUnit();
                            matchingEntitiesCounter = 0;
                        }
                    }
                }
            }
        return count;
    }

    public int countModelsWithAny(Roster roster, ArrayList<Entity> entities) {
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
                    for (Entity entity : entities) {
                        if (temp.contains(entity)) {
                            isContainingAny = true;
                            break;
                        }
                    }
                    if(isContainingAny)
                        count += unit.getModelsInUnit();
                }
            }
        }
        return count;
    }
}
