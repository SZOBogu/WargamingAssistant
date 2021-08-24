class OptionSet {
    constructor(options, itemListName, keyVerb, isMandatory) {
        if (this.constructor === OptionSet) {
            throw new Error("Abstract classes can't be instantiated.");
        }
        else{
            this.itemListName = itemListName;
            this.keyVerb = keyVerb;
            this.options = options;
            this.isMandatory = isMandatory;
        }
    }
}
