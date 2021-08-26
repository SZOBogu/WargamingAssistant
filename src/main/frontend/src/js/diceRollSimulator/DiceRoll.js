class DiceRoll {
    constructor(quantity, successValue, reroll, valueToReRoll, failures, diceSides) {
        this.quantity = quantity;
        this.successValue = successValue;
        this.reroll = reroll;
        this.valueToReRoll = valueToReRoll;
        this.failures = failures;
        this.diceSides = diceSides;
    }

    static castObjectToDiceRoll(obj) {
        return Object.assign(this, obj)
    }
}

export default DiceRoll;