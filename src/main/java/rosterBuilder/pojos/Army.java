package rosterBuilder.pojos;

import javax.swing.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Army {
    private int armyId;
    private String name;
    private List<ArmySubcategory> armySubcategories;
    private ImageIcon img;
    private List<Integer> alliableArmyIndexes;

    public Army() {
        this("", new ArrayList<>());
    }

    public Army(String name, List<ArmySubcategory> armySubcategories){
        this(name, armySubcategories, new ImageIcon());
    }

    public Army(String name, List<ArmySubcategory> armySubcategories, ImageIcon img ){
        this.name = name;
        this.armySubcategories = armySubcategories;
        this.img = img;
        this.alliableArmyIndexes = new ArrayList<>();
    }

    public ArmySubcategory getArmySubcategory(int index) {
        return armySubcategories.get(index);
    }

    public void setArmySubcategories(ArmySubcategory armySubcategory, int index) {
        this.armySubcategories.set(index, armySubcategory);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArmySubcategory> getArmySubcategories() {
        return armySubcategories;
    }

    public void setArmySubcategories(List<ArmySubcategory> armySubcategories) {
        this.armySubcategories = armySubcategories;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public List<Integer> getAlliableArmyIndexes() {
        return alliableArmyIndexes;
    }

    public void setAlliableArmyIndexes(List<Integer> alliableArmyIndexes) {
        this.alliableArmyIndexes = alliableArmyIndexes;
    }
}
