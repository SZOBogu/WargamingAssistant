package rosterBuilder.rules;

import rosterBuilder.pojos.Entity;
import rosterBuilder.pojos.Roster;

import java.io.Serializable;

public abstract class RosterBuildingRule implements Rule, Serializable {
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

    public abstract void check(Roster roster);
}
