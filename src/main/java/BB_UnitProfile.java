import java.util.ArrayList;
//TODO: refactor

public class BB_UnitProfile extends UnitProfile{
    private StatsBB statline;

    public BB_UnitProfile(Entity entity, StatsBB stat, ArrayList<SpecialRule> srs){
        super(entity, srs);
        this.statline = stat;
    }

    public Entity getEntity() {
        return super.getEntity();
    }

    public StatsBB getStats() {
        return statline;
    }

    public ArrayList<SpecialRule> getSpecialRules() {
        return super.getSpecialRules();
    }
}