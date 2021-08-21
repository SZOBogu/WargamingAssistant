package rosterBuilder.pojos;

import java.util.ArrayList;

public class EntityContainer {
    private final ArrayList<Entity> entities;

    public EntityContainer(){
        this.entities = new ArrayList<>();
    }

    public EntityContainer(ArrayList<Entity> entities){
        this.entities = entities;
    }

    public boolean contains(Entity entity){
        for (Entity value : this.entities) {
            if (value == entity) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(String name){
        for (Entity entity : this.entities) {
            if (entity.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int size(){
        return this.entities.size();
    }

    public void add(Entity entity){
        this.entities.add(entity);
    }

    public void addAll(ArrayList<Entity> entities){
        this.entities.addAll(entities);
    }

    public ArrayList<Entity> getAll(){
        return this.entities;
    }

    public Entity get(int index){
        if(this.entities.get(index) instanceof Weapon){
            return new Weapon(this.entities.get(index).getName(),
                    this.entities.get(index).getDescription(), this.entities.get(index).getParameter(),
                    ((Weapon) this.entities.get(index)).getStatline());
        }
        else if(this.entities.get(index) instanceof Item){
            return new Item(this.entities.get(index).getName(),
                    this.entities.get(index).getDescription(), this.entities.get(index).getParameter());
        }
        else if(this.entities.get(index) instanceof SpecialRule){
            return new SpecialRule(this.entities.get(index).getName(),
                    this.entities.get(index).getDescription(), this.entities.get(index).getParameter());
        }
        else{
            return new Entity(this.entities.get(index).getName(),
                    this.entities.get(index).getDescription(), this.entities.get(index).getParameter());
        }
    }

    public Entity get(String name){
        for (Entity entity : this.entities) {
            if (entity.getName().equals(name)) {
                return entity;
            }
        }
        return null;
    }

    public void clear(){
        this.entities.clear();
    }

    public void remove(int index){
        this.entities.remove(index);
    }

    public void remove(String name){
        for(int i = 0; i < this.entities.size(); i++){
            if(this.entities.get(i).getName().equals(name)){
                this.entities.remove(i);
            }
        }
    }

}
