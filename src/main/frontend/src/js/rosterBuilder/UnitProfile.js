class UnitProfile{
    constructor(name,  modelsParts, options,  minModels, maxModels, initialCost, additionalModelCost, unitsPerArmy) {
        this.name = name;
        this.modelsParts = modelsParts;
        this.options = options;
        this.minModels = minModels;
        this.maxModels = maxModels;
        this.initialCost = initialCost;
        this.additionalModelCost = additionalModelCost;
        this.unitsPerArmy = unitsPerArmy;
    }
}

export default UnitProfile;