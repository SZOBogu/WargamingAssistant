package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.Unit;

public abstract class UnitBuildingRule{
    protected Entity entity1;
    protected Entity entity2;
    protected int modelQuantity;

    public UnitBuildingRule(Entity entity1, Entity entity2){
        this.entity1 = entity1;
        this.entity2 = entity2;
        this.modelQuantity = 0;
    }

    public UnitBuildingRule(Entity entity1, int modelQuantity){
        this.entity1 = entity1;
        this.entity2 = new Entity("", "");
        this.modelQuantity = modelQuantity;
    }

    public abstract void check(Unit unit);
}
