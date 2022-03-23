package rosterBuilder.responses;

import rosterBuilder.entities.ModelPart;
import rosterBuilder.entities.OptionSet;

import java.util.List;

public class UnitProfileResponse {
    private String name;
    private List<ModelPart> modelsParts;
    private List<OptionSet> options;
    private int minModels;
    private int maxModels;
    private int initialCost;
    private int additionalModelCost;
    private int unitsPerArmy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelPart> getModelsParts() {
        return modelsParts;
    }

    public void setModelsParts(List<ModelPart> modelsParts) {
        this.modelsParts = modelsParts;
    }

    public List<OptionSet> getOptions() {
        return options;
    }

    public void setOptions(List<OptionSet> options) {
        this.options = options;
    }

    public int getMinModels() {
        return minModels;
    }

    public void setMinModels(int minModels) {
        this.minModels = minModels;
    }

    public int getMaxModels() {
        return maxModels;
    }

    public void setMaxModels(int maxModels) {
        this.maxModels = maxModels;
    }

    public int getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(int initialCost) {
        this.initialCost = initialCost;
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
}

