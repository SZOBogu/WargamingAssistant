package rosterBuilder.entities;

public class QuantityDependentOption extends Option {
    private int modelQuantity;

    public QuantityDependentOption(){
        super();
    }

    public QuantityDependentOption(Entity entity, int cost, int modelQuantity){
        super(entity, cost);
        this.modelQuantity = modelQuantity;
    }

    public int getModelQuantity() {
        return modelQuantity;
    }

    @Override
    public int getCost(){
        return this.modelQuantity * super.getCost();
    }

    public void setModelQuantity(int modelQuantity) {
        this.modelQuantity = modelQuantity;
    }

    @Override
    public String toString(){
        return getEntity().getName() + "\t" + this.getCost()/this.modelQuantity + "p/per model";
    }
}
