package rosterBuilder;

import java.util.ArrayList;

public class ModelPart {
    private String name;
    private Statline statline;
    private ArrayList<SpecialRule> specialRules;
    private ArrayList<Entity> equipment;

    public ModelPart(String name, Statline statline, ArrayList<SpecialRule> specialRules, ArrayList<Entity> equipment){
        this.name = name;
        this.statline = statline;
        this.equipment = equipment;
        this.specialRules = specialRules;
    }

    public String getName() {
        return this.name;
    }

    public Statline getStatline() {
        return this.statline;
    }

    public ArrayList<SpecialRule> getSpecialRules() {
        return this.specialRules;
    }

    public ArrayList<Entity> getEquipment() {
        return this.equipment;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(this.getName() + "\t" + this.getStatline().toString() + "\t");
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
