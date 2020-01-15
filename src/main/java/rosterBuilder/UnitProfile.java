package rosterBuilder;

import rosterBuilder.rules.UnitBuildingRule;

import javax.swing.*;
import java.util.ArrayList;

public class UnitProfile {
    private String name;
    private ArrayList<ModelPart> modelsParts;
    private ArrayList<OptionSet> options;
    private int minModels;
    private int maxModels;
    private int initialCost;
    private int additionalModelCost;
    private int unitsPerArmy;
    private ArrayList<UnitBuildingRule> rules;
    private UniqueEntitiesPool pool;            //?????? TODO: look it up

    public UnitProfile(String name, ArrayList<ModelPart> modelParts, ArrayList<OptionSet> options, int initialCost){
        this(name, modelParts, options, initialCost, 1, 1,0,100);
    }

    public UnitProfile(String name, ArrayList<ModelPart> modelParts, ArrayList<OptionSet> options, int initialCost, int unitsPerArmy){
        this(name, modelParts, options, initialCost, 1, 1,0,unitsPerArmy);
    }

    public UnitProfile(String name, ArrayList<ModelPart> modelParts, ArrayList<OptionSet> options, int initialCost, int minModels, int maxModels, int additionalModelCost){
        this(name, modelParts, options, initialCost, minModels, maxModels,additionalModelCost, 100);
    }

    public UnitProfile(String name, ArrayList<ModelPart> modelParts, ArrayList<OptionSet> options, int initialCost, int minModels, int maxModels, int additionalModelCost, int unitsPerArmy){
        this.name = name;
        this.modelsParts = modelParts;
        this.options = options;
        this.minModels = minModels;
        this.maxModels = maxModels;
        this.initialCost = initialCost;
        this.additionalModelCost = additionalModelCost;
        this.unitsPerArmy = unitsPerArmy;
        this.rules = new ArrayList<>();
        this.pool = null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<ModelPart> getModelParts() {
        return modelsParts;
    }

    public ArrayList<OptionSet> getOptions() {
        return options;
    }

    public int getMinModels() {
        return minModels;
    }

    public int getMaxModels() {
        return maxModels;
    }

    public int getInitialCost() {
        return initialCost;
    }

    public int getAdditionalModelCost() {
        return additionalModelCost;
    }

    public void setAdditionalModelCost(int additionalModelCost) {
        this.additionalModelCost = additionalModelCost;
    }

    public int getUnitsPerArmy() {
        return unitsPerArmy;
    }

    public void setUnitsPerArmy(int unitsPerArmy) {
        this.unitsPerArmy = unitsPerArmy;
    }

    public ArrayList<UnitBuildingRule> getRules() {
        return rules;
    }

    public void setRules(ArrayList<UnitBuildingRule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString(){
        String string = this.getName() + "\t" + this.getInitialCost() + "p\n";
        if(this.getMinModels() == this.getMaxModels() && this.getMinModels() == 1)
            string += "Single model\n";
        else if(this.getMinModels() == this.getMaxModels())
            string += this.getMinModels() + " models\n";
        else {
            string += this.getMinModels() + "-" + this.getMaxModels() + " models\n";
        }
        for(int i = 0; i < this.getModelParts().size(); i++){
            string += "\t" + this.getModelParts().get(i).toString() + "\n";
        }
        return string;
    }

    public ArrayList<Entity> getBaseEquipmentAndRules() {
        ArrayList<Entity> entities = new ArrayList<>();
        for(int i = 0; i < this.modelsParts.size(); i++){
            entities.addAll(this.modelsParts.get(i).getEquipment());
            entities.addAll(this.modelsParts.get(i).getSpecialRules());
        }
        return entities;
    }

    public UniqueEntitiesPool getPool() {
        return pool;
    }

    public void setPool(UniqueEntitiesPool pool) {
        this.pool = pool;
    }

    public void filterTakenUniques() {
        if (this.pool == null)
            System.out.println(" ");
        else {
            ArrayList<OptionSet> temp = this.options;
            this.options = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                //TODO: blad jest tutaj
                ArrayList<Option> filteredOptions = new ArrayList<>();
                for (int j = 0; j < temp.get(i).getOptions().size(); j++) {
                    if (this.pool.getAvailable().contains(temp.get(i).getOptions().get(j).getEntity()) || !this.pool.contains(temp.get(i).getOptions().get(j).getEntity())) {
                        filteredOptions.add(temp.get(i).getOptions().get(j));
//                        if(this.getName() == "Soothsayer") {
//                            System.out.println(this.getName());
//                            System.out.println(temp.get(i).getOptions().get(j));
//                            System.out.println("-------------------------");
//                        }
                    }
                }
                temp.get(i).setOptions(filteredOptions);
            }
            //System.out.println("########################################3");
            this.options = temp;
        }
    }
}
