package rosterBuilder.swingGUI;

import rosterBuilder.pojos.ArmySubcategory;
import rosterBuilder.pojos.RosterObserverSubject;
import rosterBuilder.pojos.UnitProfile;
import rosterBuilder.pojos.WargamingSystem;
import rosterBuilder.utility.UnitCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UnitSelectionMenu extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private List<JButton> unitButtons;

    private ArmySubcategory armySubcategory;
    private RosterObserverSubject roster;
    private DetachmentPanel detachmentPanel;
    private int detNumber;
    private int categoryNumber;
    private WargamingSystem wargamingSystem;

    public UnitSelectionMenu(ArmySubcategory armySubcategory, RosterObserverSubject roster,
                             DetachmentPanel detachmentPanel, int detNumber, int categoryNumber,
                             WargamingSystem wargamingSystem){
        this.unitButtons = new ArrayList<>();
        this.armySubcategory = armySubcategory;
        this.roster = roster;
        this.detachmentPanel = detachmentPanel;
        this.detNumber = detNumber;
        this.categoryNumber = categoryNumber;
        this.wargamingSystem = wargamingSystem;
        this.titleLabel = new JLabel("Choose Unit from " + this.armySubcategory.getName() + " category.");

        for(int i = 0; i < armySubcategory.size(); i++){
            String textOnButton;
            if(armySubcategory.getUnitProfile(i).getUnitsPerArmy() < 100)
                textOnButton = armySubcategory.getUnitProfile(i).getName() +
                        " (max " + armySubcategory.getUnitProfile(i).getUnitsPerArmy() + " units)";
            else
                textOnButton = armySubcategory.getUnitProfile(i).getName();
            JButton button = new JButton(textOnButton);
            button.addActionListener(this);
            this.unitButtons.add(button);
            if(UnitCounter.countUnitsNamed(roster.getRoster(),
                    armySubcategory.getUnitProfile(i).getName()) >=armySubcategory.getUnitProfile(i).getUnitsPerArmy())
                button.setVisible(false);       //TODO: cos tu nie gra
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        setSize(400, 200);
        setMaximumSize(new Dimension(1000, 1800));
        setVisible(true);
        this.layoutComponents();
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;

        add(this.titleLabel, gbc);
        gbc.gridy++;
        for (JButton unitButton : this.unitButtons) {
            add(unitButton, gbc);
            gbc.gridy++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton)actionEvent.getSource();
        UnitProfile unitProfile = null;
        for(int i = 0; i < unitButtons.size(); i++){
            if(clicked == this.unitButtons.get(i)){
                unitProfile = this.armySubcategory.getUnitProfile(i);
            }
        }
        new UnitProfileFrame(unitProfile, this.roster,
                this.detachmentPanel, this.detNumber, this.categoryNumber, this.wargamingSystem);
        this.dispose();
    }
}