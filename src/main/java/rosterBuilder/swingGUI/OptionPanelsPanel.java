package rosterBuilder.swingGUI;

import rosterBuilder.pojos.Entity;
import rosterBuilder.pojos.OptionSet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OptionPanelsPanel extends JPanel {
    private final List<OptionPanel> optionPanels;

    public OptionPanelsPanel(List<OptionSet> optionSets){
        this.optionPanels = new ArrayList<>();
        for (OptionSet optionSet : optionSets) {
            optionPanels.add(new OptionPanel(optionSet));
        }
        this.layoutComponents();
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;

        for (OptionPanel optionPanel : optionPanels) {
            add(optionPanel, gbc);
            gbc.gridy++;
        }
    }

    public List<Entity> getChosenEquipment(){
        List<Entity> chosenEquipment = new ArrayList<>();
        for (OptionPanel optionPanel : this.optionPanels) {
            chosenEquipment.addAll(optionPanel.getChosenEntities());
        }
        return chosenEquipment;
    }

    public int getChosenEquipmentCost(){
        int chosenEquipmentCost = 0;
        for (OptionPanel optionPanel : this.optionPanels) {
            chosenEquipmentCost += optionPanel.getTotalCost();
        }
        return chosenEquipmentCost;
    }

    public List<OptionPanel> getOptionPanels() {
        return optionPanels;
    }
}
