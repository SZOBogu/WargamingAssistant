package rosterBuilder;
import java.util.ArrayList;
import java.util.Objects;

public class Unit {
    private String name;
    private int modelsInUnit;
    private ArrayList<Entity> nonBaseEquipment;
    private ArrayList<Entity> baseEquipmentAndRules;
    private int pointCost;

    public Unit(){
        this("",1,new ArrayList<>(), new ArrayList<>(), 0);
    }

    public Unit(String name, int modelsInUnit,
                ArrayList<Entity> nonBaseEquipment, ArrayList<Entity> baseEquipmentAndRules, int pointCost){
        this.name = name;
        this.modelsInUnit = modelsInUnit;
        this.nonBaseEquipment = nonBaseEquipment;
        this.baseEquipmentAndRules = baseEquipmentAndRules;
        this.pointCost = pointCost;
    }

    public String getName() {
        return name;
    }

    public int getModelsInUnit() {
        return modelsInUnit;
    }

    public ArrayList<Entity> getNonBaseEquipment() {
        return nonBaseEquipment;
    }

    public ArrayList<Entity> getBaseEquipmentAndRules() {
        return baseEquipmentAndRules;
    }

    public int getPointCost() {
        return pointCost;
    }

    public void addEquipment(Entity equipment){
        this.nonBaseEquipment.add(equipment);
    }

    public void setModelsInUnit(int modelsInUnit) {
        this.modelsInUnit = modelsInUnit;
    }

    public void setPointCost(int pointCost) {
        this.pointCost = pointCost;
    }

    public void setNonBaseEquipment(ArrayList<Entity> nonBaseEquipment) {
         this.nonBaseEquipment = nonBaseEquipment;
    }

    @Override
    public String toString(){
        String unitInfo = "";
        if(this.getModelsInUnit() > 1){
            unitInfo += this.getModelsInUnit() + " ";
        }
        unitInfo += this.getName();
        if(this.nonBaseEquipment.size() > 0){
            unitInfo += ", ";
        }
        for(int i = 0; i < this.nonBaseEquipment.size(); i++){
            unitInfo += this.nonBaseEquipment.get(i).toString();
            if(i != this.nonBaseEquipment.size() - 1){
                unitInfo += ", ";
            }
        }
        unitInfo += "\t[" + this.getPointCost() + "]";
        return unitInfo;
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
