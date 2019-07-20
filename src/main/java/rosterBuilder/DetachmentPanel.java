package rosterBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DetachmentPanel extends JPanel implements ActionListener {
    private JLabel detachmentInfoLabel;
   // private JButton deleteDetachmentButton;
    private ArrayList<JLabel> categoryLabels;
    private ArrayList<ArrayList<JLabel>> unitLabels;
    private ArrayList<ArrayList<JButton>> addUnitButtons;
    private ArrayList<ArrayList<JButton>> removeUnitButtons;
    private boolean isLooseDetachment;
    private Detachment detachment;
    private Roster roster;
    private WargamingSystem wargamingSystem;
    private int armyIndex;

    public DetachmentPanel(Roster roster, Detachment detachment, WargamingSystem system, int armyIndex, int detachmentIndex){
        this.detachmentInfoLabel = new JLabel("Detachment " + detachmentIndex + ": " + detachment.getName());
        this.detachment = detachment;
        this.roster = roster;
        this.wargamingSystem = system;
        this.armyIndex = armyIndex;
        this.categoryLabels = new ArrayList<>();
        this.unitLabels = new ArrayList<>();
        this.addUnitButtons = new ArrayList<>();
        this.removeUnitButtons = new ArrayList<>();

         for(int i = 0; i < detachment.getArmy().getRelevantSlotCount();i++){
                this.categoryLabels.add(new JLabel(detachment.getArmy().getArmySubcategory(i).getName(), SwingConstants.CENTER));
                this.unitLabels.add(new ArrayList<>());
                this.addUnitButtons.add(new ArrayList<>());
                this.removeUnitButtons.add(new ArrayList<>());
        }
        ArrayList<Integer> arrayOfMandatoryChoicesInCategories = detachment.getArrayOfMandatoryChoicesInCategories();
        ArrayList<Integer> arrayOfMaxChoicesPerCategory = detachment.getArrayOfMaxChoicesPerCategory();
        this.isLooseDetachment = this.determineLayoutStyle(arrayOfMandatoryChoicesInCategories, arrayOfMaxChoicesPerCategory);
         if(!this.isLooseDetachment) {
             for (int i = 0; i < detachment.getArmy().getRelevantSlotCount(); i++) {
                 for (int j = 0; j < arrayOfMaxChoicesPerCategory.get(i); j++) {
                     JButton addButton = new JButton("Add new Unit");
                     JButton removeButton = new JButton("Remove Unit");
                     addButton.addActionListener(this);
                     removeButton.addActionListener(this);
                     this.addUnitButtons.get(i).add(addButton);
                     this.removeUnitButtons.get(i).add(removeButton);
                     this.unitLabels.get(i).add(new JLabel());
                 }
             }
         }
         else{
             for(int i = 0; i < detachment.getArmy().getRelevantSlotCount(); i++) {
                 JButton addButton = new JButton("Add new Unit");
                 addButton.addActionListener(this);
                 this.addUnitButtons.get(i).add(addButton);
                 //UnitCounter counter = new UnitCounter();
                 for(int j = 0; j < detachment.getBoughtUnitsCategorized().get(i).size(); j++) {
                     this.unitLabels.get(i).add(new JLabel());
                     JButton removeButton = new JButton("Remove Unit");
                     removeButton.addActionListener(this);
                     this.removeUnitButtons.get(i).add(removeButton);
                 }
             }
         }
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.layoutComponents();
    }

    public boolean determineLayoutStyle(ArrayList<Integer> arrayOfMandatoryChoicesInCategories, ArrayList<Integer> arrayOfMaxChoicesPerCategory){
        int sumOfMin = 0;
        int sumOfMaxes = 0;

        for(int i = 0; i < detachment.getArmy().getRelevantSlotCount(); i++){
            sumOfMin += arrayOfMandatoryChoicesInCategories.get(i);
            sumOfMaxes += arrayOfMaxChoicesPerCategory.get(i);
        }

        if(sumOfMin  <= 0 || sumOfMaxes > 5 * detachment.getArmy().getRelevantSlotCount() ){
            return true;
        }
        else  return false;
    }

    public void layoutComponents(){
        if(this.isLooseDetachment){
            this.layoutComponentsLooseDetachmentStyle();
        }
        else{
            this.layoutComponentsRigidDetachmentStyle();
        }
    }

    private void layoutComponentsLooseDetachmentStyle(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;

        add(this.detachmentInfoLabel, gbc);
        gbc.gridy++;
        for(int i = 0; i < roster.getPrimaryArmy().getRelevantSlotCount(); i++){
            add(this.categoryLabels.get(i), gbc);
            gbc.gridy++;
            for(int j = 0; j < this.unitLabels.get(i).size(); j++){
                if(this.detachment.getBoughtUnitsCategorized().get(i).size() > j) {
                    this.unitLabels.get(i).get(j).setText(this.detachment.getBoughtUnitsCategorized().get(i).get(j).toString());
                    add(this.unitLabels.get(i).get(j), gbc);
                    gbc.gridx++;
                    add(this.removeUnitButtons.get(i).get(j), gbc);
                    gbc.gridx = 0;
                    gbc.gridy++;
                }
            }
            add(this.addUnitButtons.get(i).get(0), gbc);
            gbc.gridy++;
        }
    }

    private void layoutComponentsRigidDetachmentStyle(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;

        add(this.detachmentInfoLabel, gbc);
        gbc.gridy++;
        for(int i = 0; i < roster.getPrimaryArmy().getRelevantSlotCount(); i++){
            add(this.categoryLabels.get(i), gbc);
            gbc.gridy++;
            for(int j = 0; j < this.detachment.getArrayOfMaxChoicesPerCategory().get(i); j++){
                if(this.detachment.getBoughtUnitsCategorized().get(i).size() > j){
                    this.unitLabels.get(i).get(j).setText(this.detachment.getBoughtUnitsCategorized().get(i).get(j).toString());
                    add(this.unitLabels.get(i).get(j), gbc);
                    gbc.gridx++;
                    add(this.removeUnitButtons.get(i).get(j), gbc);
                    gbc.gridx = 0;
                    gbc.gridy++;
                }
                else{
                    add(this.addUnitButtons.get(i).get(j), gbc);
                    gbc.gridy++;
                }
            }
        }
    }

    public void refresh(){
        this.removeAll();
        this.categoryLabels.clear();
        this.unitLabels.clear();
        this.addUnitButtons.clear();
        this.removeUnitButtons.clear();

        for(int i = 0; i < detachment.getArmy().getRelevantSlotCount();i++){
            this.categoryLabels.add(new JLabel(detachment.getArmy().getArmySubcategory(i).getName()));
            this.unitLabels.add(new ArrayList<>());
            this.addUnitButtons.add(new ArrayList<>());
            this.removeUnitButtons.add(new ArrayList<>());
        }
        ArrayList<Integer> arrayOfMandatoryChoicesInCategories = detachment.getArrayOfMandatoryChoicesInCategories();
        ArrayList<Integer> arrayOfMaxChoicesPerCategory = detachment.getArrayOfMaxChoicesPerCategory();
        this.isLooseDetachment = this.determineLayoutStyle(arrayOfMandatoryChoicesInCategories, arrayOfMaxChoicesPerCategory);
        if(!this.isLooseDetachment) {
            for (int i = 0; i < detachment.getArmy().getRelevantSlotCount(); i++) {
                for (int j = 0; j < arrayOfMaxChoicesPerCategory.get(i); j++) {
                    JButton addButton = new JButton("Add new Unit");
                    JButton removeButton = new JButton("Remove Unit");
                    addButton.addActionListener(this);
                    removeButton.addActionListener(this);
                    this.addUnitButtons.get(i).add(addButton);
                    this.removeUnitButtons.get(i).add(removeButton);
                    this.unitLabels.get(i).add(new JLabel());
                }
            }
        }
        else{
            for(int i = 0; i < detachment.getArmy().getRelevantSlotCount(); i++) {
                JButton addButton = new JButton("Add new Unit");
                addButton.addActionListener(this);
                this.addUnitButtons.get(i).add(addButton);
                //UnitCounter counter = new UnitCounter();
                for(int j = 0; j < detachment.getBoughtUnitsCategorized().get(i).size(); j++) {
                    this.unitLabels.get(i).add(new JLabel());
                    JButton removeButton = new JButton("Remove Unit");
                    removeButton.addActionListener(this);
                    this.removeUnitButtons.get(i).add(removeButton);
                }
            }
        }
        this.layoutComponents();
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton)actionEvent.getSource();
        ArmySubcategory armySubcategory = null;
        boolean addUnit = false;
        boolean removeUnit = true;
        int tempi = 0;
        int tempj = 0;

        for(int i = 0; i < this.addUnitButtons.size(); i++){
            for(int j = 0; j < this.addUnitButtons.get(i).size(); j++) {
                if(this.addUnitButtons.get(i).get(j) == clicked){
                    armySubcategory = this.roster.getDetachments().get(this.detachment.getDetachmentNumber()).getArmy().getArmySubcategory(i);
                    addUnit = true;
                    removeUnit = false;
                }
            }
        }
        for(int i = 0; i < this.removeUnitButtons.size(); i++){
            for(int j = 0; j < this.removeUnitButtons.get(i).size(); j++) {
                if(this.removeUnitButtons.get(i).get(j) == clicked) {
                    addUnit = false;
                    removeUnit = true;
                    tempi = i;
                    tempj = j;
                }
            }
        }
        if(addUnit) {
            int categoryIndex = 0;
            for (int i = 0; i < this.detachment.getArmy().size(); i++) {
                if (this.roster.getDetachments().get(this.detachment.getDetachmentNumber()).getArmy().getArmySubcategory(i) == armySubcategory) {
                    categoryIndex = i;
                }
            }
            UnitSelectionMenu unitSelectionMenu = new UnitSelectionMenu(armySubcategory, roster, this, this.detachment.getDetachmentNumber(), categoryIndex, this.wargamingSystem);
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
        else if(removeUnit){
            this.detachment.deleteUnit(tempi, tempj);
            this.refresh();
        }
    }
}
