package rosterBuilder.entities;

public class Item extends Entity {
    public Item() {super();}
    public Item(String name, String description) {
        super(name, description);
    }
    public Item(String name, String description, String parameter){
            super(name, description, parameter);
    }
}