package rosterBuilder;

import common.ModulesEnum;
import rosterBuilder.WargamingSystem;
import scenarioGenerator.ScenarioCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class RosterInfoDialog extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel armyLabel;
    private JLabel pointsLabel;
    private JLabel detachmentLabel;
    private JSpinner pointsSpinner;
    private JComboBox armyComboBox;
    private JComboBox detachmentComboBox;
    private JButton submitButton;

    private WargamingSystem wargamingSystem;
    private RosterObserverSubject roster;


    public RosterInfoDialog(WargamingSystem wargamingSystem, RosterObserverSubject roster){
        this.titleLabel = new JLabel("Roster Form");
        this.armyLabel = new JLabel("Choose your Army");
        this.pointsLabel = new JLabel("Choose maximal point cap");
        this.detachmentLabel = new JLabel("Choose Detachment");

        this.roster = roster;
        this.wargamingSystem = wargamingSystem;
        ArrayList<String> armies = new ArrayList<>();
        for(int i = 0; i < wargamingSystem.getArmies().size(); i++) {
            armies.add(wargamingSystem.getArmy(i).getName());
        }
        this.armyComboBox = new JComboBox(armies.toArray());
        SpinnerNumberModel pointsModel = new SpinnerNumberModel(1500, 10, 10000, 1);
        this.pointsSpinner= new JSpinner(pointsModel);
        this.submitButton = new JButton("Submit");
        this.submitButton.addActionListener(this);

        ArrayList<String> detachmentNames = new ArrayList<>();
        for (int i = 0; i < wargamingSystem.getDetachments().size(); i++){
            detachmentNames.add(wargamingSystem.getDetachments().get(i).getName());
        }
        this.detachmentComboBox = new JComboBox(detachmentNames.toArray());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(550, 200));
        setSize(550, 200);
        setMaximumSize(new Dimension(1000, 1800));
        setVisible(true);
        this.layoutComponents();
    }

    public void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        add(this.titleLabel, gbc);
        gbc.gridy++;
        add(this.armyLabel, gbc);
        gbc.gridx++;
        add(this.armyComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(this.detachmentLabel, gbc);
        gbc.gridx++;
        add(this.detachmentComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(this.pointsLabel, gbc);
        gbc.gridx++;
        add(this.pointsSpinner, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(this.submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
            roster.getRoster().setPointCap((int)this.pointsSpinner.getValue());
            roster.getRoster().setPrimaryArmy(this.wargamingSystem.getArmy(this.armyComboBox.getSelectedIndex()));
            Detachment detachment = this.wargamingSystem.getEmptyDetachment(this.detachmentComboBox.getSelectedIndex());
            detachment.setPool(this.wargamingSystem.getPool());
            roster.getRoster().addDetachment(detachment);
            roster.getRoster().getDetachments().get(0).setArmy(roster.getRoster().getPrimaryArmy());
            roster.getRoster().getDetachments().get(0).setDetachmentNumber(0);
            new RosterBuilderWindow(wargamingSystem, roster);
            this.dispose();
    }
}
