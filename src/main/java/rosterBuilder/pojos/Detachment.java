package rosterBuilder.pojos;

import java.util.ArrayList;
import java.util.List;

public class Detachment {
    private final String name;
    private Army army;
    private int detachmentNumber;
    private final List<List<Unit>> boughtUnitsCategorized;
    private final List<Integer> arrayOfMandatoryChoicesInCategories;
    private final List<Integer> arrayOfMaxChoicesPerCategory;
    private UniqueEntitiesPool pool;


    public Detachment(DetachmentBuilder builder){
        this.name = builder.name;
        this.army = builder.army;
        this.detachmentNumber = builder.detachmentNumber;
        this.boughtUnitsCategorized = builder.boughtUnitsCategorized;
        this.arrayOfMandatoryChoicesInCategories = builder.arrayOfMandatoryChoicesInCategories;
        this.arrayOfMaxChoicesPerCategory = builder.arrayOfMaxChoicesPerCategory;
        this.pool = builder.pool;

        this.setCapacity(builder.arrayOfMaxChoicesPerCategory.size());
    }

    public static class DetachmentBuilder{
        private final String name;
        private Army army;
        private int detachmentNumber;
        private List<List<Unit>> boughtUnitsCategorized;
        private List<Integer> arrayOfMandatoryChoicesInCategories;
        private List<Integer> arrayOfMaxChoicesPerCategory;
        private UniqueEntitiesPool pool;

        public DetachmentBuilder(String name){
            this.name = name;
            this.boughtUnitsCategorized = new ArrayList<>();
            this.arrayOfMandatoryChoicesInCategories = new ArrayList<>();
            this.arrayOfMaxChoicesPerCategory = new ArrayList<>();
            this.detachmentNumber = 0;
        }

        public DetachmentBuilder(String name, int categories){
            this.name = name;
            this.boughtUnitsCategorized = new ArrayList<>();

            this.arrayOfMaxChoicesPerCategory = new ArrayList<>();
            for(int i = 0;i < categories; i++){
                this.arrayOfMaxChoicesPerCategory.add(100);
            }

            this.arrayOfMandatoryChoicesInCategories = new ArrayList<>();
            for(int i = 0;i < categories; i++){
                this.arrayOfMandatoryChoicesInCategories.add(0);
            }

            this.detachmentNumber = 0;
        }

        public DetachmentBuilder army(Army army){
            this.army = army;
            return this;
        }

        public DetachmentBuilder detachmentNumber(int detachmentNumber){
            this.detachmentNumber = detachmentNumber;
            return this;
        }

        public DetachmentBuilder boughtUnitsCategorized(List<List<Unit>>  boughtUnitsCategorized){
            this.boughtUnitsCategorized = boughtUnitsCategorized;
            return this;
        }

        public DetachmentBuilder arrayOfMandatoryChoicesInCategories(List<Integer> arrayOfMandatoryChoicesInCategories){
            this.arrayOfMandatoryChoicesInCategories = arrayOfMandatoryChoicesInCategories;

            if(this.arrayOfMaxChoicesPerCategory.isEmpty()){
                for(int i = 0; i < arrayOfMandatoryChoicesInCategories.size(); i++){
                    this.arrayOfMaxChoicesPerCategory.add(100);
                }
            }

            return this;
        }

        public DetachmentBuilder arrayOfMaxChoicesPerCategory(List<Integer> arrayOfMaxChoicesPerCategory){
            this.arrayOfMaxChoicesPerCategory = arrayOfMaxChoicesPerCategory;

            if(this.arrayOfMandatoryChoicesInCategories.isEmpty()){
                for(int i = 0;i < arrayOfMaxChoicesPerCategory.size(); i++){
                    this.arrayOfMandatoryChoicesInCategories.add(0);
                }
            }

            return this;
        }

        public DetachmentBuilder pool(UniqueEntitiesPool pool){
            this.pool = pool;
            return this;
        }

        public Detachment build(){
            return new Detachment(this);
        }
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
        for (List<Unit> units : this.boughtUnitsCategorized) {
            for (Unit unit : units) {
                totalCost += unit.getPointCost();
            }
        }
        return totalCost;
    }

    public List<List<Unit>> getBoughtUnitsCategorized() {
        return boughtUnitsCategorized;
    }
    public List<Integer> getArrayOfMandatoryChoicesInCategories() {
        return arrayOfMandatoryChoicesInCategories;
    }
    public List<Integer> getArrayOfMaxChoicesPerCategory() {
        return arrayOfMaxChoicesPerCategory;
    }

    public void addUnit(Unit unit, int categoryIndex){
        if(this.pool != null){
            List<Entity> allEntities = new ArrayList<>();
            allEntities.addAll(unit.getNonBaseEquipment());
            allEntities.addAll(unit.getBaseEquipmentAndRules());
            for (Entity allEntity : allEntities) {
                if (this.pool.getAvailable().contains(allEntity))
                    this.pool.get(allEntity.getName());
            }
        this.profileFilter();
        }
        this.boughtUnitsCategorized.get(categoryIndex).add(unit);
    }

    public void deleteUnit(int categoryIndex, int index){
        if(this.pool != null) {
            Unit unit = this.boughtUnitsCategorized.get(categoryIndex).get(index);
            List<Entity> allEntities = new ArrayList<>();
            allEntities.addAll(unit.getNonBaseEquipment());
            allEntities.addAll(unit.getBaseEquipmentAndRules());
            for (Entity allEntity : allEntities) {
                if (this.pool.contains(allEntity) && !this.pool.getAvailable().contains(allEntity))
                    this.pool.release(allEntity);
            }
            this.profileFilter();
        }
        this.boughtUnitsCategorized.get(categoryIndex).remove(index);
    }

    public Unit getUnit(int categoryIndex, int index) {
        return this.boughtUnitsCategorized.get(categoryIndex).get(index);
    }

    public boolean contains(Unit unit){
        for (List<Unit> units : this.boughtUnitsCategorized) {
            if (units.contains(unit))
                return true;
        }
        return false;
    }

    public Detachment copyEmptyDetachment(){
        List<Integer> arrayOfMandatoryChoicesInCategories = new ArrayList<>(this.arrayOfMandatoryChoicesInCategories);
        List<Integer> arrayOfMaxChoicesPerCategory = new ArrayList<>(this.arrayOfMaxChoicesPerCategory);

        return new DetachmentBuilder(this.name)
                .arrayOfMandatoryChoicesInCategories(arrayOfMandatoryChoicesInCategories)
                .arrayOfMaxChoicesPerCategory(arrayOfMaxChoicesPerCategory)
                .detachmentNumber(this.detachmentNumber + 1)
                .build();
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.setCapacity(army.getRelevantSlotCount());
        this.army = army;
    }

    public int getUnitCount(){
        int count = 0;
        for (List<Unit> units : this.boughtUnitsCategorized) {
            count += units.size();
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
                do {
                    this.boughtUnitsCategorized.remove(this.boughtUnitsCategorized.size() - 1);
                } while (this.boughtUnitsCategorized.size() != capacity);
            }
        }
    }

    @Override
    public String toString(){
        if(this.army != null) {
            StringBuilder detachmentInfo = new StringBuilder("Detachment No." + this.getDetachmentNumber() + ": "
                    + this.getName() + "\n");
            for (int i = 0; i < army.getRelevantSlotCount(); i++) {
                detachmentInfo.append("   ").append(army.getArmySubcategory(i).getName()).append("\n");
                for (int j = 0; j < boughtUnitsCategorized.get(i).size(); j++) {
                    detachmentInfo.append("      ").append(boughtUnitsCategorized.get(i).get(j).toString()).append("\n");
                }
            }
            return detachmentInfo.toString();
        }
        else return "Army not set in detachment";
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
