package rosterBuilder;

public class Option {
    protected Entity entity;
    protected int cost;

    public Option(Entity entity, int cost){
        this.entity = entity;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public Entity getEntity() {
        return entity;
    }

    @Override
    public String toString() {
        return getEntity().getName() + "\t" + this.getCost() + "p";
    }
}
