package rosterBuilder.swingGUI;

import common.Refreshable;
import rosterBuilder.pojos.RosterObserverSubject;
import rosterBuilder.pojos.WargamingSystem;
import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.utility.RuleViolationLog;
import rosterBuilder.pojos.WargameSystemsInitializer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RosterDetachmentsPanel extends JPanel implements ActionListener, Refreshable {
    private JButton addDetachmentButton;
    private JButton readyButton;
    private JButton backButton;
    private ArrayList<DetachmentPanel> detachmentPanels;
    private ArrayList<JButton> deleteDetachmentButtons;
    private WargamingSystem wargamingSystem;
    private RosterObserverSubject roster;

    public RosterDetachmentsPanel(RosterObserverSubject roster, WargamingSystem system, int armyIndex) {
        this.roster = roster;
        this.wargamingSystem = system;
        this.addDetachmentButton = new JButton("Add Detachment");
        this.addDetachmentButton.addActionListener(this);
        this.readyButton = new JButton("Ready!");
        this.readyButton.addActionListener(this);
        this.backButton = new JButton("Go back");
        this.backButton.addActionListener(this);
        this.detachmentPanels = new ArrayList<>();
        this.deleteDetachmentButtons = new ArrayList<>();
        for (int i = 0; i < roster.getRoster().getDetachments().size(); i++) {
            DetachmentPanel detachmentPanel = new DetachmentPanel(
                    roster, roster.getRoster().getDetachments().get(i), wargamingSystem, i);
            this.detachmentPanels.add(detachmentPanel);
            this.roster.addRefreshable(detachmentPanel);
            JButton button = new JButton("Delete Detachment");
            button.addActionListener(this);
            this.deleteDetachmentButtons.add(button);
        }
        this.deleteDetachmentButtons.get(0).setVisible(false);
        if (system.getMaxDetachments() == 1){
            this.addDetachmentButton.setVisible(false);
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
        for(int i = 0; i < roster.getRoster().getDetachments().size(); i++){
            this.roster.removeRefreshable(this.detachmentPanels.get(i));
            DetachmentPanel detachmentPanel = new DetachmentPanel(roster, roster.getRoster().getDetachments().get(i),
                    wargamingSystem,  i);
            this.detachmentPanels.add(detachmentPanel);
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
        RosterBuilderWindow topFrame = (RosterBuilderWindow) SwingUtilities.getWindowAncestor(this);
        RuleViolationLog.clear();
        if(clicked == addDetachmentButton){
            if(this.wargamingSystem.getMaxDetachments() >= this.roster.getRoster().size()) {
                new DetachmentInfoDialog(this.wargamingSystem,
                        this.roster.getRoster(), this);
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(),
                        "You've reached maximal number of detachments.", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(clicked == readyButton){
            List<RosterBuildingRule> rules = this.wargamingSystem.getRules();

            if(roster.getRoster().getTotalCost() > roster.getRoster().getPointCap())
                RuleViolationLog.appendRosterRuleViolationLog("Point Limit Exceeded");

                for (RosterBuildingRule rule : rules) {
                    rule.check(roster.getRoster());
            }
            if(RuleViolationLog.getRosterRuleViolationLog().isEmpty()) {
                new RosterDisplayMenu(this.roster.getRoster());
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(), RuleViolationLog.getRosterRuleViolationLog(),
                        "Dialog", JOptionPane.ERROR_MESSAGE);
                RuleViolationLog.clear();
            }
        }
        else if(clicked == backButton){
            WargameSystemsInitializer initializer = new WargameSystemsInitializer();
            ArrayList<WargamingSystem> wargamingSystems = new ArrayList<>(initializer.initialize());
//            new SystemSelectionMenu(wargamingSystems, ModulesEnum.ROSTER_BUILDER);

            topFrame.dispose();
        }
        else
            for(int i = 0; i < detachmentPanels.size(); i++){
                if(clicked == deleteDetachmentButtons.get(i)){
                    roster.getRoster().removeDetachment(i);
                }
            }
    }
}
