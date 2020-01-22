package rosterBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class Detachment {
    private String name;
    private Army army;
    private int detachmentNumber;
    private int totalDetachmentCost;
    private ArrayList<ArrayList<Unit>> boughtUnitsCategorized;
    private ArrayList<Integer> arrayOfMandatoryChoicesInCategories;
    private ArrayList<Integer> arrayOfMaxChoicesPerCategory;
    private UniqueEntitiesPool pool;

    public Detachment(String name, int numberOfCategories, int detachmentNumber){
        this(name, new ArrayList<>(), detachmentNumber);
        this.arrayOfMandatoryChoicesInCategories = new ArrayList<>();
        this.arrayOfMaxChoicesPerCategory = new ArrayList<>();

        this.setCapacity(numberOfCategories);

        for(int i = 0;i < numberOfCategories; i++){
            this.arrayOfMandatoryChoicesInCategories.add(0);
        }
        for(int i = 0;i < numberOfCategories; i++){
            this.arrayOfMaxChoicesPerCategory.add(100);
        }
    }


    public Detachment(String name, ArrayList<Integer> arrayOfMandatoryChoicesInCategories, int detachmentNumber){
        this.name = name;
        this.totalDetachmentCost = 0;
        this.detachmentNumber = detachmentNumber;
        this.boughtUnitsCategorized = new ArrayList<>(Arrays.asList(new ArrayList<>()));
        this.setCapacity(arrayOfMandatoryChoicesInCategories.size());
        this.arrayOfMandatoryChoicesInCategories = arrayOfMandatoryChoicesInCategories;
        ArrayList<Integer> arrayOfMaxChoicesInCategories = new ArrayList<>();
        for(int i = 0;i < arrayOfMandatoryChoicesInCategories.size(); i++){
            arrayOfMaxChoicesInCategories.add(100);
        }
        this.arrayOfMaxChoicesPerCategory = arrayOfMaxChoicesInCategories;
        this.army = null;
        this.pool = null;
    }


    public Detachment(String name, ArrayList<Integer> arrayOfMandatoryChoicesInCategories, ArrayList<Integer> arrayOfMaxChoicesInCategories, int detachmentNumber){
        this(name, arrayOfMandatoryChoicesInCategories, detachmentNumber);
        this.arrayOfMaxChoicesPerCategory = arrayOfMaxChoicesInCategories;
    }

    public String getName() {
        return name;
    }

    public int getDetachmentNumber() {
        return detachmentNumber;
    }

    public void setDetachmentNumber(int i) {
        this.detachmentNumber = i;
    }

    public int getCost() {
        int totalCost = 0;
        for(int i = 0; i < this.boughtUnitsCategorized.size(); i++){
            for(int j = 0; j < this.boughtUnitsCategorized.get(i).size(); j++) {
                totalCost += this.boughtUnitsCategorized.get(i).get(j).getPointCost();
            }
        }
        return totalCost;
    }

    public ArrayList<ArrayList<Unit>> getBoughtUnitsCategorized() {
        return boughtUnitsCategorized;
    }
    public ArrayList<Integer> getArrayOfMandatoryChoicesInCategories() {
        return arrayOfMandatoryChoicesInCategories;
    }
    public ArrayList<Integer> getArrayOfMaxChoicesPerCategory() {
        return arrayOfMaxChoicesPerCategory;
    }

    public void addUnit(Unit unit, int categoryIndex){
        if(this.pool != null){
            ArrayList<Entity> allEntities = new ArrayList<>();
            allEntities.addAll(unit.getNonBaseEquipment());
            allEntities.addAll(unit.getBaseEquipmentAndRules());
            for(int i = 0; i < allEntities.size(); i++){
                if(this.pool.getAvailable().contains(allEntities.get(i)))
                    this.pool.get(allEntities.get(i).getName());
            }
        this.profileFilter();
        }
        this.boughtUnitsCategorized.get(categoryIndex).add(unit);
        this.totalDetachmentCost += unit.getPointCost();
    }

    public void deleteUnit(int categoryIndex, int index){
        if(this.pool != null) {
            Unit unit = this.boughtUnitsCategorized.get(categoryIndex).get(index);
            ArrayList<Entity> allEntities = new ArrayList<>();
            allEntities.addAll(unit.getNonBaseEquipment());
            allEntities.addAll(unit.getBaseEquipmentAndRules());
            for (int i = 0; i < allEntities.size(); i++) {
                if(this.pool.contains(allEntities.get(i)) && !this.pool.getAvailable().contains(allEntities.get(i)))
                    this.pool.release(allEntities.get(i));
            }
            this.profileFilter();
        }
        this.totalDetachmentCost -= this.boughtUnitsCategorized.get(categoryIndex).get(index).getPointCost();
        this.boughtUnitsCategorized.get(categoryIndex).remove(index);
    }

    public Unit getUnit(int categoryIndex, int index) {
        return this.boughtUnitsCategorized.get(categoryIndex).get(index);
    }

    public boolean contains(Unit unit){
        for(int i = 0; i < this.boughtUnitsCategorized.size(); i++){
            if(this.boughtUnitsCategorized.get(i).contains(unit))
                return true;
        }
        return false;
    }

    public Detachment copyEmptyDetachment(){
        ArrayList<Integer> arrayOfMandatoryChoicesInCategories = new ArrayList<>();
        ArrayList<Integer> arrayOfMaxChoicesPerCategory = new ArrayList<>();

        for(int i = 0; i < this.arrayOfMandatoryChoicesInCategories.size(); i++){
            arrayOfMandatoryChoicesInCategories.add(new Integer(this.arrayOfMandatoryChoicesInCategories.get(i)));
        }

        for(int i = 0; i < this.arrayOfMaxChoicesPerCategory.size(); i++){
            arrayOfMaxChoicesPerCategory.add(new Integer(this.arrayOfMaxChoicesPerCategory.get(i)));
        }
        Detachment detachment = new Detachment(this.name, arrayOfMandatoryChoicesInCategories, arrayOfMaxChoicesPerCategory, this.detachmentNumber+1);
        return detachment;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
       // this.setCapacity(army.getRelevantSlotCount()); //?
        this.army = army;
    }

    public int getUnitCount(){
        int count = 0;
        for(int i = 0; i < this.boughtUnitsCategorized.size(); i++){
            count += this.boughtUnitsCategorized.get(i).size();
        }
        return count;
    }


    public void setCapacity(int capacity){
        if(capacity >= 0) {
            if (this.boughtUnitsCategorized.size() < capacity) {
                for (int i = this.boughtUnitsCategorized.size(); i < capacity; i++) {
                    this.boughtUnitsCategorized.add(new ArrayList<>());
                }
            } else if (this.boughtUnitsCategorized.size() > capacity) {
                for (; ; ) {
                    this.boughtUnitsCategorized.remove(this.boughtUnitsCategorized.size() - 1);
                    if (this.boughtUnitsCategorized.size() == capacity)
                        break;
                }
            }
        }
    }

    @Override
    public String toString(){
        if(this.army != null) {
            String detachmentInfo = "Detachment No." + this.getDetachmentNumber() + ": " + this.getName() + "\n";
            for (int i = 0; i < army.getRelevantSlotCount(); i++) {
                detachmentInfo += "   " + army.getArmySubcategory(i).getName() + "\n";
                for (int j = 0; j < boughtUnitsCategorized.get(i).size(); j++) {
                    detachmentInfo += "      " + boughtUnitsCategorized.get(i).get(j).toString() + "\n";
                }
            }
            return detachmentInfo;
        }
        else return "Army not set in detachment";
    }

    public UniqueEntitiesPool getPool() {
        return pool;
    }

    public void setPool(UniqueEntitiesPool pool) {
        this.pool = pool;
    }

    private void profileFilter(){
        for(int i = 0; i < getArmy().size(); i++){
            for(int j = 0; j < getArmy().getArmySubcategory(i).size(); j++){
                if(getArmy().getArmySubcategory(i).getUnitProfile(j).getPool() != null)
                    getArmy().getArmySubcategory(i).getUnitProfile(j).filterTakenUniques();
            }
        }
    }
}
