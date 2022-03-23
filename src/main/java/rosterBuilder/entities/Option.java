package rosterBuilder.entities;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "option", schema = "wargaming_assistant")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(targetEntity = Entity.class, mappedBy = "option",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Entity entity;
    @Column(name = "cost")
    private int cost;

    public Option(){
        this.entity = new Entity();
        this.cost = 0;
    }
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
