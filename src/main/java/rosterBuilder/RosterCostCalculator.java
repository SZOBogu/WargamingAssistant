package rosterBuilder;

public class RosterCostCalculator {
    public int calculateRosterCost(Roster roster){
        int cost = 0;
        for(int i = 0; i < roster.size(); i++){     //po detachmentach
            for(int j = 0; j < roster.getDetachments().get(i).getArmy().getRelevantSlotCount(); j++){    //po kategoriach
                for(int k = 0; k < roster.getDetachments().get(i).getBoughtUnitsCategorized().get(j).size(); k++) { //pojednostkach
                    cost += roster.getDetachments().get(i).getUnit(j, k).getPointCost();
                }
            }
        }
        return  cost;
    }
}
