package rosterBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OptionPanelsPanel extends JPanel {
    private ArrayList<OptionPanel> optionPanels;

    public OptionPanelsPanel(ArrayList<OptionSet> optionSets){
        this.optionPanels = new ArrayList<>();
        for(int i = 0; i < optionSets.size(); i++){
            optionPanels.add(new OptionPanel(optionSets.get(i)));
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

        for(int i = 0; i < optionPanels.size(); i++){
            add(optionPanels.get(i), gbc);
            gbc.gridy++;
        }
    }

    public ArrayList<Entity> getChosenEquipment(){
        ArrayList<Entity> chosenEquipment = new ArrayList<>();
        for(int i = 0; i < this.optionPanels.size(); i++){
            chosenEquipment.addAll(this.optionPanels.get(i).getChosenEntities());
        }
        return chosenEquipment;
    }

    public int getChosenEquipmentCost(){
        int chosenEquipmentCost = 0;
        for(int i = 0; i < this.optionPanels.size(); i++){
             chosenEquipmentCost += this.optionPanels.get(i).getTotalCost();
        }
        return chosenEquipmentCost;
    }
}
