package rosterBuilder;

import javax.swing.*;
import java.awt.*;

public class RosterBuilderWindow extends JFrame{
    private JLabel titleLabel;
    private RosterDetachmentsPanel rosterDetachmentsPanel;
    private RosterCostLabel rosterCostLabel;
    private Roster roster;


    public RosterBuilderWindow(WargamingSystem system, Roster roster){
        int armyIndex = 0;
        for(int i =0; i < system.getArmies().size(); i++){
            if(system.getArmies().get(i).getName() == roster.getPrimaryArmy().getName()){
                armyIndex = i;
            }
        }
        this.roster = roster;
        this.rosterDetachmentsPanel = new RosterDetachmentsPanel(roster, system, armyIndex);
        this.titleLabel = new JLabel("Roster Builder");
        this.rosterCostLabel = new RosterCostLabel(roster);

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
}
