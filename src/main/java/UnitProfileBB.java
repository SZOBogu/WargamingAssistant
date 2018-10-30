import java.util.ArrayList;
//TODO: refactor

public class UnitProfileBB extends ModelProfile {
    private StatsBB statline;
    private ArrayList<SpecialRule> specialrules;

    public UnitProfileBB(Entity entity, StatsBB stat, ArrayList<SpecialRule> srs){
        super(entity);
        this.statline = stat;
        this.specialrules = srs;

    }

    public Entity getEntity() {
        return super.getEntity();
    }

    public StatsBB getStats() {
        return statline;
    }

    public ArrayList<SpecialRule> getSpecialRules() {
        return specialrules;
    }
}