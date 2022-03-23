package rosterBuilder.rules;

import rosterBuilder.entities.Entity;
import rosterBuilder.entities.Unit;

import java.io.Serializable;

public abstract class UnitBuildingRule implements Rule, Serializable {
    protected int unitRuleId;
    protected int unitProfileId;
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

    public Entity getEntity1() {
        return entity1;
    }

    public void setEntity1(Entity entity1) {
        this.entity1 = entity1;
    }

    public Entity getEntity2() {
        return entity2;
    }

    public void setEntity2(Entity entity2) {
        this.entity2 = entity2;
    }

    public int getModelQuantity() {
        return modelQuantity;
    }

    public void setModelQuantity(int modelQuantity) {
        this.modelQuantity = modelQuantity;
    }
}
