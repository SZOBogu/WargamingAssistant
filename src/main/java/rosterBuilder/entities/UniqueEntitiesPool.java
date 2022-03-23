package rosterBuilder.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "uniqueEntitiesPool", schema = "wargaming_assistant")
public class UniqueEntitiesPool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "entity_id")
    private List<Entity> available;
    private List<Entity> locked;

    @OneToOne(targetEntity = WargamingSystem.class, mappedBy = "uniqueEntitiesPool",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private WargamingSystem wargamingSystem;

    public UniqueEntitiesPool(){
        this(new ArrayList<>());
    }

    public UniqueEntitiesPool(List<Entity> pool){
        this.available = pool;
        this.locked = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Entity> getAvailable() {
        return available;
    }

    public void setAvailable(List<Entity> available) {
        this.available = available;
    }

    public List<Entity> getLocked() {
        return locked;
    }

    public void setLocked(List<Entity> locked) {
        this.locked = locked;
    }

    public WargamingSystem getWargamingSystem() {
        return wargamingSystem;
    }

    public void setWargamingSystem(WargamingSystem wargamingSystem) {
        this.wargamingSystem = wargamingSystem;
    }

    public Entity get(String name){
        for(int i = 0; i < available.size(); i++){
            if(this.available.get(i).getName().equals(name)){
                Entity entity = this.available.get(i);
                this.locked.add(this.available.get(i));
                this.available.remove(i);
                return entity;
            }
        }
        return null;
    }

    public void release(Entity entity){
        for(int i = 0; i < locked.size(); i++){
            if(this.locked.get(i).getName().equals(entity.getName())){
                this.available.add(entity);
                this.locked.remove(i);
            }
        }
    }

    public boolean contains(Entity entity){
        return this.available.contains(entity) || this.locked.contains(entity);
    }
}
