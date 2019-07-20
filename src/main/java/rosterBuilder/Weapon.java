package rosterBuilder;

public class Weapon extends Item{

    private Statline statline;

    public Weapon(String name, String description){
        super(name, description);
        this.statline = new Statline();
    }

    public Weapon(String name, String description, String parameter){
        super(name, description, parameter);
        this.statline = new Statline();
    }

    public Weapon(String name, String description, Statline statline){
        super(name, description);
        this.statline = statline;
    }

    public Weapon(String name, String description, String parameter, Statline statline){
        super(name, description, parameter);
        this.statline = statline;
    }

    public Statline getStatline() {
        return statline;
    }
}
