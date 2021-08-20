package rosterBuilder.swingGUI;

import common.Refreshable;
import rosterBuilder.Roster;
import rosterBuilder.RosterCostCalculator;

import javax.swing.*;

public class RosterCostLabel extends JLabel implements Refreshable {
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
