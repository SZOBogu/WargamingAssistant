package rosterBuilder.pojos;

import rosterBuilder.pojos.Entity;

import java.util.ArrayList;
import java.util.List;

public class UniqueEntitiesPool {
    private List<Entity> available;
    private List<Entity> locked;

    public UniqueEntitiesPool(){
        this(new ArrayList<>());
    }

    public UniqueEntitiesPool(List<Entity> pool){
        this.available = pool;
        this.locked = new ArrayList<>();
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
