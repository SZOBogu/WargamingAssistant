package rosterBuilder;

import common.Refreshable;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class RosterBuilderWindow extends JFrame implements Refreshable{
    private JLabel titleLabel;
    private RosterDetachmentsPanel rosterDetachmentsPanel;
    private RosterCostLabel rosterCostLabel;

    public RosterBuilderWindow(WargamingSystem system, RosterObserverSubject roster){
        int armyIndex = 0;
        for(int i =0; i < system.getArmies().size(); i++){
            if(system.getArmies().get(i).getName().equals(roster.getRoster().getPrimaryArmy().getName())){
                armyIndex = i;
            }
        }
        this.rosterDetachmentsPanel = new RosterDetachmentsPanel(roster, system, armyIndex);
        this.titleLabel = new JLabel("Roster Builder");
        this.rosterCostLabel = new RosterCostLabel(roster.getRoster());

        roster.addRefreshable(rosterCostLabel);

        setMinimumSize(new Dimension(800, 600));
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.layoutComponents();
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(this.titleLabel, gbc);
        gbc.gridy++;
        add(this.rosterCostLabel, gbc);
        gbc.gridy++;
        add(this.rosterDetachmentsPanel, gbc);
    }

    @Override
    public void refresh() {
        this.rosterCostLabel.refresh();
    }
}
