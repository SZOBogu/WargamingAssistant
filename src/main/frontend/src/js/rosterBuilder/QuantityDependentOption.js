class QuantityDependentOption extends Option {
    constructor(entity, cost, modelQuantity) {
        super(entity, cost);
        this.modelQuantity = modelQuantity;
    }
}

export default QuantityDependentOption;