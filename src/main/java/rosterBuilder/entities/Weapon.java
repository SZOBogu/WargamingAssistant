package rosterBuilder.entities;

import java.util.ArrayList;
import java.util.List;

public class Weapon extends Item{

    private List<Characteristic> statline;

    public Weapon(String name, String description){
        super(name, description);
        this.statline = new ArrayList<>();
    }

    public Weapon(String name, String description, String parameter){
        super(name, description, parameter);
        this.statline = new ArrayList<>();
    }

    public Weapon(String name, String description, List<Characteristic> statline){
        super(name, description);
        this.statline = statline;
    }

    public Weapon(String name, String description, String parameter, List<Characteristic> statline){
        super(name, description, parameter);
        this.statline = statline;
    }

    public List<Characteristic> getStatline() {
        return statline;
    }

    public void setStatline(List<Characteristic> statline) {
        this.statline = statline;
    }
}
