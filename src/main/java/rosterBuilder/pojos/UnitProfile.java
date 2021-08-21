package rosterBuilder.pojos;

import rosterBuilder.rules.UnitBuildingRule;

import java.util.ArrayList;
import java.util.Objects;

public class UnitProfile {
    private final String name;
    private final ArrayList<ModelPart> modelsParts;
    private ArrayList<OptionSet> options;
    private final int minModels;
    private final int maxModels;
    private final int initialCost;
    private int additionalModelCost;
    private int unitsPerArmy;
    private ArrayList<UnitBuildingRule> rules;
    private UniqueEntitiesPool pool;            //?????? TODO: look it up

    public UnitProfile(){
        this("", new ArrayList<>(), new ArrayList<>(),
                0, 1, 1,0,100);
    }
    public UnitProfile(String name, ArrayList<ModelPart> modelParts, ArrayList<OptionSet> options, int initialCost){
        this(name, modelParts, options, initialCost,
                1, 1,0,100);
    }

    public UnitProfile(String name, ArrayList<ModelPart> modelParts, ArrayList<OptionSet> options,
                       int initialCost, int unitsPerArmy){
        this(name, modelParts, options, initialCost, 1, 1,0,unitsPerArmy);
    }

    public UnitProfile(String name, ArrayList<ModelPart> modelParts, ArrayList<OptionSet> options,
                       int initialCost, int minModels, int maxModels, int additionalModelCost){
        this(name, modelParts, options, initialCost, minModels, maxModels,additionalModelCost, 100);
    }

    public UnitProfile(String name, ArrayList<ModelPart> modelParts, ArrayList<OptionSet> options,
                       int initialCost, int minModels, int maxModels, int additionalModelCost, int unitsPerArmy){
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

    public ArrayList<OptionSet> getOptionSets() {
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
        StringBuilder string = new StringBuilder(this.getName() + "\t" + this.getInitialCost() + "p\n");
        if(this.getMinModels() == this.getMaxModels() && this.getMinModels() == 1)
            string.append("Single model\n");
        else if(this.getMinModels() == this.getMaxModels())
            string.append(this.getMinModels()).append(" models\n");
        else {
            string.append(this.getMinModels()).append("-").append(this.getMaxModels()).append(" models\n");
        }
        for(int i = 0; i < this.getModelParts().size(); i++){
            string.append("\t").append(this.getModelParts().get(i).toString()).append("\n");
        }
        return string.toString();
    }

    public ArrayList<Entity> getBaseEquipmentAndRules() {
        ArrayList<Entity> entities = new ArrayList<>();
        for (ModelPart modelsPart : this.modelsParts) {
            entities.addAll(modelsPart.getEquipment());
            entities.addAll(modelsPart.getSpecialRules());
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
            for (OptionSet optionSet : temp) {
                //TODO: blad jest tutaj
                ArrayList<Option> filteredOptions = new ArrayList<>();
                for (int j = 0; j < optionSet.getOptions().size(); j++) {
                    if (this.pool.getAvailable().contains(optionSet.getOptions().get(j).getEntity()) || !this.pool.contains(optionSet.getOptions().get(j).getEntity())) {
                        filteredOptions.add(optionSet.getOptions().get(j));
                    }
                }
                optionSet.setOptions(filteredOptions);
            }
            this.options = temp;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitProfile that = (UnitProfile) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
