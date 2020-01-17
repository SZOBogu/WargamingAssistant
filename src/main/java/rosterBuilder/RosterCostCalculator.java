package rosterBuilder;

public class RosterCostCalculator {
    //TODO:test
    public int calculateCategoryCost(Roster roster, int detachmentNumber,int categoryNumber){
        int cost = 0;
        for(int k = 0; k < roster.getDetachments().get(detachmentNumber).getBoughtUnitsCategorized().get(categoryNumber).size(); k++) { //pojednostkach
            cost += roster.getDetachments().get(detachmentNumber).getUnit(categoryNumber, k).getPointCost();
        }
        return  cost;
    }

    //TODO: null pointer exception
    public int calculateRosterCost(Roster roster){
        int cost = 0;
        for(int i = 0; i < roster.size(); i++){     //po detachmentach
            for(int j = 0; j < roster.getDetachments().get(i).getArmy().getRelevantSlotCount(); j++){    //po kategoriach
                cost += this.calculateCategoryCost(roster, i, j);
            }
        }
        return  cost;
    }
}
