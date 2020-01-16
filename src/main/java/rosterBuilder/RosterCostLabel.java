package rosterBuilder;

import javax.swing.*;

public class RosterCostLabel extends JLabel {
    Roster roster;

    public RosterCostLabel(Roster roster){
        super("0/" + roster.getPointCap() + " points");
        this.roster = roster;
    }

    public void refresh(){
        RosterCostCalculator rosterCostCalculator = new RosterCostCalculator();
        this.setText(rosterCostCalculator.calculateRosterCost(this.roster) + "/" + roster.getPointCap() + " points");
    }
}
