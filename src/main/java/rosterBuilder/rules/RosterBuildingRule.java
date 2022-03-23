package rosterBuilder.rules;

import rosterBuilder.entities.Entity;
import rosterBuilder.entities.Roster;

import java.io.Serializable;

public abstract class RosterBuildingRule implements Rule, Serializable {
    protected int rosterRuleId;
    protected Entity entity;
    protected int quantity;

    public RosterBuildingRule(Entity entity){
        this.entity = entity;
        this.quantity = 0;
    }

    public RosterBuildingRule(Entity entity, int quantity){
        this.entity = entity;
        this.quantity = quantity;
    }

    public Entity getEntity() {
        return entity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void check(Roster roster);
}
