package rosterBuilder;

public class RosterCostCalculator {
    public int calculateCategoryCost(Roster roster, int detachmentNumber,int categoryNumber){
        int cost = 0;
        for(int i = 0; i < roster.getDetachments().get(detachmentNumber).getBoughtUnitsCategorized().get(categoryNumber).size(); i++){
            cost += roster.getDetachments().get(detachmentNumber).getBoughtUnitsCategorized().get(categoryNumber).get(i).getPointCost();
        }
        return cost;
    }

    //TODO: null pointer exception
    public int calculateRosterCost(Roster roster){
        int cost = 0;
        for(int i = 0; i < roster.getDetachments().size(); i++){
            for(int j = 0; j < roster.getDetachments().get(i).getBoughtUnitsCategorized().size(); j++){
                cost += this.calculateCategoryCost(roster, i,j);
            }
        }
        return cost;
    }
}
