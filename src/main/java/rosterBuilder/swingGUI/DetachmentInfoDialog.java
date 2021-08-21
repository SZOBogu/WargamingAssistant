package rosterBuilder.swingGUI;

import rosterBuilder.pojos.Detachment;
import rosterBuilder.pojos.Roster;
import rosterBuilder.pojos.WargamingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DetachmentInfoDialog extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel detachmentLabel;
    private JLabel armyLabel;
    private JComboBox detachmentComboBox;
    private JComboBox armyComboBox;
    private JButton submitButton;
    private RosterDetachmentsPanel rosterDetachmentsPanel;

    private WargamingSystem wargamingSystem;
    private Roster roster;


    public DetachmentInfoDialog(WargamingSystem wargamingSystem, Roster roster, RosterDetachmentsPanel rosterDetachmentsPanel){
        this.titleLabel = new JLabel("Detachment Form");
        this.detachmentLabel = new JLabel("Choose Detachment");
        this.armyLabel = new JLabel("Choose Detachment Army");
        this.roster = roster;
        this.wargamingSystem = wargamingSystem;
        this.submitButton = new JButton("Done");
        this.rosterDetachmentsPanel = rosterDetachmentsPanel;
        this.submitButton.addActionListener(this);
        ArrayList<String> detachmentNames = new ArrayList<>();
        for (int i = 0; i < wargamingSystem.getDetachments().size(); i++){
            detachmentNames.add(wargamingSystem.getDetachments().get(i).getName());
        }
        this.detachmentComboBox = new JComboBox(detachmentNames.toArray());
        if(roster.getPrimaryArmy().getAlliableArmyIndexes().size()>1){
            ArrayList<String> armies = new ArrayList<>();
            for(int i = 0; i < wargamingSystem.getArmies().size(); i++) {
                if(roster.getDetachments().get(0).getArmy().getAlliableArmyIndexes().contains(i))
                    armies.add(wargamingSystem.getArmy(i).getName());
            }
            this.armyComboBox = new JComboBox(armies.toArray());
        }
        else {
            this.armyComboBox = new JComboBox();
            this.armyComboBox.setVisible(false);
            this.armyLabel.setVisible(false);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        setSize(550, 200);
        setMaximumSize(new Dimension(1000, 1800));
        setVisible(true);
        this.layoutComponents();
    }

    public void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(this.titleLabel, gbc);
        gbc.gridy++;
        add(this.detachmentLabel, gbc);
        gbc.gridx++;
        add(this.detachmentComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(this.armyLabel, gbc);
        gbc.gridx++;
        add(this.armyComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        gbc.gridy++;
        add(this.submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Detachment detachment = this.wargamingSystem.getEmptyDetachment(this.detachmentComboBox.getSelectedIndex());
        detachment.setPool(this.wargamingSystem.getPool());
        detachment.setDetachmentNumber(this.roster.size());
        if (wargamingSystem.isAllowingAlliances()){
            detachment.setArmy(wargamingSystem.getArmy(
                    roster.getPrimaryArmy().getAlliableArmyIndexes().get(this.armyComboBox.getSelectedIndex())));
        }
        else
            detachment.setArmy(roster.getPrimaryArmy());
        roster.addDetachment(detachment);
        this.rosterDetachmentsPanel.refresh();
        this.dispose();
    }
}
