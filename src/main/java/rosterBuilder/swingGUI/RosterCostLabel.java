package rosterBuilder.swingGUI;

import common.Refreshable;
import rosterBuilder.pojos.Roster;
import rosterBuilder.utility.RosterCostCalculator;

import javax.swing.*;

public class RosterCostLabel extends JLabel implements Refreshable {
    Roster roster;

    public RosterCostLabel(Roster roster){
        super("0/" + roster.getPointCap() + " points");
        this.roster = roster;
    }

    public void refresh(){
        this.setText(RosterCostCalculator.calculateRosterCost(this.roster) + "/" + roster.getPointCap() + " points");
    }
}
