package rosterBuilder.pojos;

import java.util.ArrayList;
import java.util.List;

public class ModelPart {
    private String name;
    private List<Characteristic> characteristics;
    private List<SpecialRule> specialRules;
    private List<Entity> equipment;

    public ModelPart(){
        this("", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public ModelPart(String name, List<Characteristic> characteristics, List<SpecialRule> specialRules, List<Entity> equipment){
        this.name = name;
        this.characteristics = characteristics;
        this.equipment = equipment;
        this.specialRules = specialRules;
    }

    public String getName() {
        return this.name;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public List<SpecialRule> getSpecialRules() {
        return this.specialRules;
    }

    public List<Entity> getEquipment() {
        return this.equipment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public void setSpecialRules(List<SpecialRule> specialRules) {
        this.specialRules = specialRules;
    }

    public void setEquipment(List<Entity> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(this.getName() + "\t");
        for(Characteristic characteristic: this.characteristics) {
            info.append(characteristic.getName()).append(": ").append(characteristic.getValue()).append(" ");
        }
        info.append("\t");
        for(int i = 0; i < this.specialRules.size(); i++){
            info.append(this.specialRules.get(i).toString());
            if(i != this.specialRules.size() - 1 || this.equipment.size() > 0)
                info.append(", ");
        }
        for(int i = 0; i < this.equipment.size(); i++){
            info.append(this.equipment.get(i).toString());
            if(i != this.specialRules.size() - 1)
                info.append(", ");
        }
        return info.toString();
    }
}
