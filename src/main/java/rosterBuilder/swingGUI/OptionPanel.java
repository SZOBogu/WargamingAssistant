package rosterBuilder.swingGUI;

import rosterBuilder.Entity;
import rosterBuilder.OptionSet;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.SingleChoiceOptionSet;
import scenarioGenerator.helpers.BoolListToIndexListConverter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OptionPanel extends JPanel {
    private JLabel descriptionLabel;
    private OptionSet optionSet;
    private List<JRadioButton> optionButtons;

    public OptionPanel(OptionSet optionSet){
        this.optionSet = optionSet;
        this.descriptionLabel = new JLabel(optionSet.getDescription());
        this.optionButtons = new ArrayList<>();
        OneOrZeroButtonGroup buttonGroup = new OneOrZeroButtonGroup();
        for(int i = 0; i < optionSet.getAllEntities().size(); i++){
            JRadioButton button = new JRadioButton(optionSet.getOptions().get(i).toString());
            optionButtons.add(button);
            if(optionSet instanceof SingleChoiceOptionSet){
                buttonGroup.add(button);
            }
        }
        this.layoutComponents();
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;

        add(this.descriptionLabel, gbc);
        gbc.gridy++;
        for (JRadioButton optionButton : this.optionButtons) {
            add(optionButton, gbc);
            gbc.gridy++;
        }
    }

    private List<Integer> getCheckedIndexes(){
        List<Boolean> areButtonsChosen = new ArrayList<>();
        for (JRadioButton optionButton : this.optionButtons) {
            areButtonsChosen.add(optionButton.isSelected());
        }

        return BoolListToIndexListConverter.convertList(areButtonsChosen);
    }

    public List<Entity> getChosenEntities(){
        List<Entity> chosenEntities = new ArrayList<>();
        List<Integer> chosenEquipmentIndexes = this.getCheckedIndexes();

        for (Integer chosenEquipmentIndex : chosenEquipmentIndexes) {
            chosenEntities.add(optionSet.getAllEntities().get(chosenEquipmentIndex));
        }
        if(chosenEntities.isEmpty() && this.optionSet.isMandatory()){
            RuleViolationLog.appendUnitRuleViolationLog("Mandatory option not taken.");
        }
        return chosenEntities;
    }

    public int getTotalCost() {
        int totalCost = 0;
        List<Integer> chosenEquipmentIndexes = this.getCheckedIndexes();

        for (Integer chosenEquipmentIndex : chosenEquipmentIndexes) {
            totalCost += optionSet.getOptions().get(chosenEquipmentIndex).getCost();
        }
        return totalCost;
    }

    public void selectPreviouslyTaken(int index){
        this.optionButtons.get(index).setSelected(true);
    }
}
