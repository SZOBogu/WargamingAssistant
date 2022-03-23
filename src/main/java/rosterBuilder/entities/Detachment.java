package rosterBuilder.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "detachment", schema = "wargaming_assistant")
public class Detachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToOne(targetEntity = Army.class, mappedBy = "detachment",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Army army;

    @Basic
    @Column(name = "detachmentNumber")
    private int detachmentNumber;


    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "detachmentSlot_id")
    private List<DetachmentSlot> detachmentSlots;

    public Detachment(){
        this.name = "";
        this.army = new Army();
        this.detachmentNumber = 0;
        this.detachmentSlots = new ArrayList<>();
    }

    public Detachment(DetachmentBuilder builder){
        this.name = builder.name;
        this.army = builder.army;
        this.detachmentNumber = builder.detachmentNumber;
        this.detachmentSlots = builder.detachmentSlots;
    }

    public static class DetachmentBuilder{
        private final String name;
        private Army army;
        private int detachmentNumber;
        private List<DetachmentSlot> detachmentSlots;

        public DetachmentBuilder(String name){
            this.name = name;
            this.detachmentSlots = new ArrayList<>();

            this.detachmentNumber = 0;
        }

        public DetachmentBuilder(String name, int categories){
            this.name = name;
            this.detachmentSlots = new ArrayList<>();

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

        public DetachmentBuilder detachmentSlots(List<DetachmentSlot>  detachmentSlots){
            this.detachmentSlots = detachmentSlots;
            return this;
        }

        public Detachment build(){
            return new Detachment(this);
        }
    }

    public int getCost() {
        int totalCost = 0;
        for (DetachmentSlot slot : this.detachmentSlots) {
            for (Unit unit : slot.getUnits()) {
                totalCost += unit.getPointCost();
            }
        }
        return totalCost;
    }

    public void addUnit(Unit unit, int categoryIndex, UniqueEntitiesPool pool){
        if(pool != null){
            List<Entity> allEntities = new ArrayList<>();
            allEntities.addAll(unit.getNonBaseEquipment());
            allEntities.addAll(unit.getBaseEquipmentAndRules());
            for (Entity allEntity : allEntities) {
                if (pool.getAvailable().contains(allEntity))
                    pool.get(allEntity.getName());
            }
        this.getUnitProfileFromDetachment();
        }
        this.detachmentSlots.get(categoryIndex).getUnits().add(unit);
    }

    public void deleteUnit(int categoryIndex, int index, UniqueEntitiesPool pool){
        if(pool != null) {
            Unit unit = this.detachmentSlots.get(categoryIndex).getUnits().get(index);
            List<Entity> allEntities = new ArrayList<>();
            allEntities.addAll(unit.getNonBaseEquipment());
            allEntities.addAll(unit.getBaseEquipmentAndRules());
            for (Entity allEntity : allEntities) {
                if (pool.contains(allEntity) && !pool.getAvailable().contains(allEntity))
                    pool.release(allEntity);
            }
            this.getUnitProfileFromDetachment();
        }
        this.detachmentSlots.get(categoryIndex).getUnits().remove(index);
    }

    public Unit getUnit(int categoryIndex, int index) {
        return this.detachmentSlots.get(categoryIndex).getUnits().get(index);
    }

    public boolean contains(Unit unit){
        for (DetachmentSlot slot : this.detachmentSlots) {
            if (slot.getUnits().contains(unit))
                return true;
        }
        return false;
    }

    public Detachment copyEmptyDetachment(){
        return new DetachmentBuilder(this.name)
                .detachmentNumber(this.detachmentNumber + 1)
                .build();
    }

    public int getUnitCount(){
        int count = 0;
        for (DetachmentSlot slot : this.detachmentSlots) {
            count += slot.getUnits().size();
        }
        return count;
    }


    private void getUnitProfileFromDetachment(){
        for(int i = 0; i < getArmy().size(); i++){
            for(int j = 0; j < getArmy().getArmySubcategory(i).size(); j++){
                getArmy().getArmySubcategory(i).getUnitProfile(j);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public int getDetachmentNumber() {
        return detachmentNumber;
    }

    public void setDetachmentNumber(int detachmentNumber) {
        this.detachmentNumber = detachmentNumber;
    }

    public List<DetachmentSlot> getDetachmentSlots() {
        return detachmentSlots;
    }

    public void setDetachmentSlots(List<DetachmentSlot> detachmentSlots) {
        this.detachmentSlots = detachmentSlots;
    }

    @Override
    public String toString(){
        if(this.army != null) {
            StringBuilder detachmentInfo = new StringBuilder("Detachment No." + this.getDetachmentNumber() + ": "
                    + this.getName() + "\n");
            for (int i = 0; i < army.getRelevantSlotCount(); i++) {
                detachmentInfo.append("   ").append(army.getArmySubcategory(i).getName()).append("\n");
                for (int j = 0; j < this.detachmentSlots.get(i).getUnits().size(); j++) {
                    detachmentInfo.append("      ").append(this.detachmentSlots.get(i).getUnits().get(j).toString()).append("\n");
                }
            }
            return detachmentInfo.toString();
        }
        else return "Army not set in detachment";
    }

}
