package rosterBuilder;

import scenarioGenerator.BoolToListIndexConverter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OptionPanel extends JPanel {
    private JLabel descriptionLabel;
    private OptionSet optionSet;
    private ArrayList<JRadioButton> optionButtons;
    private OneOrZeroButtonGroup buttonGroup;
    public OptionPanel(OptionSet optionSet){
        this.optionSet = optionSet;
        this.descriptionLabel = new JLabel(optionSet.getDescription());
        this.optionButtons = new ArrayList<>();
        this.buttonGroup = new OneOrZeroButtonGroup();
        for(int i = 0; i < optionSet.getAllEntities().size(); i++){
            JRadioButton button = new JRadioButton(optionSet.getOptions().get(i).toString());
            optionButtons.add(button);
            if(optionSet instanceof SingleChoiceOptionSet){
                this.buttonGroup.add(button);
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
        for (int i = 0; i < this.optionButtons.size(); i++) {
            add(this.optionButtons.get(i), gbc);
            gbc.gridy++;
        }
    }

    private ArrayList<Integer> getCheckedIndexes(){
        ArrayList<Boolean> areButtonsChosen = new ArrayList<>();
        for(int i = 0; i < this.optionButtons.size(); i++){
            areButtonsChosen.add(this.optionButtons.get(i).isSelected());
        }
        BoolToListIndexConverter converter =  new BoolToListIndexConverter();
        ArrayList<Integer> chosenEntitiesIndex = converter.convert(areButtonsChosen);

        return chosenEntitiesIndex;
    }

    public ArrayList<Entity> getChosenEntities(){
        ArrayList<Entity> chosenEntities =new ArrayList<>();
        ArrayList<Integer> chosenEquipmentIndexes = this.getCheckedIndexes();

        for(int i = 0; i < chosenEquipmentIndexes.size(); i++){
            chosenEntities.add(optionSet.getAllEntities().get(chosenEquipmentIndexes.get(i)));
        }
        if(chosenEntities.isEmpty() && this.optionSet.isMandatory){
            RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();
            ruleViolationLog.appendUnitRuleViolationLog("Mandatory option not taken.");
        }
        return chosenEntities;
    }

    public int getTotalCost() {
        int totalCost = 0;
        ArrayList<Integer> chosenEquipmentIndexes = this.getCheckedIndexes();

        for (int i = 0; i < chosenEquipmentIndexes.size(); i++) {
            totalCost += optionSet.getOptions().get(chosenEquipmentIndexes.get(i)).getCost();
        }
        return totalCost;
    }

    public void selectPreviouslyTaken(int index){
        this.buttonGroup.buttons.get(index).setSelected(true);
    }
}
