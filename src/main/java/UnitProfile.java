import java.util.ArrayList;

public class UnitProfile {
    private Entity entity;  //name + description
    private ArrayList<SpecialRule> specialRules;

    public UnitProfile(Entity entity, ArrayList<SpecialRule> srs){
        this.entity = entity;
        this.specialRules = srs;
    }

    public Entity getEntity() {
        return entity;
    }

    public ArrayList<SpecialRule> getSpecialRules() {
        return specialRules;
    }
}
