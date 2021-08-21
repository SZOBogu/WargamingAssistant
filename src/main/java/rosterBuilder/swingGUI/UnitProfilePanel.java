package rosterBuilder.swingGUI;

import rosterBuilder.*;
import rosterBuilder.Unit.UnitBuilder;
import rosterBuilder.swingGUI.DetachmentPanel;
import rosterBuilder.rules.UnitBuildingRule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UnitProfilePanel extends JPanel implements ActionListener {
    private UnitProfile unitProfile;
    private RosterObserverSubject roster;
    private int detNumber;
    private int categoryNumber;
    private WargamingSystem wargamingSystem;

    private JLabel headerLabel;
    private JLabel addModelsLabel;
    private TextArea modelPartTextArea;
    private OptionPanelsPanel optionPanelsPanel;
    private JSpinner modelQuantitySpinner;
    private DetachmentPanel detachmentPanel;
    private JButton cancelButton;
    private JButton addUnitButton;

    public UnitProfilePanel(UnitProfile unitProfile, RosterObserverSubject roster,
                            DetachmentPanel detachmentPanel, int detNumber, int categoryNumber,
                            WargamingSystem wargamingSystem){
        this.unitProfile = unitProfile;
        this.roster = roster;
        this.detNumber = detNumber;
        this.categoryNumber = categoryNumber;
        this.wargamingSystem = wargamingSystem;

        String string = unitProfile.getName() + "\t" + unitProfile.getInitialCost() + "p\n";
        if(unitProfile.getMinModels() == unitProfile.getMaxModels() && unitProfile.getMinModels() == 1)
            string += "Single model\n";
        else if(unitProfile.getMinModels() == unitProfile.getMaxModels())
            string += unitProfile.getMinModels() + " models\n";
        else {
            string += unitProfile.getMinModels() + "-" + unitProfile.getMaxModels() + " models\n";
        }
        this.headerLabel = new JLabel(string);
        SpinnerNumberModel modelQuantityModel = new SpinnerNumberModel(0, 0,
                unitProfile.getMaxModels() - unitProfile.getMinModels(), 1);
        this.modelQuantitySpinner = new JSpinner(modelQuantityModel);
        this.modelQuantitySpinner.addChangeListener(changeEvent -> {
            for(int i = 0; i < unitProfile.getOptionSets().size(); i++){
                for(int j = 0; j < unitProfile.getOptionSets().get(i).getOptions().size(); j++){
                    if(unitProfile.getOptionSets().get(i).getOptions().get(j) instanceof QuantityDependentOption)
                        ((QuantityDependentOption) unitProfile.getOptionSets().
                                get(i).getOptions().get(j)).
                                setModelQuantity(unitProfile.getMinModels () + (int)modelQuantitySpinner.getValue());
                }
            }
        });
        this.addModelsLabel = new JLabel("You can add up to " + (
                unitProfile.getMaxModels() - unitProfile.getMinModels()) +
                "models for " + unitProfile.getAdditionalModelCost() + "p");
        if(unitProfile.getMaxModels() == unitProfile.getMinModels()){
            this.modelQuantitySpinner.setVisible(false);
            this.addModelsLabel.setVisible(false);
        }
        this.modelPartTextArea = new TextArea(20, 70);
        this.modelPartTextArea.append(unitProfile.toString());
        this.optionPanelsPanel = new OptionPanelsPanel(unitProfile.getOptionSets());

        this.detachmentPanel = detachmentPanel;

        this.addUnitButton = new JButton("Add unit to roster");
        this.addUnitButton.addActionListener(this);
        this.cancelButton = new JButton("Cancel");
        this.cancelButton.addActionListener(this);

        this.layoutComponents();
    }

    public UnitProfilePanel(UnitProfile unitProfile, RosterObserverSubject roster, DetachmentPanel detachmentPanel,
                            int detNumber, int categoryNumber, WargamingSystem wargamingSystem,
                            List<List<Integer>> indexesToSelect){

        this(unitProfile, roster, detachmentPanel, detNumber, categoryNumber, wargamingSystem);
        for (List<Integer> integers : indexesToSelect) {
            this.optionPanelsPanel.getOptionPanels().get(integers.get(0)).selectPreviouslyTaken(integers.get(1));
        }
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.gridx = 0;

        add(this.headerLabel, gbc);
        gbc.gridy++;
        add(this.modelPartTextArea, gbc);
        gbc.gridy+=2;
        add(this.addModelsLabel, gbc);
        gbc.gridx++;
        add(this.modelQuantitySpinner, gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        add(this.optionPanelsPanel, gbc);
        gbc.gridy++;

        add(this.cancelButton, gbc);
        gbc.gridy++;

        add(this.addUnitButton, gbc);
        gbc.gridy++;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton)actionEvent.getSource();
        if(clicked == this.addUnitButton){
            Unit unit = new UnitBuilder(this.unitProfile.getName(), this.unitProfile.getBaseEquipmentAndRules())
                    .modelsInUnit(this.unitProfile.getMinModels() + (int)this.modelQuantitySpinner.getValue())
                    .nonBaseEquipment(this.optionPanelsPanel.getChosenEquipment())
                    .pointCost(this.unitProfile.getInitialCost() + this.optionPanelsPanel.getChosenEquipmentCost()
                                + ((int)this.modelQuantitySpinner.getValue() * this.unitProfile.getAdditionalModelCost()))
                    .build();

            ArrayList<UnitBuildingRule> rules = this.unitProfile.getRules();
            for (UnitBuildingRule rule : rules) {
                rule.check(unit);
            }
            if(RuleViolationLog.getUnitRuleViolationLog().isEmpty()) {
                roster.getRoster().getDetachments().get(detNumber).addUnit(unit, categoryNumber);
                this.detachmentPanel.refresh();
                new RosterBuilderWindow(this.wargamingSystem, this.roster);
                this.roster.refreshComponents();
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                topFrame.dispose();
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), RuleViolationLog.getUnitRuleViolationLog(), "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                RuleViolationLog.clear();
            }

        }
        else if(clicked == this.cancelButton){
            new RosterBuilderWindow(this.wargamingSystem, this.roster);
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
    }
}
