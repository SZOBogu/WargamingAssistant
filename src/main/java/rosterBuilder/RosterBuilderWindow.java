package rosterBuilder;

import javax.swing.*;
import java.awt.*;

public class RosterBuilderWindow extends JFrame{
    private JLabel titleLabel;
    private RosterDetachmentsPanel rosterDetachmentsPanel;
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
        setLayout(new BorderLayout());
        add(this.titleLabel, BorderLayout.NORTH);
        add(new JScrollPane(this.rosterDetachmentsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);

        setMinimumSize(new Dimension(800, 600));
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
