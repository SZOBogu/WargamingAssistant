package rosterBuilder;
import java.util.ArrayList;
import java.util.Objects;

public class Unit {
    private final String name;
    private int modelsInUnit;
    private ArrayList<Entity> nonBaseEquipment;
    private final ArrayList<Entity> baseEquipmentAndRules;
    private int pointCost;

    public Unit(){
        this("",0, new ArrayList<>(), new ArrayList<>(), 0);
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
