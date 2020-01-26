package rosterBuilder;

import rosterBuilder.rules.UnitBuildingRule;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UnitProfilePanel extends JPanel implements ActionListener {
    private UnitProfile unitProfile;
    private Roster roster;
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

    public UnitProfilePanel(UnitProfile unitProfile, Roster roster, DetachmentPanel detachmentPanel, int detNumber, int categoryNumber, WargamingSystem wargamingSystem){
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
        SpinnerNumberModel modelQuantityModel = new SpinnerNumberModel(0, 0, unitProfile.getMaxModels() - unitProfile.getMinModels(), 1);
        this.modelQuantitySpinner = new JSpinner(modelQuantityModel);
        this.modelQuantitySpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                for(int i = 0; i < unitProfile.getOptionSets().size(); i++){
                    for(int j = 0; j < unitProfile.getOptionSets().get(i).getOptions().size(); j++){
                        if(unitProfile.getOptionSets().get(i).getOptions().get(j) instanceof QuantityDependentOption)
                            ((QuantityDependentOption) unitProfile.getOptionSets().get(i).getOptions().get(j)).setModelQuantity(unitProfile.getMinModels () + (int)modelQuantitySpinner.getValue());
                    }
                }
            }
        });
        this.addModelsLabel = new JLabel("You can add up to " + (unitProfile.getMaxModels() - unitProfile.getMinModels()) +
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

    public UnitProfilePanel(UnitProfile unitProfile, Roster roster, DetachmentPanel detachmentPanel, int detNumber, int categoryNumber, WargamingSystem wargamingSystem, ArrayList<ArrayList<Integer>> indexesToSelect){
        this(unitProfile, roster, detachmentPanel, detNumber, categoryNumber, wargamingSystem);
        for(int i = 0; i < indexesToSelect.size(); i++){
            this.optionPanelsPanel.getOptionPanels().get(indexesToSelect.get(i).get(0)).selectPreviouslyTaken(indexesToSelect.get(i).get(1));
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
            //TODO:moze jakis builder?
            Unit unit = new Unit(this.unitProfile.getName(), this.unitProfile.getMinModels() + (int)this.modelQuantitySpinner.getValue(),
                    this.optionPanelsPanel.getChosenEquipment(), this.unitProfile.getBaseEquipmentAndRules(), this.unitProfile.getInitialCost() + this.optionPanelsPanel.getChosenEquipmentCost() + ((int)this.modelQuantitySpinner.getValue() * this.unitProfile.getAdditionalModelCost()));
            ArrayList<UnitBuildingRule> rules = this.unitProfile.getRules();
            for (UnitBuildingRule rule : rules) {
                rule.check(unit);
            }
            if(RuleViolationLog.getUnitRuleViolationLog().isEmpty()) {
                roster.getDetachments().get(detNumber).addUnit(unit, categoryNumber);
                this.detachmentPanel.refresh();
                RosterBuilderWindow rosterBuilderWindow = new RosterBuilderWindow(this.wargamingSystem, this.roster);
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
            RosterBuilderWindow rosterBuilderWindow = new RosterBuilderWindow(this.wargamingSystem, this.roster);
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
    }
}
