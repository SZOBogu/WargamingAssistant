package rosterBuilder.swingGUI;

import common.Refreshable;
import rosterBuilder.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DetachmentPanel extends JPanel implements ActionListener, Refreshable {
    private JLabel detachmentInfoLabel;
    private List<JLabel> categoryLabels;
    private List<List<JLabel>> unitLabels;
    private List<List<JButton>> addUnitButtons;
    private List<List<JButton>> editUnitButtons;
    private List<List<JButton>> removeUnitButtons;
    private boolean isLooseDetachment;
    private Detachment detachment;
    private RosterObserverSubject roster;
    private WargamingSystem wargamingSystem;

    public DetachmentPanel(RosterObserverSubject roster, Detachment detachment, WargamingSystem system,
                           int detachmentIndex){
        this.detachmentInfoLabel = new JLabel("Detachment " + detachmentIndex + ": " + detachment.getName());
        this.detachment = detachment;
        this.roster = roster;
        this.wargamingSystem = system;
        this.categoryLabels = new ArrayList();
        this.unitLabels = new ArrayList<>();
        this.addUnitButtons = new ArrayList<>();
        this.editUnitButtons = new ArrayList<>();
        this.removeUnitButtons = new ArrayList<>();

         for(int i = 0; i < detachment.getArmy().getRelevantSlotCount();i++){
                this.categoryLabels.add(new JLabel(detachment.getArmy().getArmySubcategory(i).getName(),
                        SwingConstants.CENTER));
                this.unitLabels.add(new ArrayList<>());
                this.addUnitButtons.add(new ArrayList<>());
                this.editUnitButtons.add(new ArrayList<>());
                this.removeUnitButtons.add(new ArrayList<>());
        }
        List<Integer> arrayOfMandatoryChoicesInCategories =
                detachment.getArrayOfMandatoryChoicesInCategories();
        List<Integer> arrayOfMaxChoicesPerCategory =
                detachment.getArrayOfMaxChoicesPerCategory();

        this.isLooseDetachment = this.determineLayoutStyle(arrayOfMandatoryChoicesInCategories,
                arrayOfMaxChoicesPerCategory);
         if(!this.isLooseDetachment) {
             for (int i = 0; i < detachment.getArmy().getRelevantSlotCount(); i++) {
                 for (int j = 0; j < arrayOfMaxChoicesPerCategory.get(i); j++) {
                     JButton addButton = new JButton("Add new Unit");
                     JButton removeButton = new JButton("Remove Unit");
                     JButton editButton = new JButton("Edit Button");
                     addButton.addActionListener(this);
                     removeButton.addActionListener(this);
                     editButton.addActionListener(this);
                     this.addUnitButtons.get(i).add(addButton);
                     this.editUnitButtons.get(i).add(editButton);
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
                 for(int j = 0; j < detachment.getBoughtUnitsCategorized().get(i).size(); j++) {
                     this.unitLabels.get(i).add(new JLabel());
                     JButton removeButton = new JButton("Remove Unit");
                     JButton editButton = new JButton("Edit Button");
                     removeButton.addActionListener(this);
                     editButton.addActionListener(this);
                     this.removeUnitButtons.get(i).add(removeButton);
                     this.editUnitButtons.get(i).add(editButton);
                 }
             }
         }
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.layoutComponents();
    }

    public boolean determineLayoutStyle(List<Integer> arrayOfMandatoryChoicesInCategories,
                                        List<Integer> arrayOfMaxChoicesPerCategory){
        int sumOfMin = 0;
        int sumOfMaxes = 0;

        for(int i = 0; i < detachment.getArmy().getRelevantSlotCount(); i++){
            sumOfMin += arrayOfMandatoryChoicesInCategories.get(i);
            sumOfMaxes += arrayOfMaxChoicesPerCategory.get(i);
        }

        return sumOfMin <= 0 || sumOfMaxes > 5 * detachment.getArmy().getRelevantSlotCount();
    }

    public void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;

        if(this.isLooseDetachment){
            this.layoutComponentsLooseDetachmentStyle(gbc);
        }
        else{
            this.layoutComponentsRigidDetachmentStyle(gbc);
        }
    }

    private void layoutComponentsLooseDetachmentStyle(GridBagConstraints gbc){
        add(this.detachmentInfoLabel, gbc);
        gbc.gridy++;
        for(int i = 0; i < roster.getRoster().getPrimaryArmy().getRelevantSlotCount(); i++){
            add(this.categoryLabels.get(i), gbc);
            gbc.gridy++;
            for(int j = 0; j < this.unitLabels.get(i).size(); j++){
                if(this.detachment.getBoughtUnitsCategorized().get(i).size() > j) {
                    this.unitLabels.get(i).get(j).setText(
                            this.detachment.getBoughtUnitsCategorized().get(i).get(j).toString());
                    add(this.unitLabels.get(i).get(j), gbc);
                    gbc.gridx++;
                    add(this.editUnitButtons.get(i).get(j), gbc);
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

    private void layoutComponentsRigidDetachmentStyle(GridBagConstraints gbc){
        add(this.detachmentInfoLabel, gbc);
        gbc.gridy++;
        for(int i = 0; i < roster.getRoster().getPrimaryArmy().getRelevantSlotCount(); i++){
            add(this.categoryLabels.get(i), gbc);
            gbc.gridy++;
            for(int j = 0; j < this.detachment.getArrayOfMaxChoicesPerCategory().get(i); j++){
                if(this.detachment.getBoughtUnitsCategorized().get(i).size() > j){
                    this.unitLabels.get(i).get(j).setText(
                            this.detachment.getBoughtUnitsCategorized().get(i).get(j).toString());
                    add(this.unitLabels.get(i).get(j), gbc);
                    gbc.gridx++;
                    add(this.editUnitButtons.get(i).get(j), gbc);
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
        this.editUnitButtons.clear();

        for(int i = 0; i < detachment.getArmy().getRelevantSlotCount();i++){
            this.categoryLabels.add(new JLabel(detachment.getArmy().getArmySubcategory(i).getName()));
            this.unitLabels.add(new ArrayList<>());
            this.addUnitButtons.add(new ArrayList<>());
            this.removeUnitButtons.add(new ArrayList<>());
            this.editUnitButtons.add(new ArrayList<>());
        }
        List<Integer> arrayOfMandatoryChoicesInCategories =
                detachment.getArrayOfMandatoryChoicesInCategories();
        List<Integer> arrayOfMaxChoicesPerCategory =
                detachment.getArrayOfMaxChoicesPerCategory();
        this.isLooseDetachment = this.determineLayoutStyle(
                arrayOfMandatoryChoicesInCategories, arrayOfMaxChoicesPerCategory);
        if(!this.isLooseDetachment) {
            for (int i = 0; i < detachment.getArmy().getRelevantSlotCount(); i++) {
                for (int j = 0; j < arrayOfMaxChoicesPerCategory.get(i); j++) {
                    JButton addButton = new JButton("Add new Unit");
                    JButton removeButton = new JButton("Remove Unit");
                    JButton editButton = new JButton("Edit Button");
                    addButton.addActionListener(this);
                    removeButton.addActionListener(this);
                    editButton.addActionListener(this);
                    this.addUnitButtons.get(i).add(addButton);
                    this.removeUnitButtons.get(i).add(removeButton);
                    this.editUnitButtons.get(i).add(editButton);
                    this.unitLabels.get(i).add(new JLabel());
                }
            }
        }
        else{
            for(int i = 0; i < detachment.getArmy().getRelevantSlotCount(); i++) {
                JButton addButton = new JButton("Add new Unit");
                addButton.addActionListener(this);
                this.addUnitButtons.get(i).add(addButton);
                for(int j = 0; j < detachment.getBoughtUnitsCategorized().get(i).size(); j++) {
                    this.unitLabels.get(i).add(new JLabel());
                    JButton removeButton = new JButton("Remove Unit");
                    JButton editButton = new JButton("Edit Unit");
                    removeButton.addActionListener(this);
                    editButton.addActionListener(this);
                    this.removeUnitButtons.get(i).add(removeButton);
                    this.editUnitButtons.get(i).add(editButton);
                }
            }
        }
        SwingUtilities.getWindowAncestor(this); //?
        this.layoutComponents();
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton)actionEvent.getSource();
        ArmySubcategory armySubcategory = null;
        boolean addUnit = false;
        boolean removeUnit = false;
        boolean editUnit = false;
        int tempi = 0;
        int tempj = 0;

        for(int i = 0; i < this.addUnitButtons.size(); i++){
            for(int j = 0; j < this.addUnitButtons.get(i).size(); j++) {
                if(this.addUnitButtons.get(i).get(j) == clicked){
                    armySubcategory = this.roster.getRoster().getDetachments().get(
                            this.detachment.getDetachmentNumber()).getArmy().getArmySubcategory(i);
                    addUnit = true;
                }
            }
        }
        for(int i = 0; i < this.removeUnitButtons.size(); i++){
            for(int j = 0; j < this.removeUnitButtons.get(i).size(); j++) {
                if(this.removeUnitButtons.get(i).get(j) == clicked) {
                    removeUnit = true;
                    tempi = i;
                    tempj = j;
                }
            }
        }
        for(int i = 0; i < this.editUnitButtons.size(); i++){
            for(int j = 0; j < this.editUnitButtons.get(i).size(); j++) {
                if(this.editUnitButtons.get(i).get(j) == clicked) {
                    editUnit = true;
                    tempi = i;
                    tempj = j;
                }
            }
        }

        if(addUnit) {
            int categoryIndex = 0;
            for (int i = 0; i < this.detachment.getArmy().size(); i++) {
                if (this.roster.getRoster().getDetachments().get(
                        this.detachment.getDetachmentNumber()).getArmy().getArmySubcategory(i) == armySubcategory) {
                    categoryIndex = i;
                }
            }
            new UnitSelectionMenu(armySubcategory, roster,
                    this, this.detachment.getDetachmentNumber(), categoryIndex,
                    this.wargamingSystem);
            RosterBuilderWindow topFrame = (RosterBuilderWindow) SwingUtilities.getWindowAncestor(this);
            roster.refreshComponents();
            topFrame.dispose();
        }
        else if(removeUnit){
            this.detachment.deleteUnit(tempi, tempj);
            SwingUtilities.getWindowAncestor(this);
            roster.refreshComponents();
        }
        else if(editUnit){
            UnitAndProfileFinder finder = new UnitAndProfileFinder();

            UnitProfile unitProfile =  finder.getProfile(this.detachment.getArmy(),
                    this.detachment.getUnit(tempi, tempj).getName());

            Unit unit = this.detachment.getUnit(tempi, tempj);
            List<List<Integer>> optionsIndexes = UnitTakenOptionsIndexGetter.getTakenOptionsIndexes(unit, unitProfile);

            this.detachment.deleteUnit(tempi, tempj);
            new UnitProfileFrame(
                    unitProfile, roster, this, this.detachment.getDetachmentNumber(),
                    tempi, wargamingSystem, optionsIndexes);
            RosterBuilderWindow topFrame = (RosterBuilderWindow) SwingUtilities.getWindowAncestor(this);
            roster.refreshComponents();
            topFrame.dispose();
        }
    }
}
