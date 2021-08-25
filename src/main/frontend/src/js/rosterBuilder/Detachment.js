class Detachment{
    constructor(name, armyIndex, detachmentNumber, boughtUnitsCategorized,
                arrayOfMandatoryChoicesInCategories, arrayOfMaxChoicesPerCategory) {
        this.name = name;
        this.armyIndex = armyIndex;
        this.detachmentNumber = detachmentNumber;
        this.boughtUnitsCategorized = boughtUnitsCategorized;
        this.arrayOfMandatoryChoicesInCategories = arrayOfMandatoryChoicesInCategories;
        this.arrayOfMaxChoicesPerCategory = arrayOfMaxChoicesPerCategory;
    }
}

export default Detachment;