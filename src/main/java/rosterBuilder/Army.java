package rosterBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Army {
    private String name;
    private ArrayList<ArmySubcategory> armySubcategories;
    private ImageIcon img;
    private ArrayList<Integer> alliableArmyIndexes;

    public Army(String name, ArrayList<ArmySubcategory> armySubcategories){
        this(name, armySubcategories, new ImageIcon());
    }

    public Army(String name, ArrayList<ArmySubcategory> armySubcategories, ImageIcon img ){
        this.name = name;
        this.armySubcategories = armySubcategories;
        this.img = img;
        this.alliableArmyIndexes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArmySubcategory getArmySubcategory(int index) {
        return armySubcategories.get(index);
    }

    public ImageIcon getImg() {
        return img;
    }

    public int size(){
        return this.armySubcategories.size();
    }

    public int getRelevantSlotCount(){
        int counter = 0;
        for(int i = 0; i < this.size(); i++){
            if(this.getArmySubcategory(i).size() > 0){
                counter++;
            }
        }
        return counter;
    }

    public ArrayList<Integer> getAlliableArmyIndexes() {
        return alliableArmyIndexes;
    }

    public void setAlliableArmyIndexes(ArrayList<Integer> alliableArmyIndexes) {
        this.alliableArmyIndexes = alliableArmyIndexes;
    }
}
