package rosterBuilder.rules;

import rosterBuilder.pojos.Entity;
import rosterBuilder.pojos.Unit;

import java.io.Serializable;

public abstract class UnitBuildingRule implements Rule, Serializable {
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
