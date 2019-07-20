package rosterBuilder;

import common.ModulesEnum;
import common.SystemSelectionMenu;
import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.rules.UnitBuildingRule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RosterDetachmentsPanel extends JPanel implements ActionListener {
    private JButton addDetachmentButton;
    private JButton readyButton;
    private JButton backButton;
    private ArrayList<DetachmentPanel> detachmentPanels;
    private ArrayList<JButton> deleteDetachmentButtons;
    private WargamingSystem wargamingSystem;
    private Roster roster;
    private int armyIndex;

    public RosterDetachmentsPanel(Roster roster, WargamingSystem system, int armyIndex) {
        this.roster = roster;
        this.wargamingSystem = system;
        this.armyIndex = armyIndex;
        this.addDetachmentButton = new JButton("Add Detachment");
        this.addDetachmentButton.addActionListener(this);
        this.readyButton = new JButton("Ready!");
        this.readyButton.addActionListener(this);
        this.backButton = new JButton("Go back");
        this.backButton.addActionListener(this);
        this.detachmentPanels = new ArrayList<>();
        this.deleteDetachmentButtons = new ArrayList<>();
        for (int i = 0; i < roster.getDetachments().size(); i++) {
            this.detachmentPanels.add(new DetachmentPanel(roster, roster.getDetachments().get(i), wargamingSystem, armyIndex, i));
            JButton button = new JButton("Delete Detachment");
            button.addActionListener(this);
            this.deleteDetachmentButtons.add(button);
        }
        this.deleteDetachmentButtons.get(0).setVisible(false);
        if (this.wargamingSystem.getMaxDetachments() == 1){
            this.addDetachmentButton.setVisible(false);;
        }
        this.layoutComponents();
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        for(int i = 0; i < this.detachmentPanels.size(); i++){
            add(this.detachmentPanels.get(i), gbc);
            gbc.gridy++;
            add(this.deleteDetachmentButtons.get(i), gbc);
            gbc.gridy++;
        }
        gbc.gridy+=3;
        add(this.addDetachmentButton, gbc);
        gbc.gridy++;
        add(this.readyButton, gbc);
        gbc.gridy++;
        add(this.backButton, gbc);
        gbc.gridy++;
    }

    public void refresh(){
        this.removeAll();
        this.detachmentPanels.clear();
        for(int i = 0; i < roster.getDetachments().size(); i++){
            this.detachmentPanels.add(new DetachmentPanel(roster, roster.getDetachments().get(i), wargamingSystem, armyIndex, i));
            JButton button = new JButton("Delete Detachment");
            button.addActionListener(this);
            this.deleteDetachmentButtons.add(button);
        }
        this.layoutComponents();
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton)actionEvent.getSource();
        RuleViolationLog.clear();
        if(clicked == addDetachmentButton){
            if(this.wargamingSystem.getMaxDetachments() >= this.roster.size()) {
                DetachmentInfoDialog detachmentInfoDialog = new DetachmentInfoDialog(this.wargamingSystem, this.roster, this);
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "You've reached maximal number of detachments.", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(clicked == readyButton){
            ArrayList<RosterBuildingRule> rules = this.wargamingSystem.getRules();
            if(roster.getTotalCost() > roster.getPointCap())
                RuleViolationLog.appendRosterRuleViolationLog("Point Limit Exceeded");
            for(int i = 0; i < rules.size(); i++){
                rules.get(i).check(roster);
            }
            if(RuleViolationLog.getRosterRuleViolationLog().isEmpty()) {
                RosterDisplayMenu rosterDisplayMenu = new RosterDisplayMenu(this.roster);
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(), RuleViolationLog.getRosterRuleViolationLog(), "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                RuleViolationLog.clear();
            }
        }
        else if(clicked == backButton){
            ArrayList<WargamingSystem> wargamingSystems = new ArrayList<>();
            WargameSystemsInitializer initializer = new WargameSystemsInitializer();
            wargamingSystems.addAll(initializer.initialize());
            SystemSelectionMenu systemSelectionMenu = new SystemSelectionMenu(wargamingSystems, ModulesEnum.ROSTER_BUILDER);
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
        else
            for(int i = 0; i < detachmentPanels.size(); i++){
                if(clicked == deleteDetachmentButtons.get(i)){
                    roster.removeDetachment(i);
                    refresh();
                }
            }
    }
}
