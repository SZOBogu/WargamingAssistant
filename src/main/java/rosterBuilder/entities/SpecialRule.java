package rosterBuilder.entities;

public class SpecialRule extends Entity {
    /*
        Class just for the sake of readablilty.
        The code is easier to read when Special Rules are Special Rules, and not Entities.
     */
    public SpecialRule() {super();}

    public SpecialRule(String name, String description){
        super(name, description);
    }

    public SpecialRule(String name, String description, String parameter){
        super(name, description, parameter);
    }
}
