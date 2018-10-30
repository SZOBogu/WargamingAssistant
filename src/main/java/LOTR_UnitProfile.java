import java.util.ArrayList;

public class LOTR_UnitProfile extends UnitProfile{
    private StatsLOTR statline;

    public LOTR_UnitProfile(Entity entity, StatsLOTR stat, ArrayList<SpecialRule> srs){
        super(entity, srs);
        this.statline = stat;
    }

    public Entity getEntity() {
        return super.getEntity();
    }

    public StatsLOTR getStats() {
        return statline;
    }

    public ArrayList<SpecialRule> getSpecialRules() {
        return super.getSpecialRules();
    }
}
