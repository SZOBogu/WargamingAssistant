package rosterBuilder.utility;

import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.entities.Detachment;

public class DetachmentRuleChecker {
    private DetachmentRuleChecker() {}

    public static void checkDetachment(Detachment detachment){
        if(detachment.getBoughtUnitsCategorized().size() == detachment.getArrayOfMandatoryChoicesInCategories().size() &&
                detachment.getBoughtUnitsCategorized().size() == detachment.getArrayOfMaxChoicesPerCategory().size()   &&
                detachment.getArrayOfMaxChoicesPerCategory().size() == detachment.getArrayOfMandatoryChoicesInCategories().size()){
            int size = detachment.getBoughtUnitsCategorized().size();

            for(int i = 0; i < size; i++){
                if(detachment.getBoughtUnitsCategorized().get(i).size() > detachment.getArrayOfMaxChoicesPerCategory().get(i)){
                    throw new RosterBuildingException("Too many units in detachment " + detachment.getDetachmentNumber());
                }
                if(detachment.getBoughtUnitsCategorized().get(i).size() < detachment.getArrayOfMandatoryChoicesInCategories().get(i)){
                    throw new RosterBuildingException("Too few units in detachment " + detachment.getDetachmentNumber());
                }
            }
        }
        else
            throw new RosterBuildingException("Detachment exception");
    }
}
