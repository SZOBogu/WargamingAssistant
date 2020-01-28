package rosterBuilder;

import java.util.ArrayList;

public class UniqueEntitiesPool {
    private ArrayList<Entity> available;
    private ArrayList<Entity> locked;

    public UniqueEntitiesPool(ArrayList<Entity> pool){
        this.available = pool;
        this.locked = new ArrayList<>();
    }

    public ArrayList<Entity> getAvailable(){
        return this.available;
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
