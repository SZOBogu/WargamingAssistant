package rosterBuilder.pojos;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Unit {
    private final String name;
    private int modelsInUnit;
    private List<Entity> nonBaseEquipment;
    private final List<Entity> baseEquipmentAndRules;
    private int pointCost;

    public Unit(){
        this.name = "";
        this.modelsInUnit = 1;
        this.nonBaseEquipment = new ArrayList<>();
        this.baseEquipmentAndRules = new ArrayList<>();
        this.pointCost = 0;
    }


    public Unit(UnitBuilder builder){
        this.name = builder.name;
        this.modelsInUnit = builder.modelsInUnit;
        this.nonBaseEquipment = builder.nonBaseEquipment;
        this.baseEquipmentAndRules = builder.baseEquipmentAndRules;
        this.pointCost = builder.pointCost;
    }

    public static class UnitBuilder{
        private final String name;
        private int modelsInUnit = 1;
        private List<Entity> nonBaseEquipment = new ArrayList<>();
        private final List<Entity> baseEquipmentAndRules;
        private int pointCost = 0;

        public UnitBuilder(String name, List<Entity> baseEquipmentAndRules){
            this.name = name;
            this.baseEquipmentAndRules = baseEquipmentAndRules;
        }

        public UnitBuilder modelsInUnit(int modelsInUnit){
            this.modelsInUnit = modelsInUnit;
            return this;
        }

        public UnitBuilder nonBaseEquipment(List<Entity> nonBaseEquipment){
            this.nonBaseEquipment = nonBaseEquipment;
            return this;
        }

        public UnitBuilder pointCost(int pointCost){
            this.pointCost = pointCost;
            return this;
        }

        public Unit build(){
            return new Unit(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getModelsInUnit() {
        return modelsInUnit;
    }

    public void setModelsInUnit(int modelsInUnit) {
        this.modelsInUnit = modelsInUnit;
    }

    public List<Entity> getNonBaseEquipment() {
        return nonBaseEquipment;
    }

    public void setNonBaseEquipment(List<Entity> nonBaseEquipment) {
        this.nonBaseEquipment = nonBaseEquipment;
    }

    public List<Entity> getBaseEquipmentAndRules() {
        return baseEquipmentAndRules;
    }

    public int getPointCost() {
        return pointCost;
    }

    public void setPointCost(int pointCost) {
        this.pointCost = pointCost;
    }

    public void addEquipment(Entity equipment){
        this.nonBaseEquipment.add(equipment);
    }

    @Override
    public String toString(){
        StringBuilder unitInfo = new StringBuilder();
        if(this.getModelsInUnit() > 1){
            unitInfo.append(this.getModelsInUnit()).append(" ");
        }
        unitInfo.append(this.getName());
        if(this.nonBaseEquipment.size() > 0){
            unitInfo.append(", ");
        }
        for(int i = 0; i < this.nonBaseEquipment.size(); i++){
            unitInfo.append(this.nonBaseEquipment.get(i).toString());
            if(i != this.nonBaseEquipment.size() - 1){
                unitInfo.append(", ");
            }
        }
        unitInfo.append("\t[").append(this.getPointCost()).append("]");
        return unitInfo.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return Objects.equals(name, unit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
